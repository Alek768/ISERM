package com.iserm.game;

/**
 * Classe permettant de construire le thème qui est différent selon les époques
 */
public class Theme {


    /**
     * Chaque thème aura une musique de fond, une maps ect. Le type pour l'instant n'est pas connu je met des int
     */
    public int music ;
    public int maps ;
    public int couleurDominante ;
    public int ect ;

    public Theme(int music, int maps, int couleurDominante, int ect) {
        this.music = music;
        this.maps = maps;
        this.couleurDominante = couleurDominante;
        this.ect = ect;
    }

    /**
     * Méthode permettant d'associer un thème à une époque
     * @param epoque
     */
    public void associerUnTheme (Epoque epoque){
    }


}
