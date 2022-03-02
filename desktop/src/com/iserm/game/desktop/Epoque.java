package com.iserm.game.desktop;

import java.util.ArrayList;

public class Epoque {

    private int dateDebut;
    private int dateFin;
    private String nom;
    private ArrayList<Minerais> listeDesMinerais = new ArrayList<>();
    /**
     * Permet de définir le minerais dominant de l'époque
     */
    private Minerais mineraisDominant;
    private boolean unlock;
    private Theme theme;


    public Epoque(int dateDebut, int dateFin, String nom, ArrayList<Minerais> listeDesMinerais, Minerais mineraisDominant, boolean unlock, int themeMusicale) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nom = nom;
        this.listeDesMinerais = listeDesMinerais;
        this.mineraisDominant = mineraisDominant;
        this.unlock = unlock;
        this.themeMusicale = themeMusicale;
    }

    /**
     * Cette méthode est appellée quand un joueur clique sur une époque
     *
     * @return Elle lui renvoi ainsi les infos necessaire sur l'époque concernée (peut être sous la forme d'une petite fenêtre pop-up?
     */
    public ArrayList<Minerais> questionnerLEpoque() {
        return null;
    }

    public int getDateDebut() {
        return dateDebut;
    }

    public int getDateFin() {
        return dateFin;
    }

    /**
     * Liste de getter
     */


    public String getNom() {
        return nom;
    }

    public ArrayList getListeDesMinerais() {
        return listeDesMinerais;
    }

    public Minerais getMineraisDominant() {
        return mineraisDominant;
    }

    public boolean isUnlock() {
        return unlock;
    }

    public int getThemeMusicale() {
        return themeMusicale;
    }
}
