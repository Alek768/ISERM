package com.iserm.game;

import java.sql.*;

public class Joueur {

    public String Pseudo, epoque;
    private String Mail, Password;
    int Niveau, EXP, Argent;
    static int idPlayer = 0;
    //Joueur Friends [] = new Joueur[50];


    /**
     * Méthode permettant de construire un objet de type joueur
     * @param idPlayer
     */
    public Joueur(int idPlayer){
        this.idPlayer = idPlayer;
    }
    public Joueur(String username, String mail, String password){
        this.Pseudo = username;
        this.Mail = mail;
        this.Password = password;
        this.Niveau = 1;
        this.EXP = 0;
        this.Argent = 2500;
    }
    public Joueur(String username, String mail, String password,int lvl, int exp, int argent){
        this.Pseudo = username;
        this.Mail = mail;
        this.Password = password;
        this.Niveau = lvl;
        this.EXP = exp;
        this.Argent = argent;
    }

    /**
     * Première connection (0 Compte) -> Création de Joueur Jeu et BDD
     * @param username
     * @param password
     * @param s
     */
    public void configSQL(String mail, String username, String password, SQL s) throws SQLException{
        //Création SQL:
        s.UpdateString("INSERT INTO PLAYERS (mail, password, username, playerEXP, playerLVL, playerMoney, lastLogin, isAdmin) VALUES(?, ?, ?, 0, 1, 0, STR_TO_DATE(SYSDATE(),'YYYY-DD-MM HH24:MI'), FALSE);",mail,password,username);
        ResultSet r = s.RequestString("SELECT playerID FROM PLAYERS WHERE mail = ? AND password = ?;", this.Mail, this.getPassword());
        if (r.next()){
            this.idPlayer = r.getInt(1);
            r.close();
        }
    }

    public void config1(String mail, String password, SQL s) throws SQLException{
        ResultSet r = s.RequestString("SELECT username, playerLVL, playerEXP, Argent FROM PLAYERS WHERE mail = ? and password = ?",mail,password);
        if (r.next()){
            this.Pseudo = r.getString(1);
            this.Mail = mail;
            this.Password = password;
            this.Niveau = r.getInt(2);
            this.EXP = r.getInt(3);
            this.Argent = r.getInt(4);
            r.close();
        }
    }


    /**
     * Login : Pseudo + Password || Mail + Password
     * @param s1
     * @param password
     * @param s
     * @throws SQLException
     */
    public void config(String s1, String password, SQL s) throws SQLException{
        if(isMail(s1,password,s)){
            ResultSet r = s.RequestString("SELECT username, playerLVL, playerEXP, playerMoney FROM PLAYERS WHERE mail = ? and password = ?",s1,password);
            if (r.next()){
                this.Pseudo = r.getString(1);
                this.Mail = s1;
                this.Password = password;
                this.Niveau = r.getInt(2);
                this.EXP = r.getInt(3);
                this.Argent = r.getInt(4);
                r.close();
            }
        }
        else if (isUsername(s1,password,s)){
            ResultSet r = s.RequestString("SELECT mail, playerLVL, playerEXP, playerMoney FROM PLAYERS WHERE username = ? and password = ?",s1,password);
            if (r.next()){
                this.Pseudo = s1;
                this.Mail = r.getString(1);
                this.Password = password;
                this.Niveau = r.getInt(2);
                this.EXP = r.getInt(3);
                this.Argent = r.getInt(4);
                r.close();
            }
        }
    }

    /**
     * Vérifie si la chaîne de caractère est la mail du joueur
     * @param mail mail concerné
     * @param password mot de passe
     * @param s Permet de communiquer à la base de donnée
     * @return
     * @throws SQLException
     */
    private boolean isMail(String mail, String password, SQL s) throws SQLException{
        boolean b = false;
        ResultSet r = s.RequestString("SELECT COUNT(*) FROM PLAYERS WHERE mail = ? and password = ?", mail, password);
        if (r.next()) {
            b = r.getInt(1) != 0;
            r.close();
        }
        return b;
    }

    /**
     * Même méthode que isMail mais pour le Username
     * @param username usermane concerné
     * @param password mot de passe
     * @param s Permet de communiquer avec la base de donnée
     * @return
     * @throws SQLException
     */
    private boolean isUsername(String username, String password, SQL s) throws SQLException {
        boolean b = false;
        ResultSet r = s.RequestString("SELECT COUNT(*) FROM PLAYERS WHERE username = ? and password = ?;",username,password);
        if (r.next()){
            b = r.getInt(1) != 0;
            r.close();
        }
        return b;
    }
    /**
     * Deuxième ou + connection avec l'idPlayer
     * @param s
     * @throws SQLException
     */
    public void config(SQL s) throws SQLException {
        ResultSet r = s.Request1("SELECT username, mail, password, playerLVL, playerEXP, playerMoney, epoque FROM PLAYERS WHERE playerID = ?", this.idPlayer);
        //s.Update("UPDATE PLAYERS SET lastLogin = STR_TO_DATE(SYSDATE(),'YYYY-DD-MM HH24:MI') WHERE playerID = ?;",this.idPlayer);
        if(r.next()) {
            this.Pseudo = r.getString(1);
            this.Mail = r.getString(2);
            this.Password = r.getString(3);
            this.Niveau = r.getInt(4);
            this.EXP = r.getInt(5);
            this.Argent = r.getInt(6);
            this.epoque = r.getString(7);
            r.close();
        }
    }

