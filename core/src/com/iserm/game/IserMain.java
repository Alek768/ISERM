package com.iserm.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class IserMain extends ApplicationAdapter {
	SpriteBatch batch;
	OrthographicCamera camera;
	Texture img;
	Texture img2;



	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		batch = new SpriteBatch();
		img = new Texture("ISERM Logo.png");
		img2 = new Texture("Logo-IMT-Mines-Ales.jpeg");
	}

	@Override
	public void resize(int width, int height) {
		camera.setToOrtho(false,width,height);
	}


	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(img, 180, 170);
		batch.draw(img2, 530, 420);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}}


