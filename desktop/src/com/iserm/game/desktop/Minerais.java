package com.iserm.game.desktop;

/**
 * Classe permettant de construire une objet de type minerais.
 */
public class Minerais {

    private String nom ;
    private int valeurEnOr;
    /**
     * Cet attribut défini la rareté d'un minerais. Quand une mines sera une mines de ce minerais, selon  sa taille,
     * ce coef de rareté entrera en jeu dans le nombre de minerais de la mines.
     */
    private double CoefDeRarete;

    /**
     * Je ne sais pas encore comment relier une texture graphique à un minerai donc j'ai mis type int en attendant
     */
    private int apparence ;


    /**
     * Selon le marché, la valeur d'un minerai peut être amené à fluctuer. Cette méthode sera alors appellée par une classe
     * bourse peut être pour modifier la valeur de ce minerais
     */
    public void modifierLaValeurEnOr () {

    }

    /**
     * Constructeut d'un objet minerais. L'apparence serait rattaché à une interface graphique
     * @param nom
     * @param valeurEnOr
     * @param coefDeRarete
     * @param apparence
     */
    public Minerais(String nom, int valeurEnOr, double coefDeRarete, int apparence) {
        this.nom = nom;
        this.valeurEnOr = valeurEnOr;
        CoefDeRarete = coefDeRarete;
        this.apparence = apparence;
    }




    //Série de getter

    public String getNom() {
        return nom;
    }

    public int getValeurEnOr() {
        return valeurEnOr;
    }

    public double getCoefDeRarete() {
        return CoefDeRarete;
    }

    public int getApparence() {
        return apparence;
    }
}
