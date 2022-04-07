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
    private final MapLayer fenetrefail;
    private final MapLayer fenetrereussiteexploration;
    private final MapLayer fenetreexploitation;

    //Variables entrees
    private final MapLayer Entree0;
    private final MapLayer Entree1;
    private final MapLayer Entree6;
    private final MapLayer Entree8;
    private final MapLayer Entree16;
    private final MapLayer Entree19;

    private final MapLayer BoutonEntree0;
    private final MapLayer BoutonEntree1;
    private final MapLayer BoutonEntree6;
    private final MapLayer BoutonEntree8;
    private final MapLayer BoutonEntree16;
    private final MapLayer BoutonEntree19;

    //Variables Rubis
    private final MapLayer Rubis0;
    private final MapLayer Rubis1;
    private final MapLayer Rubis6;



    //Variable des mines
    private final MapLayer mine0;
    private final MapLayer mine1;
    private final MapLayer mine2;
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
    private final MapLayer boutonexploitationoui;
    private final MapLayer boutonexploitationnon;
    private final MapLayer boutonfailok;
    private final MapLayer boutonreussiteexploration;

    //Mines valables
    ArrayList minesexploration = new ArrayList<Integer>();



    //Variables pour mines
    int indicemineexploration;
    int indicemineexploitation;
    boolean mine_0dejaexploree;
    boolean mine_1dejaexploree;
    boolean mine_2dejaexploree;
    boolean mine_3dejaexploree;
    boolean mine_4dejaexploree;
    boolean mine_5dejaexploree;
    boolean mine_6dejaexploree;
    boolean mine_7dejaexploree;
    boolean mine_8dejaexploree;
    boolean mine_9dejaexploree;
    boolean mine_10dejaexploree;
    boolean mine_11dejaexploree;
    boolean mine_12dejaexploree;
    boolean mine_13dejaexploree;
    boolean mine_14dejaexploree;
    boolean mine_15dejaexploree;
    boolean mine_16dejaexploree;
    boolean mine_17dejaexploree;
    boolean mine_18dejaexploree;
    boolean mine_19dejaexploree;
    boolean mine_20dejaexploree;
    boolean mine_21dejaexploree;
    boolean mine_22dejaexploree;

    boolean mine_0enexploitation;
    boolean mine_1enexploitation;
    boolean mine_6enexploitation;
    boolean mine_8enexploitation;
    boolean mine_16enexploitation;
    boolean mine_19enexploitation;








    //Variables pour nuage
    int indicezoneendecouverte;
    boolean conditionzone_1dejadecouverte ;
    boolean conditionzone_2dejadecouverte ;
    boolean conditionzone_3dejadecouverte ;
    boolean conditionzone_4dejadecouverte ;
    boolean conditionzone_5dejadecouverte ;
    boolean conditionzone_6dejadecouverte ;




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
        fenetrefail = map.getLayers().get("Fail");
        fenetrereussiteexploration = map.getLayers().get("Mines trouvee");
        fenetreexploitation = map.getLayers().get("Decision exploitation");


        //Zones
        zone1 = map.getLayers().get("Zone1");
        zone2 = map.getLayers().get("Zone2");
        zone3 = map.getLayers().get("Zone3");
        zone4 = map.getLayers().get("Zone4");
        zone5 = map.getLayers().get("Zone5");
        zone6 = map.getLayers().get("Zone6");

        //Mines
        mine0 = map.getLayers().get("Mine_0");
        mine1 = map.getLayers().get("Mine_1");
        mine2 = map.getLayers().get("Mine_2");
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

        //Entrées
        Entree0 = map.getLayers().get("Entree0");
        Entree1 = map.getLayers().get("Entree1");
        Entree6 = map.getLayers().get("Entree6");
        Entree8 = map.getLayers().get("Entree8");
        Entree16 = map.getLayers().get("Entree16");
        Entree19 = map.getLayers().get("Entree019");

        BoutonEntree0 = map.getLayers().get("Entree_0");
        BoutonEntree1 = map.getLayers().get("Entree_1");
        BoutonEntree6 = map.getLayers().get("Entree_6");
        BoutonEntree8 = map.getLayers().get("Entree_8");
        BoutonEntree16 = map.getLayers().get("Entree_16");
        BoutonEntree19 = map.getLayers().get("Entree_19");

        Rubis0 = map.getLayers().get("Ruby_0");
        Rubis1 = map.getLayers().get("Ruby_1");
        Rubis6 = map.getLayers().get("Ruby_6");



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
        boutonexploitationoui = map.getLayers().get("Bouton oui_exploitation");
        boutonexploitationnon = map.getLayers().get("Bouton non_exploitation");
        boutonfailok = map.getLayers().get("Bouton ok_Fail");
        boutonreussiteexploration = map.getLayers().get("Bouton reussite_exploration");



        //Mines ok
        minesexploration.add(0);
        minesexploration.add(1);
        minesexploration.add(6);
        minesexploration.add(8);
        minesexploration.add(16);
        minesexploration.add(19);




        //Implémentation des zones nuageuses
        for (MapObject o : zone1.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (conditionzone_1dejadecouverte == false && fenetredecouverte.isVisible() == false ){


                        fenetredecouverte.setVisible(true);
                        indicezoneendecouverte = 1;


                    }

                    else {

                    }
                }
            });

            s.addActor(A);
            if (conditionzone_1dejadecouverte == true)
            {
                A.setVisible(false);
            }

        }


        for (MapObject o : zone2.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (conditionzone_2dejadecouverte == false && fenetredecouverte.isVisible() == false) {


                        fenetredecouverte.setVisible(true);
                        indicezoneendecouverte = 2;
                    }

                    else {

                    }
                }

            });

            s.addActor(A);
            if (conditionzone_2dejadecouverte == true)
            {
                A.setVisible(false);
            }


        }


        for (MapObject o : zone3.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (conditionzone_3dejadecouverte == false && fenetredecouverte.isVisible() == false) {


                        fenetredecouverte.setVisible(true);
                        indicezoneendecouverte = 3;
                    }

                    else {

                    }
                }

            });

            s.addActor(A);
            if (conditionzone_3dejadecouverte == true)
            {
                A.setVisible(false);
            }


        }


        for (MapObject o : zone4.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (conditionzone_4dejadecouverte == false && fenetredecouverte.isVisible() == false) {

                        fenetredecouverte.setVisible(true);
                        indicezoneendecouverte = 4;

                    }

                    else {

                    }


                }
            });

            s.addActor(A);
            if (conditionzone_4dejadecouverte == true)
            {
                A.setVisible(false);
            }


        }


        for (MapObject o : zone5.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (conditionzone_5dejadecouverte == false && fenetredecouverte.isVisible() == false) {
                        fenetredecouverte.setVisible(true);
                        indicezoneendecouverte = 5;
                    }

                    else {

                    }
                }
            });

            s.addActor(A);
            if (conditionzone_5dejadecouverte == true)
            {
                A.setVisible(false);
            }


        }


        for (MapObject o : zone6.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (conditionzone_6dejadecouverte == false && fenetredecouverte.isVisible() == false) {
                        fenetredecouverte.setVisible(true);
                        indicezoneendecouverte = 6;
                    }

                    else {

                    }


                }
            });

            s.addActor(A);
            if (conditionzone_6dejadecouverte == true)
            {
                A.setVisible(false);
            }


        }




            for (MapObject o : boutondecouverteoui.getObjects()) {
                Actor A = new Actor();
                Rectangle r = ((RectangleMapObject) o).getRectangle();
                A.setBounds(r.x, r.y, r.width, r.height);

                    A.addListener(new ClickListener() {

                        @Override
                        public void clicked(InputEvent event, float x, float y) {

                            fenetredecouverte.setVisible(false);

                            if (indicezoneendecouverte == 1) {
                                nuage1.setVisible(false);
                                conditionzone_1dejadecouverte = true;



                            }
                            if (indicezoneendecouverte == 2) {
                                nuage2.setVisible(false);
                                conditionzone_2dejadecouverte = true;

                            }
                            if (indicezoneendecouverte == 3) {
                                nuage3.setVisible(false);
                                zone3.setVisible(false);
                                conditionzone_3dejadecouverte = true;

                            }
                            if (indicezoneendecouverte == 4) {
                                nuage4.setVisible(false);
                                zone4.setVisible(false);
                                conditionzone_4dejadecouverte = true;

                            }
                            if (indicezoneendecouverte == 5) {
                                nuage5.setVisible(false);
                                zone5.setVisible(false);
                                conditionzone_5dejadecouverte = true;

                            }
                            if (indicezoneendecouverte == 6) {
                                nuage6.setVisible(false);
                                zone6.setVisible(false);
                                conditionzone_6dejadecouverte = true;

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



        //Implémentation des mines
        //Mine n° 0
        for (MapObject o : mine0.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (mine_0dejaexploree == false)
                    {
                        fenetreexploration.setVisible(true);
                        indicemineexploration = 0;
                    }

                    else
                    {

                    }
                }
            });

            s.addActor(A);
            if (mine_0dejaexploree == true)
            {
                A.setVisible(false);
            }



        }

        for (MapObject o : mine1.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (mine_1dejaexploree == false && conditionzone_1dejadecouverte == true)
                    {
                        fenetreexploration.setVisible(true);
                        indicemineexploration = 1;
                    }

                    else
                    {

                    }
                }
            });

            s.addActor(A);
            if (mine_1dejaexploree == true)
            {
                A.setVisible(false);
            }

        }

        for (MapObject o : mine2.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (mine_2dejaexploree == false && conditionzone_2dejadecouverte == true)
                    {
                        fenetreexploration.setVisible(true);
                        indicemineexploration = 2;
                    }

                    else
                    {

                    }
                }
            });

            s.addActor(A);
            if (mine_2dejaexploree == true)
            {
                A.setVisible(false);
            }


        }


            for (MapObject o : boutonexplorationoui.getObjects()) {
                Actor A = new Actor();
                Rectangle r = ((RectangleMapObject) o).getRectangle();
                A.setBounds(r.x, r.y, r.width, r.height);


                A.addListener(new ClickListener() {

                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        fenetreexploration.setVisible(false);

                        if (minesexploration.contains(indicemineexploration)) {
                            fenetrereussiteexploration.setVisible(true);
                            if (indicemineexploration == 0) {
                                Entree0.setVisible(true);
                                mine_0dejaexploree = true;
                            }

                            if (indicemineexploration == 1) {
                                Entree1.setVisible(true);
                                mine_1dejaexploree = true;
                            }

                            if (indicemineexploration == 6) {
                                Entree6.setVisible(true);
                                mine_6dejaexploree = true;

                            }

                            if (indicemineexploration == 8) {
                                Entree8.setVisible(true);
                                mine_8dejaexploree = true;
                            }

                            if (indicemineexploration == 16) {
                                Entree16.setVisible(true);
                                mine_16dejaexploree = true;
                            }

                            if (indicemineexploration == 19) {
                                Entree19.setVisible(true);
                                mine_19dejaexploree = true;
                            }


                        } else {
                            fenetrefail.setVisible(true);
                            if (indicemineexploration == 2) {
                                mine_2dejaexploree = true;
                            }
                            if (indicemineexploration == 3) {
                                mine_3dejaexploree = true;
                            }
                            if (indicemineexploration == 4) {
                                mine_4dejaexploree = true;
                            }
                            if (indicemineexploration == 5) {
                                mine_5dejaexploree = true;
                            }
                            if (indicemineexploration == 7) {
                                mine_7dejaexploree = true;
                            }
                            if (indicemineexploration == 9) {
                                mine_9dejaexploree = true;
                            }
                            if (indicemineexploration == 10) {
                                mine_10dejaexploree = true;
                            }
                            if (indicemineexploration == 11) {
                                mine_11dejaexploree = true;
                            }
                            if (indicemineexploration == 12) {
                                mine_12dejaexploree = true;
                            }
                            if (indicemineexploration == 13) {
                                mine_13dejaexploree = true;
                            }
                            if (indicemineexploration == 14) {
                                mine_14dejaexploree = true;
                            }
                            if (indicemineexploration == 15) {
                                mine_15dejaexploree = true;
                            }
                            if (indicemineexploration == 17) {
                                mine_17dejaexploree = true;
                            }
                            if (indicemineexploration == 18) {
                                mine_18dejaexploree = true;
                            }
                            if (indicemineexploration == 20) {
                                mine_20dejaexploree = true;
                            }
                            if (indicemineexploration == 21) {
                                mine_21dejaexploree = true;
                            }
                            if (indicemineexploration == 22) {
                                mine_22dejaexploree = true;
                            }

                        }
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
                if (fenetreexploration.isVisible() == false)
                {
                    A.setVisible(false);
                }


            }


        for (MapObject o : boutonfailok.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    fenetrefail.setVisible(false);
                }
            });

            s.addActor(A);


        }

        for (MapObject o : boutonreussiteexploration.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    fenetrereussiteexploration.setVisible(false);
                }
            });

            s.addActor(A);


        }


        for (MapObject o : BoutonEntree0.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (mine_0dejaexploree == true) {
                        fenetreexploitation.setVisible(true);
                        indicemineexploitation = 0;
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


                                if (indicemineexploitation == 0) {
                                    Rubis0.setVisible(true);
                                }

                                if (indicemineexploitation == 1) {
                                    Rubis1.setVisible(true);
                                }

                                if (indicemineexploitation == 6) {
                                    Rubis6.setVisible(true);
                                }






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