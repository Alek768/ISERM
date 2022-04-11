package com.iserm.game.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapGroupLayer;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
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

    public Mine( Stage stage, OrthographicCamera cam, Viewport port, String name, int idMine){
        this.gamecam = cam;
        this.gamePort = port;
        this.s = stage;
        this.mine = map.getLayers().get(name);
        this.idMine = idMine;
        nom = name;
        afficher();

    }

    public String toString(){
        return nom;
    }


    public void afficher(){

        for (MapObject o : mine.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (!estExploree && GameScreen.zone.get(1).estDecouverte) {
                        GameScreen.fenetreExploration.setVisible(true);
                        indiceMineExploration = idMine;
                    }
                    else{
                        if(estExploree && GameScreen.zone.get(1).estDecouverte){
                            fenetreExploitation.setVisible(true);
                            indiceMineExploitation = idMine;

                        }
                    }
                }
            });

            s.addActor(A);
            if (estExploree) {
                A.setVisible(false);
            }
        }
    }


}

