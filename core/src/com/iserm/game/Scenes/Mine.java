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
    private TiledMap map ;
    private boolean mapmondevisible = true;
    private MapLayer mine;
    private MapGroupLayer mapmonde;
    public OrthogonalTiledMapRenderer renderer;
    private int idMine;
    private boolean estVisible;
    public boolean estExploree;
    public static int indiceMineExploration;

    public Mine(TiledMap map, Stage stage, OrthographicCamera cam, Viewport port, OrthogonalTiledMapRenderer rend, String name, int idMine){
        this.gamecam = cam;
        this.gamePort = port;
        this.s = stage;
        this.map = map;
        this.renderer = rend;
        this.mine = map.getLayers().get(name);
        this.idMine = idMine;

    }

    public void afficher(){

        for (MapObject o : mine.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (estExploree == false && GameScreen.zone.get(1).estDecouverte == true) {
                        GameScreen.fenetreexploration.setVisible(true);
                        indiceMineExploration = idMine;
                    } else {

                    }
                }
            });

            s.addActor(A);
            if (estExploree == true) {
                A.setVisible(false);
            }
        }
    }

    public void exploitation(){


        for (MapObject o : boutonEntree0.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (mine_0dejaexploree == true) {
                        fenetreexploitation.setVisible(true);
                        indiceMineExploration = 0;
                    }

                }
            });

            s.addActor(A);


        }

        for (MapObject o : boutonexploitationnon.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    fenetreexploitation.setVisible(false);
                }
            });

            s.addActor(A);



        }

        for (MapObject o : boutonexploitationoui.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {

                    fenetreexploitation.setVisible(false);


                    if (indiceMineExploration == 0) {
                        Rubis0.setVisible(true);
                    }

                    if (indiceMineExploration == 1) {
                        Rubis1.setVisible(true);
                    }

                    if (indiceMineExploration == 6) {
                        Rubis6.setVisible(true);
                    }






                }
            });
            s.addActor(A);
        }




        Gdx.input.setInputProcessor(s);

    }



}

