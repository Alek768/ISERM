package com.iserm.game.desktop;

public class Objet {

    String Name;
    int Quantite;

    public Objet(String Name, int Quantite){
        this.Name = Name;
        this.Quantite = Quantite;
    }

    /**
     * Ajoute une Quantité d'Objet.
     * @param Quantite
     */
    void ajoutObjet(int Quantite){
        this.Quantite += Quantite;
    }

    /**
     * Retire une Quantité d'Objet.
     * A Revoir
     * @param Quantite
     */
    void retireObjet(int Quantite){
        if (Quantite > this.Quantite){
            System.out.println("PROBLEME");
        } else {
            this.Quantite -= Quantite;
        }
    }
}
