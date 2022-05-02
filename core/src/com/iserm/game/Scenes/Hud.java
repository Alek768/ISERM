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

    /**
     * Méthode permettant de créer un objet de type Hud, permettant d'afficher du texte
     * @param sb Objet de type SpriteBatch, SpriteBatch est une classe d'aide permettant l'affichage de texte
     * @param joueur Joueur rattaché au texte, le pseudo du texte est ainsi marqué en haut de l'écran
     */
    public Hud(SpriteBatch sb, Joueur joueur){
        this.j = joueur;
        nom = joueur.Pseudo;
        epoque = "Ere moderne";
        Or = joueur.getArgent();
        score = joueur.getNiveau();
        //Commentaire
        viewport = new FitViewport(IserMain.V_WIDTH, IserMain.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        nameLabel = new Label(nom,new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        scoreLabel = new Label(String.format("%01d",score),new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        timeLabel = new Label(epoque,new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        orLabel = new Label(String.format("%01d",Or), new Label.LabelStyle(new BitmapFont(), Color.BLACK));


    }

    /**
     * Permet l'affichage ou non du texte
     */
    public void affichage(){
        Table table = new Table();
        table.top();
        table.setFillParent(true);



        nameLabel.setFontScale(0.4F);
        scoreLabel.setFontScale(0.4F);
        timeLabel.setFontScale(0.4F);
        orLabel.setFontScale(0.4F);
        table.add(nameLabel).expandX().padTop(10);
        table.add(scoreLabel).expandX().padTop(10);
        table.add(timeLabel).expandX().padTop(10);
        table.add(orLabel).expandX().padTop(10);
        stage.addActor(table);
    }


    /**
     * Permet de raffraichir le texte. Permet ainsi mettre à jour la quantité d'or quand le joueur effectue un achat.
     */
    public void reload(){
        orLabel.setText(j.getArgent());
    }

    /**
     * Permet d'obtenir la quantité d'or que le joueur possède. Fait appel à la base de donnée.
     * @return
     */
    public int getOr() {
        return j.getArgent();
    }
}
