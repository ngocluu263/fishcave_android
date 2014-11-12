/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualixium.fishcave.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.qualixium.fishcave.Assets;

/**
 *
 * @author homepro
 */
public class FishActor extends Actor {
    
    private final TextureRegion fish;
    private final int WIDTH, HEIGHT;
    public static final float START_Y = 240,
            START_X = 50,
            SPEED = 200,
            JUMP_IMPULSE = 400,
            GRAVITY = -20;
    public static Vector2 velocity = new Vector2();
    public static Vector2 gravity = new Vector2();

    public FishActor() {
        WIDTH = 57;
        HEIGHT = 44;
        fish = new TextureRegion(Assets.fish, WIDTH, HEIGHT);
        setSize(WIDTH, HEIGHT);
        setPosition(START_X, START_Y);
    }
    
    
    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color col = getColor();//needed for color changing
        batch.setColor(col.r, col.g, col.b, col.a * parentAlpha);
        batch.draw(fish, getX(), getY(), getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        
    }

    @Override
    public void moveBy(float x, float y) {
        float delta = Gdx.graphics.getDeltaTime();
        super.moveBy(x * delta, y * delta); 
    }
    
    

}
