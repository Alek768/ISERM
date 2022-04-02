package com.iserm.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.iserm.game.IserMain;
import com.iserm.game.Scenes.Hud;

import java.awt.*;
import java.util.ArrayList;

public class GameScreen implements Screen {

    //Variables fenêtres d'affichage
    private final MapLayer fenetredecouverte;
    private final MapLayer fenetreexploration;


    //Variable des mines
    private final MapLayer mine0;
//    private final MapLayer mine1;
//    private final MapLayer mine2;
//    private final MapLayer mine3;
//    private final MapLayer mine4;
//    private final MapLayer mine5;
//    private final MapLayer mine6;
//    private final MapLayer mine7;
//    private final MapLayer mine8;
//    private final MapLayer mine9;
//    private final MapLayer mine10;
//    private final MapLayer mine11;
//    private final MapLayer mine12;
//    private final MapLayer mine13;
//    private final MapLayer mine14;
//    private final MapLayer mine15;
//    private final MapLayer mine16;
//    private final MapLayer mine17;
//    private final MapLayer mine18;
//    private final MapLayer mine19;
//    private final MapLayer mine20;
//    private final MapLayer mine21;
//    private final MapLayer mine22;


    //Variables de zone
    private final MapLayer zone1;
    private final MapLayer zone2;
    private final MapLayer zone3;
    private final MapLayer zone4;
    private final MapLayer zone5;
    private final MapLayer zone6;

    //Variables de nuage
    private final MapLayer nuage1;
    private final MapLayer nuage2;
    private final MapLayer nuage3;
    private final MapLayer nuage4;
    private final MapLayer nuage5;
    private final MapLayer nuage6;

    //Variables bouton
    private final MapLayer boutondecouverteoui;
    private final MapLayer boutondecouvertenon;
    private final MapLayer boutonexplorationoui;
    private final MapLayer boutonexplorationnon;




    int conditionzone;


    int conditionouizone1 = 0;
    int conditionouizone2 = 0;
    int conditionouizone3 = 0;
    int conditionouizone4 = 0;
    int conditionouizone5 = 0;
    int conditionouizone6 = 0;


    private IserMain game;
    //Texture texture;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private Hud hud;


    private TmxMapLoader maploader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    /*
    private Viewport gameport;
    */
    /*
    private Hud hud;
    */

    public GameScreen(IserMain game) {
        this.game = game;
        //texture = new Texture("badlogic.jpg");
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(1280, 720, gamecam);
        hud = new Hud(game.batch);
        maploader = new TmxMapLoader();
        map = maploader.load("ui/maps/Maps_1.tmx");

        renderer = new OrthogonalTiledMapRenderer(map);
        gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);

        Stage s = new Stage(gamePort);

        //Fenêtres d'affichage
        fenetredecouverte = map.getLayers().get("Decouverte");
        fenetreexploration = map.getLayers().get("explorer mines");


        //Zones
        zone1 = map.getLayers().get("Zone1");
        zone2 = map.getLayers().get("Zone2");
        zone3 = map.getLayers().get("Zone3");
        zone4 = map.getLayers().get("Zone4");
        zone5 = map.getLayers().get("Zone5");
        zone6 = map.getLayers().get("Zone6");

        //Mines
        mine0 = map.getLayers().get("Mine_0");
//        mine1 = map.getLayers().get("Mine_1");
//        mine2 = map.getLayers().get("Mine_2");
//        mine3 = map.getLayers().get("Mine_3");
//        mine4 = map.getLayers().get("Mine_4");
//        mine5 = map.getLayers().get("Mine_5");
//        mine6 = map.getLayers().get("Mine_6");
//        mine7 = map.getLayers().get("Mine_7");
//        mine8 = map.getLayers().get("Mine_8");
//        mine9 = map.getLayers().get("Mine_9");
//        mine10 = map.getLayers().get("Mine_10");
//        mine11 = map.getLayers().get("Mine_11");
//        mine12 = map.getLayers().get("Mine_12");
//        mine13 = map.getLayers().get("Mine_13");
//        mine14 = map.getLayers().get("Mine_14");
//        mine15 = map.getLayers().get("Mine_15");
//        mine16 = map.getLayers().get("Mine_16");
//        mine17 = map.getLayers().get("Mine_17");
//        mine18 = map.getLayers().get("Mine_18");
//        mine19 = map.getLayers().get("Mine_19");
//        mine20 = map.getLayers().get("Mine_20");
//        mine21 = map.getLayers().get("Mine_21");
//        mine22 = map.getLayers().get("Mine_22");


