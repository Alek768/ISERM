package com.iserm.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.iserm.game.screen.GameScreen;

import java.io.IOException;
import java.sql.SQLException;


public class IserMain extends Game {
	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 208;
	public static Joueur j;
	public SpriteBatch batch;
	Music music;

	//OrthographicCamera camera;
	//Texture img;
	//Texture img2;
	//TextButton textButton;
	//Skin skin = new Skin();


	/**
	 *Méthode
	 */
	@Override
	public void create () {
		//camera = new OrthographicCamera();
		batch = new SpriteBatch();
		this.j = new Joueur(2);
		try {
			SQL sql = new SQL();
			j.config(sql);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
		setScreen(new GameScreen(this));
		Music music = Gdx.audio.newMusic(Gdx.files.internal("iserm_music.mp3"));
		music.setLooping(true);
		music.play();

	}
/*
	@Override
	public void resize(int width, int height) {
		camera.setToOrtho(false,width,height);
	}
*/

	/**
	 * Appelle la classe mère, classe par défaut.
	 */
	@Override
	public void render () {
		super.render();
		/*ScreenUtils.clear(1, 1, 1, 1);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(img, 180, 170);
		batch.draw(img2, 530, 420);
		batch.end();*/
	}

	/**
	 * Méthode par defaut.
	 */
	@Override
	public void dispose () {
		//batch.dispose();
		//img.dispose();
		music.dispose();
	}}


