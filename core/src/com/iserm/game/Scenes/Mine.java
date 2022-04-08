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
import com.iserm.game.screen.GameScreen;

public class Mine {
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
    public static int indicemineexploration;

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
                        indicemineexploration = idMine;
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
}
