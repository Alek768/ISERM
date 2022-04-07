package com.iserm.game.Scenes;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapGroupLayer;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Mine {
    public OrthographicCamera gamecam;
    public Viewport gamePort;
    public Stage s;
    private TiledMap map ;
    private boolean mapmondevisible = true;
    private MapLayer ales;
    private MapGroupLayer mapmonde;
    public OrthogonalTiledMapRenderer renderer;
    private int idMine;
    private boolean estVisible;
    private MapLayer zone;
    public boolean estDecouverte;
    public static int indiceZoneEnDecouverte;

    public Mine(TiledMap map, Stage stage, OrthographicCamera cam, Viewport port, OrthogonalTiledMapRenderer rend, String name, int idMine){
        this.gamecam = cam;
        this.gamePort = port;
        this.s = stage;
        this.map = map;
        this.renderer = rend;
        zone = map.getLayers().get(name);
        this.idMine = idMine;

    }
}
