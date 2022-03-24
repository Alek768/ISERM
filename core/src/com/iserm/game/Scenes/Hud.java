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

public class Hud {
    public Stage stage;
    private Viewport viewport;

    private String nom;
    private int score;
    private String epoque;
    private int Or;

    Label NameLabel;
    Label ScoreLabel;
    Label TimeLabel;
    Label OrLabel;

    public Hud(SpriteBatch sb){
        nom = "Unknown_User";
        epoque = "Antiquité";
        Or = 0;
        score = 0;

        viewport = new FitViewport(IserMain.V_WIDTH, IserMain.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        NameLabel = new Label(nom,new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        ScoreLabel = new Label(String.format("%06d",score),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        TimeLabel = new Label(epoque,new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        OrLabel = new Label(String.format("%06d",Or), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(NameLabel).expandX().padTop(10);
        table.add(ScoreLabel).expandX().padTop(10);
        table.add(TimeLabel).expandX().padTop(10);
        table.add(OrLabel).expandX().padTop(10);

        stage.addActor(table);

    }

}