/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualixium.fishcave.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.qualixium.fishcave.Assets;
import com.qualixium.fishcave.GameState;

/**
 *
 * @author homepro
 */
public class FishActor extends Actor {

    private final TextureRegion fish;
    private final Animation fishAnimation;
    private final TextureRegion[] fishFrames;
    private float duration;

    private float deltaTime;

    private final int WIDTH, HEIGHT;
    public static final float START_Y = 260,
            START_X = 50,
            SPEED = 200,
            JUMP_IMPULSE = 350,
            GRAVITY = -20;

    public static Vector2 rotation = new Vector2();
    public static Vector2 velocity = new Vector2();
    public static Vector2 gravity = new Vector2();

    public FishActor() {
        deltaTime = Gdx.graphics.getDeltaTime();

        WIDTH = 128;
        HEIGHT = 44;

        fish = new TextureRegion(Assets.fish, WIDTH, HEIGHT);
        TextureRegion[][] animation = fish.split(WIDTH / 2, HEIGHT);
        fishFrames = new TextureRegion[animation.length * animation[0].length];
        int index = 0;
        for (TextureRegion[] animation1 : animation) {
            for (TextureRegion animation11 : animation1) {
                fishFrames[index++] = animation11;
            }
        }
        fishAnimation = new Animation(0.2f, fishFrames);

        setSize(WIDTH / 2, HEIGHT);
        setPosition(START_X, START_Y);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color col = getColor();//needed for color changing
        batch.setColor(col.r, col.g, col.b, col.a * parentAlpha);

        duration += deltaTime;
        TextureRegion fishFrame = fishAnimation.getKeyFrame(duration, true);
        batch.draw(fishFrame, getX(), getY(), getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        moveBy(velocity.x, velocity.y);
        if (getRotation() > -91 && getRotation() < 31) {
            setRotation(rotation.y);
        }
    }

    @Override
    public void moveBy(float x, float y) {
        super.moveBy(x * deltaTime, y * deltaTime);
    }

    @Override
    public void rotateBy(float amountInDegrees) {
        super.rotateBy(amountInDegrees * deltaTime);
    }

}
