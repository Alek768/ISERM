package com.iserm.game;

import java.util.ArrayList;

public class Mines {

    private String nom;
    private Minerais minerais;
    private int taille;


    public String getNom() {
        return nom;
    }

    public Minerais getMinerais() {
        return minerais;
    }

    public int getTaille() {
        return taille;
    }

    /**
     * Méthode permettant d'obtenir les infos de la mines quand le joueur clique sur la mine
     */
    public void obtenirInfo(){
    }


    /**
     * Cette méthode pourra être appellé par le joueur quand il choisira d'exploiter cette mine.
     * Le processus de minage se lancera alors. Le joueur aura un nombre donnée de ressources investi et
     * y consacrera un temps donnée. En fonction de cellle ci on aura un résultat plus ou moins bon.
     */
    public void Miner( double tempsInvesti , ArrayList <Ressource> ressourceInvesti ) {
    }


}
