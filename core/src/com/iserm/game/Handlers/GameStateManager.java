package com.iserm.game.Handlers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.iserm.game.States.GameState;

import java.util.Stack;

public class GameStateManager
{
    Stack<GameState> gameStates;

    public GameStateManager()
    {
        gameStates = new Stack<GameState>();
    }

    public void push(GameState gameState)
    {
        gameStates.push(gameState);
    }

    public void set(GameState gameState)
    {
        gameStates.pop().dispose();
        gameStates.push(gameState);
    }

    public void update(float dt)
    {
        gameStates.peek().update(dt);
    }

    public void render(SpriteBatch sb)
    {
        gameStates.peek().render(sb);
    }

}
