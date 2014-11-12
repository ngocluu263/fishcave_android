/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualixium.fishcave.actors;

import Screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.qualixium.fishcave.Assets;
import com.qualixium.fishcave.GameState;

/**
 *
 * @author homepro
 */
public class SignActor extends Actor {

    TextureRegion ready;
    TextureRegion gameOver;
    public static int score = 0;
    BitmapFont font;

    public SignActor() {

        ready = new TextureRegion(Assets.gameReady);
        gameOver = new TextureRegion(Assets.gameOver);
        
        font = new BitmapFont(Gdx.files.internal("arial.fnt"));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color col = getColor();//needed for color changing
        batch.setColor(col.r, col.g, col.b, col.a * parentAlpha);

         if (GameState.state == GameState.State.Start) {
            batch.draw(ready, GameScreen.stage.getCamera().position.x  - 
                    ready.getRegionWidth() / 2, GameScreen.stage.getCamera().position.y - ready.getRegionHeight() / 2);
        }
        if (GameState.state == GameState.State.GameOver) {
            batch.draw(gameOver, GameScreen.stage.getCamera().position.x  - 
                    gameOver.getRegionWidth() / 2, GameScreen.stage.getCamera().position.y - gameOver.getRegionHeight() / 2);
        }
        if (GameState.state == GameState.State.GameOver || GameState.state == GameState.State.Running) {
            
            font.draw(batch, "" + score, GameScreen.stage.getCamera().position.x,
                    GameScreen.stage.getCamera().viewportHeight - 60);
        }

    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

}
