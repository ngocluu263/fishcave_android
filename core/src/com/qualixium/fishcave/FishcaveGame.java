package com.qualixium.fishcave;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Screens.SplashScreen;

public class FishcaveGame extends Game {

    public static SpriteBatch batch;
    public ActionResolver actionResolver;

    public FishcaveGame(ActionResolver actionResolver) {
        this.actionResolver = actionResolver;

    }

    @Override
    public void create() {

        batch = new SpriteBatch();
        Assets.load();

        this.setScreen(new SplashScreen(this));
    }

    @Override
    public void dispose() {
        Assets.dispose();
        getScreen().dispose();
    }
}
