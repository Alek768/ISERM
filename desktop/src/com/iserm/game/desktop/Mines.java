package com.iserm.game.desktop;

import javax.swing.text.Element;
import java.lang.reflect.Array;
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
     * Cette méthode pourra être appellé par le joueur quand il choisira d'exploiter cette mine. Le processus de minage se lancera alors
     */
    public void Miner() {
    }


}
