package com.iserm.game.States;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.iserm.game.Handlers.GameStateManager;
import com.iserm.game.utils.Constants;
import com.badlogic.gdx.physics.box2d.World;

public class Box2DTest extends GameState
{
    //Elements de la box 2D
    private World b2DWorld;
    private Box2DDebugRenderer debug;

    public Box2DTest(GameStateManager gsm)
    {
        super(gsm);
        debug = new Box2DDebugRenderer();
        b2DWorld = new World(new Vector2(0,0), true);

        //Définition du body
        BodyDef bdef = new BodyDef();
        bdef.position.set(460,250);
        bdef.type = BodyDef.BodyType.StaticBody;

        //Caractéristiques du corps
        Body platform = b2DWorld.createBody(bdef);
        FixtureDef fdef = new FixtureDef();

        //Formes du Body
        PolygonShape pshape = new PolygonShape();
        pshape.setAsBox(250, 25);
        fdef.shape = pshape;

        cam.setToOrtho(false, Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
    }

    @Override
    protected void handleInput()
    {

    }

    @Override
    public void update(float dt)
    {

    }

    @Override
    public void render(SpriteBatch sb)
    {
        debug.render(b2DWorld,cam.combined);
    }

    @Override
    public void dispose()
    {

    }
}
