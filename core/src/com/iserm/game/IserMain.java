package com.iserm.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.iserm.game.screen.GameScreen;

import java.io.IOException;
import java.sql.SQLException;


public class IserMain extends Game {
	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 208;
	public SpriteBatch batch;
	//OrthographicCamera camera;
	//Texture img;
	//Texture img2;
	//TextButton textButton;
	//Skin skin = new Skin();
	
	@Override
	public void create() {
		//camera = new OrthographicCamera();
		batch = new SpriteBatch();
		//img = new Texture("ISERM Logo.png");
		//img2 = new Texture("Logo-IMT-Mines-Ales.jpeg");
		try {
			setScreen(new GameScreen(this));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
/*
	@Override
	public void resize(int width, int height) {
		camera.setToOrtho(false,width,height);
	}
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
	
	@Override
	public void dispose () {
		//batch.dispose();
		//img.dispose();
	}
}