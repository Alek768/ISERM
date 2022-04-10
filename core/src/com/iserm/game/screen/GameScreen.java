package com.iserm.game.screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.iserm.game.IserMain;
import com.iserm.game.Scenes.Hud;
import com.iserm.game.Scenes.MapMonde;
import com.iserm.game.Scenes.Mine;
import com.iserm.game.Scenes.Zone;
import com.iserm.game.utils.Constants;

import java.util.ArrayList;

import static com.badlogic.gdx.Input.Keys.O;

public class GameScreen extends Constants implements Screen {

    //Mines valables
    ArrayList minesexploration = new ArrayList<Integer>();

//    //Variables pour mines
    public int indicemineexploration;
    public int indicemineexploitation;




    private IserMain game;
    //Texture texture;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private Hud hud;

    private OrthogonalTiledMapRenderer renderer;

    public GameScreen(IserMain game) {
        this.game = game;
        //texture = new Texture("badlogic.jpg");
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(2080, 1120, gamecam);
        hud = new Hud(game.batch, game.j);

        renderer = new OrthogonalTiledMapRenderer(map);
        gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);

        final Stage s = new Stage(gamePort, game.batch);

        //Fenêtres d'affichage
        fenetreDecouverte = map.getLayers().get("Decouverte");
        fenetreexploration = map.getLayers().get("explorer mines");
        fenetrefail = map.getLayers().get("Fail");
        fenetrereussiteexploration = map.getLayers().get("Mines trouvee");
        fenetreexploitation = map.getLayers().get("Decision exploitation");



        //Mines ok
        minesexploration.add(0);
        minesexploration.add(1);
        minesexploration.add(6);
        minesexploration.add(8);
        minesexploration.add(16);
        minesexploration.add(19);

        MapMonde oui = new MapMonde(map,s,gamecam,gamePort,renderer);
        oui.afficher();


        //Implémentation des zones nuageuses

        for( int i = 1; i < 7; i++){
            zone.add( new Zone(map,s,gamecam,gamePort,renderer,"Zone"+i,i));
            zone.get(i - 1).afficher();
        }

        decouverte(s);

        for( int i = 0; i < 4; i++){
            mine.add( new Mine(map,s,gamecam,gamePort,renderer,"Mine_"+i,i));
            mine.get(i).afficher();
        }

        fouiller(s);







        for (MapObject o : boutonEntree0.getObjects()) {
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


    }

    public void fouiller(Stage s){

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
                            entree0.setVisible(true);
                            mine.get(0).estExploree = true;
                        }

                        if (indicemineexploration == 1) {
                            entree1.setVisible(true);
                            mine.get(1).estExploree = true;
                        }

                        if (indicemineexploration == 2) {
                            entree6.setVisible(true);
                            mine.get(2).estExploree = true;

                        }

                        if (indicemineexploration == 8) {
                            entree8.setVisible(true);
                            mine_8dejaexploree = true;
                        }

                        if (indicemineexploration == 16) {
                            entree16.setVisible(true);
                            mine_16dejaexploree = true;
                        }

                        if (indicemineexploration == 19) {
                            entree19.setVisible(true);
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
    }

    public void decouverte(Stage s){
        for (MapObject o : boutondecouverteoui.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);

            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {

                    fenetreDecouverte.setVisible(false);

                    if (Zone.indiceZoneEnDecouverte == 1) {
                        nuage1.setVisible(false);
                        zone.get(0).estDecouverte = true;

                    }
                    if (Zone.indiceZoneEnDecouverte == 2) {
                        nuage2.setVisible(false);
                        zone.get(1).estDecouverte = true;

                    }
                    if (Zone.indiceZoneEnDecouverte == 3) {
                        nuage3.setVisible(false);
                        //zone3.setVisible(false);
                        zone.get(2).estDecouverte = true;

                    }
                    if (Zone.indiceZoneEnDecouverte == 4) {
                        nuage4.setVisible(false);
                        //zone4.setVisible(false);
                        zone.get(3).estDecouverte = true;

                    }
                    if (Zone.indiceZoneEnDecouverte == 5) {
                        nuage5.setVisible(false);
                        //zone5.setVisible(false);
                        zone.get(4).estDecouverte = true;

                    }
                    if (Zone.indiceZoneEnDecouverte == 6) {
                        nuage6.setVisible(false);
                        //zone6.setVisible(false);
                        zone.get(5).estDecouverte = true;

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
                    fenetreDecouverte.setVisible(false);
                }
            });

            s.addActor(A);
        }
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