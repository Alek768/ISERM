package com.iserm.game.Scenes;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.iserm.game.screen.GameScreen;
import com.iserm.game.utils.Constants;

public class Mine extends Constants{
    public OrthographicCamera gamecam;
    public Viewport gamePort;
    public Stage s;
    private MapLayer mine;
    private int idMine;
    public boolean estExploree;
    public static int indiceMineExploration;
    public static int indiceMineExploitation;
    private String nom;
    private int indiceZone;


    /**
     * Méthode permettant de construire un objet de type Mines
     * @param stage Stage auquelle appartient la mine
     * @param cam rattache une camera à la stage auquelle appartient la mine
     * @param port rattapche le viewport à la stage auquelle appartient la mine
     * @param name Nom de la mine
     * @param idMine identifiant de la mine
     * @param indiceZone
     */
    public Mine( Stage stage, OrthographicCamera cam, Viewport port, String name, int idMine, int indiceZone){
        this.gamecam = cam;
        this.gamePort = port;
        this.s = stage;
        this.mine = map.getLayers().get(name);
        this.idMine = idMine;
        nom = name;
        this.indiceZone = indiceZone;
        afficher();

    }

    /**
     * Méthode permettant d'obtenir le nom de l'objet de type mines
     * @return retourne le nom de la mine
     */
    public String toString(){
        return nom;
    }

    /**
     * Permet d'afficher ou de faire disparaître l'objet concerné sur la map Tiled. Vérifie certaine conditions afin
     * d'éviter la triche
     */
    public void afficher(){

        for (MapObject o : mine.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (!estExploree){
                        GameScreen.fenetreExploration.setVisible(true);
                        GameScreen.fouiller(s);
                        indiceMineExploration = idMine;
                    }
                    else{
                        GameScreen.exploitation(s);
                        System.out.println("exploitaion");
                        fenetreExploitation.setVisible(true);
                        indiceMineExploitation = idMine;

                    }
                }
            });

            s.addActor(A);
        }
    }


}

