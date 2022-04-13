package com.iserm.game.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.iserm.game.IserMain;
import com.iserm.game.Joueur;

public class Hud {
    public Stage stage;
    private Viewport viewport;

    private Joueur j;
    private String nom;
    private int score;
    private String epoque;
    private int Or;

    Label nameLabel;
    Label scoreLabel;
    Label timeLabel;
    Label orLabel;

    public Hud(SpriteBatch sb, Joueur joueur){
        this.j = joueur;

        nom = j.Pseudo;
        epoque = "Antiquité";
        Or = j.getArgent();
        score = j.getNiveau();
        //Commentaire
        viewport = new FitViewport(IserMain.V_WIDTH, IserMain.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        nameLabel = new Label(nom,new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel = new Label(String.format("%01d",score),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        timeLabel = new Label(epoque,new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        orLabel = new Label(String.format("%01d",Or), new Label.LabelStyle(new BitmapFont(), Color.WHITE));


    }

    public void affichage(){
        Table table = new Table();
        table.top();
        table.setFillParent(true);

        table.add(nameLabel).expandX().padTop(10);
        table.add(scoreLabel).expandX().padTop(10);
        table.add(timeLabel).expandX().padTop(10);
        table.add(orLabel).expandX().padTop(10);
        stage.addActor(table);
    }

}
