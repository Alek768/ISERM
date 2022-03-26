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

public class GameScreen implements Screen {
    //private final MapLayer pierre3;
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

        //pierre3 = map.getLayers().get("objet_pierres3");

        //Stage s = new Stage(gamePort) ;

//        for (MapObject o : pierre3.getObjects()){
//            Actor A = new Actor() ;
//            Rectangle r = ((RectangleMapObject) o).getRectangle() ;
//            A.setBounds(r.x , r.y , r.width , r.height);
//
//
//
//            A.addListener(new ClickListener() {
//
//                @Override
//                public void clicked(InputEvent event, float x, float y) {
//                    System.out.println("clique sur pierre 3");
//                }
//            }) ;
//
//            s.addActor(A);


        // }

        //Gdx.input.setInputProcessor(s);

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
        /*

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

