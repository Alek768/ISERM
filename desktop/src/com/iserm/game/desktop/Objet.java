package com.iserm.game.desktop;

public class Objet {

    /**
     * [Nom de l'Objet,Quantité]
     * Exemple : ["Or","3"].
     */
    Object [] Inv = new Object[2];

    public Objet(String Name, int Quantite){
        this.Inv[0] = Name;
        this.Inv[1] = Quantite;
    }

    /**
     * Ajoute une Quantité d'Objet.
     * @param Quantite
     */
    void ajoutObjet(int Quantite){
        this.Inv[1] = (int) this.Inv[1] + Quantite;
    }

    /**
     * Retire une Quantité d'Objet.
     * A Revoir
     * @param Quantite
     */
    void retireObjet(int Quantite){
        //if (Quantite > (int) this.Inv[1]){
        //    System.out.println("PROBLEME");
        //} elif (Quantite < (int) this.Inv[1]){
            this.Inv[1] = (int) this.Inv[1] - Quantite;
        //} else {
        //    this.Inv[1] = (int) this.Inv[1] - Quantite;
        //}
    }
}
