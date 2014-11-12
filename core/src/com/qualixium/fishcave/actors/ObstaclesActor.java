/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualixium.fishcave.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.qualixium.fishcave.Assets;

/**
 *
 * @author homepro
 */
public class ObstaclesActor extends Actor {

    public static TextureRegion ground;
    public static TextureRegion ceiling;
    public static TextureRegion rock, rockDown;
    public static float groundOffsetX = 0;
    public static Array<Rock> rocks = new Array<Rock>();

    public ObstaclesActor() {

        rock = new TextureRegion(Assets.rock);
        rockDown = new TextureRegion(rock);
        rockDown.flip(false, true);

        ground = new TextureRegion(Assets.ground);
        ceiling = new TextureRegion(ground);
        ceiling.flip(true, true);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color col = getColor();//needed for color changing
        batch.setColor(col.r, col.g, col.b, col.a * parentAlpha);
        
        for (Rock r : rocks) {
            batch.draw(r.image, r.position.x, r.position.y);
        }

        batch.draw(ground, groundOffsetX, 0);
        batch.draw(ground, groundOffsetX + ground.getRegionWidth(), 0);
        
        batch.draw(ceiling, groundOffsetX, 640 - ceiling.getRegionHeight());
        batch.draw(ceiling, groundOffsetX + ceiling.getRegionWidth(), 640 - ceiling.getRegionHeight());


    }

    @Override
    public void act(float delta) {
        super.act(delta); //To change body of generated methods, choose Tools | Templates.
    }

    public static class Rock {

        public Vector2 position = new Vector2();
        public TextureRegion image;
        public boolean counted;

        public Rock(float x, float y, TextureRegion image) {
            this.position.x = x;
            this.position.y = y;
            this.image = image;
        }
    }

}
