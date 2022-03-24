package com.iserm.game.desktop;

import java.util.ArrayList;

public class Ressource {

    private String nom ;
    private double prix ;
    private double valeur ;
    private int apparence ;
    public boolean typeDeRessource ;
    static int idObjet;

    public Ressource(String nom, double prix, double valeur, int apparence, int idObjet) {
        this.nom = nom;
        this.prix = prix;
        this.valeur = valeur;
        this.apparence = apparence;
        this.idObjet = idObjet;
    }

    /**
     * Méthode permettant d'obtenir les infos concernant la ressource quand le joueur clique dessus dans la boutique
     * ou dans son inventaire
     */
    public void obtenirInfo(){
    }

    public ArrayList<Minerais> extraireDesMinerais (Mines mines, double tempsInvesti) {
        return null;
    }

}



