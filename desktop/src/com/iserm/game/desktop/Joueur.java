package com.iserm.game.desktop;

import com.iserm.game.SQL;
import java.sql.*;

public class Joueur {

    public String Pseudo;
    private String Mail, Password;
    int Niveau, EXP, Argent;
    static int idPlayer = 0;
    Joueur Friends [] = new Joueur[50];

    public Joueur(int idPlayer){
        this.idPlayer = idPlayer;
    }
    public Joueur(String username, String mail, String password){
        this.idPlayer ++;
        this.Pseudo = username;
        this.Mail = mail;
        this.Password = password;
        this.Niveau = 1;
        this.EXP = 0;
        this.Argent = 0;
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
            this.Pseudo = r.getString(1);
            this.Mail = r.getString(2);
            this.Password = r.getString(3);
            this.Niveau = r.getInt(4);
            this.EXP = r.getInt(5);
            this.Argent = r.getInt(6);
            r.close();
        }
    }

    @Override
    public String toString(){
        return "Username: "+this.Pseudo+" Mail: "+this.Mail+" LVL: "+this.Niveau+" EXP: "+this.EXP+" Arg: "+this.Argent;
    }

    String getPseudo(){
        return this.Pseudo;
    }
    String getPassword(){
        return this.Password;
    }
    String getMail(){
        return this.Mail;
    }
    int getNiveau(){
        return this.Niveau;
    }

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
        this.EXP += value;
        //Ajout de niveau quand c'est nécessaire:
        double LvlUP = Math.pow(1.040306503,this.Niveau)*100;
        while (this.EXP >= LvlUP){
            ajoutNiveau(1,s);
            this.EXP -= LvlUP;
            LvlUP = Math.pow(1.040306503,this.Niveau)*100;
        }
        s.Update("UPDATE PLAYERS SET playerEXP = ? WHERE playerID = ?;",this.EXP,this.idPlayer);
    }

    /**
     * Ajoute un Niveau (value > 0)
     * Retire un Niveau (value < 0)
     */
    public void ajoutNiveau(int value, SQL s){
        //Ajout du niveau
        this.Niveau += value;
        s.Update("UPDATE PLAYERS SET playerLVL = ? WHERE playerID = ?;",this.Niveau,this.idPlayer);
    }

    /**
     * Ajout(value > 0) ou Retrait(value < 0) d'Argent
     * @param value
     * @param s
     */
    public void ajoutArgent(int value, SQL s){
        this.Argent += value;
        s.Update("UPDATE PLAYERS SET Argent = ? WHERE playerID = ?", this.Argent, this.idPlayer);
    }
}