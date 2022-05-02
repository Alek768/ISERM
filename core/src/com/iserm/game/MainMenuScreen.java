package com.iserm.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;



public class MainMenuScreen implements Screen {

    Skin skin;
        Stage stage;
        IserMain game;


            public MainMenuScreen(IserMain pgame){
                this.game = pgame;

                stage=new Stage();
                Gdx.input.setInputProcessor(stage);

                skin = new Skin( Gdx.files.internal( "ui/defaultskin.json" ));
                Table table=new Table();
                table.setSize(800,480);

                final TextButton startGame=new TextButton("start game",skin);
                table.add(startGame).width(200).height(50);
                table.row();

                TextButton options=new TextButton("options",skin);
                table.add(options).width(150).padTop(10).padBottom(3);
                table.row();

                TextButton credits=new TextButton("credits",skin);
                table.add(credits).width(150);
                table.row();

                TextButton quit=new TextButton("quit",skin);
                table.add(quit).width(100).padTop(10);
                table.row();

                TextField text=new TextField("",skin);
                table.add(text).width(100).padTop(10);
                table.row();


                CheckBox box=new CheckBox("done",skin);
                table.add(box).width(100);
                table.row();


                stage.addActor(table);

                startGame.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        startGame.addAction(Actions.fadeOut(0.7f));

                    }
                });
            }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1, 1);

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
        stage.dispose();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}


