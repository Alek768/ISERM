package com.iserm.game.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.iserm.game.screen.GameScreen;
import com.iserm.game.utils.Constants;
import com.iserm.game.utils.Assets;

public class EcranAcceuil extends Constants {
    public SpriteBatch sb;
    public Stage stage;
    private Viewport viewport;
    private  Skin skin;

    /**
     * Méthode permettant de créer un objet EcranAccueil
     * @param sB SprinteBatch, classe d'aide pour écrire du texte
     */
    public EcranAcceuil(SpriteBatch sB){
        this.sb = sB;
        this.stage = new Stage();
        this.viewport = new FitViewport(2080, 1120, new OrthographicCamera());



//        skin = Assets.getAssetManager().get(Assets.SKIN_VIS);
//        Label nameLabel = new Label("name", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
//        TextField nameText = new TextField("", skin);
//        Label addressLabel = new Label("Address:", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
//        TextField addressText = new TextField("", skin);
//
//        Table table = new Table();
//        table.add(nameLabel);
//        table.add(nameText).width(100);
//        table.row();
//        table.add(addressLabel);
//        table.add(addressText).width(100);


    }


    /**
     * Méthode permettant de lancer la mapMonde
     * @param mm MapMonde que l'on souhaite lancer
     * @param s Stage rattachée
     * @param gs GameScreen rattaché
     */
    public void lancement(final MapMonde mm, final Stage s, final GameScreen gs){

        for (final MapObject o : acceuilPlay.getObjects()) {
            Actor A = new Actor();
            Rectangle r = ((RectangleMapObject) o).getRectangle();
            A.setBounds(r.x, r.y, r.width, r.height);


            A.addListener(new ClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    acceuilPlay.setVisible(false);
                    acceuil.setVisible(false);
                    mm.afficher(gs, s);

                }
            });

            s.addActor(A);

        }
    }

}
