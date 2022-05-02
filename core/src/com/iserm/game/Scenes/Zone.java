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
import com.iserm.game.utils.Constants;

public class Zone extends Constants {

    public OrthographicCamera gamecam;
    public Viewport gamePort;
    public Stage s;
    private MapGroupLayer mapmonde;
    public OrthogonalTiledMapRenderer renderer;
    private final int idZone;
    private boolean estVisible;
    private MapLayer zone;
    public boolean estDecouverte;
    public static int indiceZoneEnDecouverte;
    public static int derniereZoneDecouverte = 0;


    /**
     * Méthode permettant de construire un objet de type Zone
     * @param map Map Tiled auquel est rattraché la zoen
     * @param stage Stage auquelle appartient la zone
     * @param cam Caméra
     * @param port Viewport
     * @param rend Render
     * @param name Nom de la zone
     * @param idZone Identifiant de la zone
     */
    public Zone(TiledMap map, Stage stage, OrthographicCamera cam, Viewport port, OrthogonalTiledMapRenderer rend, String name, int idZone){
        this.gamecam = cam;
        this.gamePort = port;
        this.s = stage;
        this.renderer = rend;
        zone = map.getLayers().get(name);
        this.idZone = idZone;

    }

    /**
     * Permet d'afficher ou de faire disparaître l'objet concerné sur la map Tiled. Vérifie certaine conditions afin
     * d'éviter la triche
     */
    public void afficher(){
        for (MapObject o : zone.getObjects()) {
            final Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if ( !estDecouverte && !GameScreen.fenetreDecouverte.isVisible()){
                        GameScreen.fenetreDecouverte.setVisible(true);
                        GameScreen.decouverte(s);
                        indiceZoneEnDecouverte = idZone;
                        A.setVisible(false);
                    }
                }
            });

            s.addActor(A);
            if (estDecouverte)
            {
                A.setVisible(false);
            }

        }
    }

}
