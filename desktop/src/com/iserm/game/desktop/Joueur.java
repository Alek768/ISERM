package com.iserm.game.desktop;

import java.util.ArrayList;

public class Joueur {

    String Pseudo, Mail, Password;
    int Niveau, EXP, Argent;
    ArrayList<Ressource> Stockage = new ArrayList();

    public void Joueur(){

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
     * Ajoute un Niveau
     */
    void setLevel(){
        this.Niveau ++;
    }
}
