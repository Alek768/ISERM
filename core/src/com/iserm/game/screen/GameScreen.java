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
import com.iserm.game.SQL;
import com.iserm.game.Scenes.*;
import com.iserm.game.utils.Constants;

import java.io.IOException;
import java.util.ArrayList;

public class GameScreen extends Constants implements Screen {

    //Mines valables
    static ArrayList minesExploration = new ArrayList<Integer>();

//    //Variables pour mines
    public static int indiceMineExploration;
    public int indiceMineExploitation;

    static private IserMain game;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    public static Hud hud;
    private OrthogonalTiledMapRenderer renderer;
    private EcranAcceuil ea;
    public boolean debut = true;

    public GameScreen(IserMain game) {
        this.game = game;
        //texture = new Texture("badlogic.jpg");
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(2080, 1120, gamecam);
        hud = new Hud(game.batch, game.j);
        renderer = new OrthogonalTiledMapRenderer(map);
        gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);

        Stage s = new Stage(gamePort, game.batch);

        masquerRubis();
        ajoutMinesExistantes();

        MapMonde oui = new MapMonde(map,s,gamecam,gamePort,renderer);
        ea = new EcranAcceuil(game.batch);
        ea.lancement(oui, s, this);

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

        if(debut){
            game.batch.setProjectionMatrix(ea.stage.getCamera().combined);
        }
        else{
            game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        }
        hud.stage.draw();


    }
// fouiller est la méthode permettant de créer les boutons correspondant à la réponse de la question
// "voulez vous explorer ces pierres ?". Si le joueur trouve une mine son entrée apprait à l'écran.
    public static void fouiller(Stage s){

        for (MapObject o : boutonexplorationoui.getObjects()) {
            final Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    fenetreExploration.setVisible(false);
                    boutonexplorationnon.setVisible(false);
                    boutonexplorationoui.setVisible(false);
                    //hud.addMoney(-50);
                    try {
                        game.j.ajoutArgent(-2000,new SQL());
                        game.j.ajoutEXP(+500,new SQL());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    hud.reload();

                    if (minesExploration.contains(Mine.indiceMineExploration)) {
                        fenetreReussiteExploration.setVisible(true);
                        boutonReussiteExploration.setVisible(true);
                        System.out.println(Mine.indiceMineExploitation);
                        if (Mine.indiceMineExploration == 0) {
                            entree0.setVisible(true);
                            mine.get(0).estExploree = true;
                        }

                        if (Mine.indiceMineExploration == 1) {
                            entree1.setVisible(true);
                            mine.get(1).estExploree = true;
                        }

                        if (Mine.indiceMineExploration == 2) {
                            entree6.setVisible(true);
                            mine.get(2).estExploree = true;

                        }

                        if (Mine.indiceMineExploration == 8) {
                            entree8.setVisible(true);
                            mine.get(3).estExploree = true;
                        }

                        if (Mine.indiceMineExploration == 16) {
                            entree16.setVisible(true);
                            mine.get(16).estExploree = true;
                        }

                        if (Mine.indiceMineExploration == 19) {
                            entree19.setVisible(true);
                            mine.get(19).estExploree = true;
                        }


                    }
                    else {
                        fenetreFail.setVisible(true);
                        boutonfailok.setVisible(true);
                        mine.get(indiceMineExploration).estExploree = true;

                    }
                    A.setVisible(false);
                }
            });
            s.addActor(A);
        }

        for (MapObject o : boutonexplorationnon.getObjects()) {
            final Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    fenetreExploration.setVisible(false);
                    boutonexplorationnon.setVisible(false);
                    boutonexplorationoui.setVisible(false);
                    A.setVisible(false);
                }
            });

            s.addActor(A);
            if (fenetreExploration.isVisible() == false)
            {
                A.setVisible(false);
            }


        }

        for (MapObject o : boutonfailok.getObjects()) {
            final Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    fenetreFail.setVisible(false);
                    boutonfailok.setVisible(false);
                    A.setVisible(false);
                }
            });

            s.addActor(A);


        }

        for (MapObject o : boutonReussiteExploration.getObjects()) {
            final Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    fenetreReussiteExploration.setVisible(false);
                    boutonReussiteExploration.setVisible(false);
                    A.setVisible(false);

                }
            });

            s.addActor(A);


        }
    }
//la methode decouverte gère la suppression des nuages et la modification de la variable estDecouverte d'une zone lorsque
//    le joueur décide de la découvrir

    public static void decouverte(Stage s){
        for (MapObject o : boutondecouverteoui.getObjects()) {
            final Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);

            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {

                    fenetreDecouverte.setVisible(false);
                    boutondecouverteoui.setVisible(false);
                    boutondecouvertenon.setVisible(false);
                    System.out.println(hud.getOr());
                    hud.affichage();
                    Zone.derniereZoneDecouverte = Zone.indiceZoneEnDecouverte;
                    try {
                        game.j.ajoutArgent(-1000,new SQL());
                        game.j.ajoutEXP(+500,new SQL());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    hud.reload();

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
                    A.setVisible(false);
                }

            });
            s.addActor(A);

        }

        for (MapObject o : boutondecouvertenon.getObjects()) {
            final Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);

            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    fenetreDecouverte.setVisible(false);
                    A.setVisible(false);
                }

            });

            s.addActor(A);
        }
    }


    public static void exploitation(Stage s){
        System.out.println("debutexp");

        for (MapObject o : boutonexploitationnon.getObjects()) {
            final Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    System.out.println("non");
                    fenetreExploitation.setVisible(false);
                    A.setVisible(false);
                }
            });
            s.addActor(A);
        }

        for (MapObject o : boutonexploitationoui.getObjects()) {
            final Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);

            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    System.out.println("oui");

                    fenetreExploitation.setVisible(false);


                    if (mine.get(0).estExploree && Mine.indiceMineExploitation == 0) {
                        Rubis0.setVisible(true);
                    }

                    if (mine.get(1).estExploree && Mine.indiceMineExploitation == 1) {
                        Rubis1.setVisible(true);
                    }

//                    if (mine.get(6).estExploree && Mine.indiceMineExploitation == 6) {
//                        Rubis6.setVisible(true);
//                    }
                    A.setVisible(false);

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

    public void masquerRubis(){
        Rubis0.setVisible(false);
        Rubis1.setVisible(false);
        Rubis6.setVisible(false);
        Rubis8.setVisible(false);
        Rubis16.setVisible(false);
        Rubis19.setVisible(false);

        boutonexplorationoui.setVisible(false);
        boutonexplorationnon.setVisible(false);
    }

    public void ajoutMinesExistantes(){
        minesExploration.add(0);
        minesExploration.add(1);
        minesExploration.add(6);
        minesExploration.add(8);
        minesExploration.add(16);
        minesExploration.add(19);

    }

    public void ajoutZoneMines(Stage s){
        for( int i = 1; i < 7; i++){
            zone.add( new Zone(map,s,gamecam,gamePort,renderer,"Zone"+i,i));
            zone.get(i - 1).afficher();
        }
        decouverte(s);

        for( int i = 0; i < 4; i++){
            mine.add( new Mine(s,gamecam,gamePort,"Mine_"+i,i,0));mine.get(i).afficher();
        }

        fouiller(s);
    }
}