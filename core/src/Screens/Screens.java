/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import com.badlogic.gdx.Screen;
import com.qualixium.fishcave.FishcaveGame;

/**
 *
 * @author homepro
 */
public abstract class Screens implements Screen {

    protected FishcaveGame game;

    public Screens(FishcaveGame game) {
        this.game = game;
    }

    @Override
    public void render(float delta) {
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }

}
