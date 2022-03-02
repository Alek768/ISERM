package com.iserm.game.desktop;

import java.util.ArrayList;

public class Ressource {

    private String nom ;
    private double valeur ;
    private int apparence ;
    private String type ;


    /**
     * Méthode permettant de définir le type de ressource : Monnaie, outils, mineurs ?
     * @param type Elle permettra in fine de changer le type d'objet de ressource.
     */
    public void setType(String type) {
        this.type = type;
    }



    public Ressource(String nom, double valeur, int apparence) {
        this.nom = nom;
        this.valeur = valeur;
        this.apparence = apparence;
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

    public String getType() {
        return type;
    }
}



