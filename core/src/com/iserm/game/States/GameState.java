package com.iserm.game.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.iserm.game.Handlers.GameStateManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameState
{
    protected OrthographicCamera cam;
    private GameStateManager gsm;

    public GameState(GameStateManager gsm)
    {
        gsm = gsm;
        cam = new OrthographicCamera();
    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();

}
