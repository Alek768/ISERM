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

    /**
     * Méthode permettant de construire un objet de type MapMonde
     * @param map Map tiled auquelle appartient la MapMonde
     * @param stage Stage auquelle appartient la mapMonde
     * @param cam Caméra
     * @param port ViewPort
     * @param rend Renderer
     */
    public MapMonde(TiledMap map, Stage stage, OrthographicCamera cam, Viewport port, OrthogonalTiledMapRenderer rend){
        this.gamecam = cam;
        this.gamePort = port;
        this.s = stage;
        this.map = map;
        this.renderer = rend;
        mapmonde = (MapGroupLayer) map.getLayers().get("MapMonde");
        ales = mapmonde.getLayers().get("Ales");
    }
// La méthode permet maintenant de créer les boutons relatifs aux mines/zones uniquement après avoir fermer la map monde

    /**
     * Méthode permettant de créer les boutons relatifs aux mines/zones uniquement après avoir fermé la map monde.
     * @param gs Ecran où afficher l'objet
     * @param s Stage où afficher l'objet
     */
    public void afficher(final GameScreen gs, final Stage s){
        for (MapObject o : ales.getObjects()) {
            final Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x , r.y , r.width*2, r.height*2);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (mapmondevisible){
                        gs.hud.affichage();
                        mapmonde.setVisible(false);
                        mapmondevisible = false;
                        ales.setVisible(false);
                        gamePort.setWorldSize(1280, 720);
                        gamePort.apply();
                        gamecam.position.x -= 400;
                        gamecam.position.y -= 215;
                        gamecam.update();
                        renderer.setView(gamecam);
                        gs.ajoutZoneMines(s);
                        A.setVisible(false);


                    }}});
            s.addActor(A);
        };
    }

}