        //Nuages
        nuage1 = map.getLayers().get("Nuage_Zone1");
        nuage2 = map.getLayers().get("Nuage_Zone2");
        nuage3 = map.getLayers().get("Nuage_Zone3");
        nuage4 = map.getLayers().get("Nuage_Zone4");
        nuage5 = map.getLayers().get("Nuage_Zone5");
        nuage6 = map.getLayers().get("Nuage_Zone6");

        //Boutons
        boutondecouverteoui = map.getLayers().get("Bouton oui_decouverte");
        boutondecouvertenon = map.getLayers().get("Bouton non_decouverte");
        boutonexplorationoui = map.getLayers().get("Bouton oui_exploration");
        boutonexplorationnon = map.getLayers().get("Bouton non_exploration");


        for (MapObject o : zone1.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (conditionouizone1 == 0) {


                        fenetredecouverte.setVisible(true);
                        conditionzone = 1;


                    } else {

                    }
                }
            });

            s.addActor(A);


        }


        for (MapObject o : zone2.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (conditionouizone2 == 0) {


                        fenetredecouverte.setVisible(true);
                        conditionzone = 2;
                    } else {

                    }
                }

            });

            s.addActor(A);


        }


        for (MapObject o : zone3.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (conditionouizone3 == 0) {


                        fenetredecouverte.setVisible(true);
                        conditionzone = 3;
                    } else {

                    }
                }

            });

            s.addActor(A);


        }


        for (MapObject o : zone4.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (conditionouizone4 == 0) {

                        fenetredecouverte.setVisible(true);
                        conditionzone = 4;

                    } else {

                    }


                }
            });

            s.addActor(A);


        }


        for (MapObject o : zone5.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (conditionouizone5 == 0) {
                        fenetredecouverte.setVisible(true);
                        conditionzone = 5;
                    } else {

                    }
                }
            });

            s.addActor(A);


        }


        for (MapObject o : zone6.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (conditionouizone6 == 0) {
                        fenetredecouverte.setVisible(true);
                        conditionzone = 6;
                    } else {

                    }


                }
            });

            s.addActor(A);


        }


        for (MapObject o : boutondecouverteoui.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    fenetredecouverte.setVisible(false);
                    if (conditionzone == 1) {
                        nuage1.setVisible(false);
                        conditionouizone1 = 1;


                    }
                    if (conditionzone == 2) {
                        nuage2.setVisible(false);
                        conditionouizone2 = 1;

                    }
                    if (conditionzone == 3) {
                        nuage3.setVisible(false);
                        zone3.setVisible(false);
                        conditionouizone3 = 1;

                    }
                    if (conditionzone == 4) {
                        nuage4.setVisible(false);
                        zone4.setVisible(false);
                        conditionouizone4 = 1;

                    }
                    if (conditionzone == 5) {
                        nuage5.setVisible(false);
                        zone5.setVisible(false);
                        conditionouizone5 = 1;

                    }
                    if (conditionzone == 6) {
                        nuage6.setVisible(false);
                        zone6.setVisible(false);
                        conditionouizone6 = 1;

                    }
                }
            });

            s.addActor(A);

        }

        for (MapObject o : boutondecouvertenon.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    fenetredecouverte.setVisible(false);
                }
            });

            s.addActor(A);

        }

        for (MapObject o : mine0.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    fenetreexploration.setVisible(true);


                }
            });

            s.addActor(A);


        }


        for (MapObject o : boutondecouvertenon.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    fenetredecouverte.setVisible(false);
                }
            });

            s.addActor(A);


        }

        for (MapObject o : boutonexplorationnon.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    fenetreexploration.setVisible(false);
                }
            });

            s.addActor(A);


        }

        Gdx.input.setInputProcessor(s);
    }



    @Override
    public void show () {

    }

    @Override
    public void render ( float delta){
        //clear the game screen with black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setView(gamecam);

        renderer.render();

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
        /**

         game.batch.setProjectionMatrix(gamecam.combined);
         game.batch.begin();
         game.batch.draw(texture, 0, 0);
         game.batch.end();

         */

    }

    @Override
    public void resize ( int width, int height){
        gamePort.update(width, height);

    }

    @Override
    public void pause () {

    }

    @Override
    public void resume () {

    }

    @Override
    public void hide () {

    }

    @Override
    public void dispose () {

    }

    public void handleInput () {

    }
}