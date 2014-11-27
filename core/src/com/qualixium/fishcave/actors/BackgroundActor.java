/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualixium.fishcave.actors;

import Screens.GameScreen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.qualixium.fishcave.Assets;

/**
 *
 * @author homepro
 */
public class BackgroundActor extends Actor {

    private final TextureRegion background;

    public BackgroundActor() {
        background = new TextureRegion(Assets.background);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color col = getColor();//needed for color changing
        batch.setColor(col.r, col.g, col.b, col.a * parentAlpha);
        batch.draw(background, GameScreen.stage.getCamera().position.x - background.getRegionWidth() / 2, 0);

    }


}
