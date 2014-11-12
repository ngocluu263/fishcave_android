/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualixium.fishcave.actors;

import Screens.SplashScreen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.qualixium.fishcave.Assets;

/**
 *
 * @author homepro
 */
public class SplashActor extends Actor {

    private TextureRegion splash;

    public SplashActor() {
        splash = new TextureRegion(Assets.splash);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color col = getColor();//needed for color changing
        batch.setColor(col.r, col.g, col.b, col.a * parentAlpha);

        batch.draw(splash, SplashScreen.stage.getCamera().position.x - splash.getRegionWidth() / 2,
                SplashScreen.stage.getCamera().position.y - splash.getRegionHeight() / 2);

    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

}
