package com.iserm.game;

import java.util.ArrayList;

public class Ressource {

    private String nom ;
    private double prix ;
    private double valeur ;
    private int apparence ;
    private String type;
    public boolean typeDeRessource ;
    static int idObjet;

    public Ressource(String nom, double prix, double valeur, int apparence) {
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
    public void setType(String Type){
        this.type = Type;
    }
    public String getType(){
        return type;
    }
}



