package com.iserm.game.desktop;

import java.util.ArrayList;

public class Joueur {

    /**
     * Informations 'Personnelles' du Joueur.
     * Trouver une sécurité pour le mot de passe.
     */
    private String Pseudo, Mail, Password;
    /**
     * Informations In-Game du Joueur.
     * 1st Connexion Niveau = 1, EXP = 0, Argent = 500 (à revoir).
     * Credit : Monnaie Achetable en Boutique.
     */
    private int Niveau, EXP, Argent, Credit;
    static int nbAmis = 0;

    /**
     * Informations sur 'L'inventaire' du Joueur.
     * Liste [Nom de l'objet, Quantité]
     */
    ArrayList<Objet> Stockage = new ArrayList();

    /**
     * Le Joueur pourra avoir des Ami.e.s
     * Stockage sous forme de Tableau.
     * Maximum 50 Ami.e.s
     */
    Joueur [] Amis = new Joueur[50];

    public Joueur(String Pseudo, String Mail, String Password, int Niveau, int EXP, int Argent, int Credit) {
        this.Pseudo = Pseudo;
        this.Mail = Mail;
        this.Password = Password;
        this.Niveau = Niveau;
        this.EXP = EXP;
        this.Argent = Argent;
        this.Credit = Credit;
    }

    @Override
    public String toString() {
        return "Joueur : " + Pseudo + " | " + Niveau + " | " + EXP + " | " + Argent;
    }

    /**
     * Getter des informations.
     * @return
     */
    String getPseudo() {
        return this.Pseudo;
    }

    String getPassword() {
        return this.Password;
    }

    String getMail() {
        return this.Mail;
    }

    int getNiveau() {
        return this.Niveau;
    }

    int getEXP() {
        return this.EXP;
    }

    int getArgent() {
        return this.Argent;
    }

    /**
     * Modifie le Pseudo
     * @param newPseudo
     */
    void setPseudo(String newPseudo) {
        this.Pseudo = newPseudo;
    }

    /**
     * Modifie l'Adresse Mail
     * @param newMail
     */
    void setMail(String newMail) {
        this.Mail = newMail;
    }

    /**
     * Modifie de Mot de Passe
     * @param newPassword
     */
    void setPassword(String newPassword) {
        this.Password = newPassword;
    }

    /**
     * Ajoute un Niveau
     * Définir un modèle de passage de Niveau.
     */
    void setLevel() {
        this.Niveau++;
    }

    /**
     * Ajoute un Ami.
     * @param JoueurAmi
     */
    void ajoutAmi(Joueur JoueurAmi){
        this.Amis[nbAmis] = JoueurAmi;
        nbAmis ++;
    }

    /**
     * Supprime un Ami.
     * @param JoueurAmi
     */
    void retireAmi(Joueur JoueurAmi){
        nbAmis --;
    }
}