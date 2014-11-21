/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.qualixium.fishcave.FishcaveGame;
import com.qualixium.fishcave.actors.SplashActor;

/**
 *
 * @author homepro
 */
public class SplashScreen extends Screens {

    public static Stage stage;
    private final FishcaveGame gameCore;
    private final long startTime;
    private final SplashActor splash;

    public SplashScreen(FishcaveGame g) {
        super(g);
        stage = new Stage(new ExtendViewport(480, 640));
        Gdx.input.setInputProcessor(stage);

        gameCore = g;

        splash = new SplashActor();
        stage.addActor(splash);
        startTime = TimeUtils.millis();

    }

    public void showGame() {
        if (TimeUtils.millis() > (startTime + 5000)) {
            gameCore.setScreen(new GameScreen(gameCore));
        }
    }

    @Override
    public void render(float delta) {
        stage.draw();
        stage.act();

        showGame();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

}
