package com.iserm.game.desktop;

public class Outils {

    private String nom ;
    private double prix ;
    private double valeur ;
    private int apparence ;

    public Outils(String nom, double prix, double valeur, int apparence) {
        this.nom = nom;
        this.prix = prix;
        this.valeur = valeur;
        this.apparence = apparence;
    }

    /**
     * Méthode permettant d'obtenir les infos concernant l'outil quand le joueur clique dessus dans la boutique
     */
    public void obtenirInfo(){
    }
}
