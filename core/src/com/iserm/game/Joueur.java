package com.iserm.game;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Joueur {

    public String pseudo;
    private String mail, password;
    private int niveau, exp, argent;
    static int idPlayer = 0;
    Joueur Friends [] = new Joueur[50];

    public Joueur(int idPlayer){
        this.idPlayer = idPlayer;
    }
    public Joueur(String username, String mail, String password){
        this.idPlayer ++;
        this.pseudo = username;
        this.mail = mail;
        this.password = password;
        this.niveau = 1;
        this.exp = 0;
        this.argent = 0;
    }

    public int getNiveau(){
        return niveau;
    }

    public int getExp() {
        return exp;
    }

    public int getArgent() {
        return argent;
    }

    /**
     * Première connection (0 Compte) -> Création de Joueur Jeu et BDD
     * @param username
     * @param password
     * @param s
     */
    public void configSQL(String mail, String username, String password, SQL s){
        //Création SQL:
        s.UpdateString("INSERT INTO PLAYERS (mail, password, username, playerEXP, playerLVL, Argent, isAdmin) VALUES(?, ?, ?, 0, 1, 0, FALSE);",mail,username,password);
    }
    /**
     * Deuxième ou + connection
     * @param s
     * @throws SQLException
     */
    public void config(SQL s) throws SQLException {
        ResultSet r = s.Request1("SELECT username, mail, password, playerLVL, playerEXP, Argent FROM PLAYERS WHERE playerID = ?", this.idPlayer);
        if(r.next()) {
            this.pseudo = r.getString(1);
            this.mail = r.getString(2);
            this.password = r.getString(3);
            this.niveau = r.getInt(4);
            this.exp = r.getInt(5);
            this.argent = r.getInt(6);
            r.close();
        }
    }

    @Override
    public String toString(){
        return "Username: "+this.pseudo +" Mail: "+this.mail +" LVL: "+this.niveau +" EXP: "+this.exp +" Arg: "+this.argent;
    }

    String getPseudo(){
        return this.pseudo;
    }
    String getPassword(){
        return this.password;
    }
    String getMail(){
        return this.mail;
    }


    /**
     * Modifie le Pseudo
     * @param newPseudo
     */
    void setPseudo(String newPseudo){
        this.pseudo = newPseudo;
    }
    /**
     * Modifie l'Adresse Mail
     * @param newMail
     */
    void setMail(String newMail){
        this.mail = newMail;
    }
    /**
     * Modifie de Mot de Passe
     * @param newPassword
     */
    void setPassword(String newPassword){
        this.password = newPassword;
    }

    /**
     * Ajout(quantite > 0) ou Retrait(quantite < 0) de Ressources
     * @param r
     * @param quantite
     * @param s
     */
    void ajoutRessource(Ressource r, int quantite, SQL s){
        s.Update("UPDATE INVENTAIRE SET quantite = quantite + ? WHERE playerID = 1 AND objetID = ?",quantite, r.idObjet);
    }
    void retraitRessource(Ressource r, int quantite, SQL s){
        s.Update("UPDATE INVENTAIRE SET quantite = quantite - ? WHERE playerID = 1 AND objetID = ?",quantite, r.idObjet);
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
        this.exp += value;
        //Ajout de niveau quand c'est nécessaire:
        double LvlUP = Math.pow(1.040306503,this.niveau)*100;
        while (this.exp >= LvlUP){
            ajoutNiveau(1,s);
            this.exp -= LvlUP;
            LvlUP = Math.pow(1.040306503,this.niveau)*100;
        }
        s.Update("UPDATE PLAYERS SET playerEXP = ? WHERE playerID = ?;",this.exp,this.idPlayer);
    }

    /**
     * Ajoute un Niveau (value > 0)
     * Retire un Niveau (value < 0)
     */
    public void ajoutNiveau(int value, SQL s){
        //Ajout du niveau
        this.niveau += value;
        s.Update("UPDATE PLAYERS SET playerLVL = ? WHERE playerID = ?;",this.niveau,this.idPlayer);
    }

    /**
     * Ajout(value > 0) ou Retrait(value < 0) d'Argent
     * @param value
     * @param s
     */
    public void ajoutArgent(int value, SQL s){
        this.argent += value;
        s.Update("UPDATE PLAYERS SET Argent = ? WHERE playerID = ?", this.argent, this.idPlayer);
    }
}