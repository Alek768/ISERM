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
    private boolean mapmondevisible = true;
    private MapGroupLayer mapmonde;
    public OrthogonalTiledMapRenderer renderer;
    private final int idZone;
    private boolean estVisible;
    private MapLayer zone;
    public boolean estDecouverte;
    public static int indiceZoneEnDecouverte;
    public static int derniereZoneDecouverte = 0;

    public Zone(TiledMap map, Stage stage, OrthographicCamera cam, Viewport port, OrthogonalTiledMapRenderer rend, String name, int idZone){
        this.gamecam = cam;
        this.gamePort = port;
        this.s = stage;
        this.renderer = rend;
        zone = map.getLayers().get(name);
        this.idZone = idZone;

    }

    public void afficher(){
        for (MapObject o : zone.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (derniereZoneDecouverte == idZone -1 && !estDecouverte && !GameScreen.fenetreDecouverte.isVisible()){
                        GameScreen.fenetreDecouverte.setVisible(true);
                        indiceZoneEnDecouverte = idZone;
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
