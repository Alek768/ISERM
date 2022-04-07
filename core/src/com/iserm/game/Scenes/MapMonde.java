package com.iserm.game.Scenes;

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

import javax.swing.*;

public class MapMonde {
    public OrthographicCamera gamecam;
    public Viewport gamePort;
    public Stage s;
    private TiledMap map;
    private boolean mapmondevisible = true;
    private MapLayer ales;
    private MapGroupLayer mapmonde;
    public OrthogonalTiledMapRenderer renderer;


    public MapMonde(TiledMap map, Stage stage, OrthographicCamera cam, Viewport port, OrthogonalTiledMapRenderer rend){
        this.gamecam = cam;
        this.gamePort = port;
        this.s = stage;
        this.map = map;
        this.renderer = rend;
        mapmonde = (MapGroupLayer) map.getLayers().get("MapMonde");
        ales = mapmonde.getLayers().get("Ales");
    }

    public void afficher(){
        for (MapObject o : ales.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x , r.y , r.width*2, r.height*2);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (mapmondevisible){


                        mapmonde.setVisible(false);
                        mapmondevisible = false;
                        gamePort.setWorldSize(1280, 720);
                        gamePort.apply();
                        gamecam.position.x -= 400;
                        gamecam.position.y -= 215;
                        gamecam.update();
                        renderer.setView(gamecam);


                    }}});
            s.addActor(A);
            if (!mapmondevisible){
                A.setVisible(false);
            }
        };
    }

}