    @Override
    /**
     * Méthode toString
     */
    public String toString(){
        return "Username: "+this.Pseudo+" Mail: "+this.Mail+" LVL: "+this.Niveau+" EXP: "+this.EXP+" Arg: "+this.Argent;
    }

    public String getPseudo(){
        return this.Pseudo;
    }
    public String getPassword(){
        return this.Password;
    }
    public String getMail(){
        return this.Mail;
    }
    public int getNiveau(){
        return this.Niveau;
    }
    public int getArgent(){ return this.Argent;}

    /**
     * Modifie le Pseudo
     * @param newPseudo
     */
    void setPseudo(String newPseudo){
        this.Pseudo = newPseudo;
    }
    /**
     * Modifie l'Adresse Mail
     * @param newMail
     */
    void setMail(String newMail){
        this.Mail = newMail;
    }
    /**
     * Modifie de Mot de Passe
     * @param newPassword
     */
    void setPassword(String newPassword){
        this.Password = newPassword;
    }

    /**
     * Ajout(quantite > 0) ou Retrait(quantite < 0) de Ressources
     * @param r
     * @param quantite
     * @param s
     */
    void ajoutRessource(Ressource r, int quantite, SQL s) throws SQLException{
        if (quantite >= 0) {
            s.Update("UPDATE INVENTAIRE SET quantite = quantite + ? WHERE playerID = 1 AND objetID = ?",quantite, r.idObjet);
            s.Update("INSERT INTO TRANSACTIONS (player1, player2, type, amount) VALUES (?, 0, 'Ressource', ?);",this.idPlayer, quantite);
        }
        else {
            retraitRessource(r,-quantite,s);
        }
    }

    /**
     * Méthode permettant de retirer des ressources
     * @param r Ressource à retirer
     * @param quantite Quantité à retirer
     * @param s Permet de communiquer avec la base de donnée
     * @throws SQLException
     */
    void retraitRessource(Ressource r, int quantite, SQL s) throws SQLException{
        ResultSet re = s.Request2("SELECT quantite FROM INVENTAIRE WHERE playerID = ? and objetID = ?", this.idPlayer, r.idObjet);
        if (quantite >= 0){
            try {
                if (re.next()){
                    if (re.getInt(1) >= quantite){
                        s.Update("UPDATE INVENTAIRE SET quantite = quantite - ? WHERE playerID = 1 AND objetID = ?",quantite, r.idObjet);
                    }
                    re.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            ajoutRessource(r,-quantite, s);
        }
    }

    /**
     * Ajoute de l'exp au joueur. (value > 0)
     * Retire de l'exp au joueur. (value < 0)
     * TEST : J(Joueur LVL 1, 0EXP) -> J.ajoutEXP(100,s); s.Request("SELECT * FROM PLAYERS;");
     * -> Console: 1 admin1@admin unknown admin1 0 2 1 1
     * @param value
     * @param s
     */
    public void ajoutEXP(int value, SQL s){
        //Ajout d'EXP:
        this.EXP += value;
        //Ajout de niveau quand c'est nécessaire:
        double LvlUP = Math.pow(1.040306503,this.Niveau)*100;
        while (this.EXP >= LvlUP){
            ajoutNiveau(1,s);
            this.EXP -= LvlUP;
            LvlUP = Math.pow(1.040306503,this.Niveau)*100;
        }
        s.Update("UPDATE PLAYERS SET playerEXP = ? WHERE playerID = ?;",this.EXP,this.idPlayer);
        s.Update("INSERT INTO TRANSACTIONS (player1, player2, type, amount) VALUES (?, 0, 'EXP', ?);",this.idPlayer, value);
    }

    /**
     * Ajoute un Niveau (value > 0)
     * Retire un Niveau (value < 0)
     */
    public void ajoutNiveau(int value, SQL s){
        //Ajout du niveau
        this.Niveau += value;
        s.Update("UPDATE PLAYERS SET playerLVL = ? WHERE playerID = ?;",this.Niveau,this.idPlayer);
        s.Update("INSERT INTO TRANSACTIONS (player1, player2, type, amount) VALUES (?, 0, 'LVL', ?);",this.idPlayer, value);
    }

    /**
     * Ajout(value > 0) ou Retrait(value < 0) d'Argent
     * @param value
     * @param s
     */
    public void ajoutArgent(int value, SQL s){
        if (enoughMoney(value)){
            this.Argent += value;
            s.Update("UPDATE PLAYERS SET playerMoney = ? WHERE playerID = ?", this.Argent, this.idPlayer);
            s.Update("INSERT INTO TRANSACTIONS (player1, player2, type, amount) VALUES (?, 0, 'Argent', ?)", this.idPlayer, value);
        }
    }

    /**
     * Vérifie si le Joueur peut payer.
     * @param value
     * @return
     */
    public boolean enoughMoney(int value){
        return (this.getArgent() + value >= 0);
    }
}