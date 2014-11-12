/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.qualixium.fishcave.FishcaveGame;
import com.qualixium.fishcave.actors.SplashActor;

/**
 *
 * @author homepro
 */
public class SplashScreen extends Screens {

    public static Stage stage;
    private FishcaveGame game;
    private long startTime;
    private SplashActor splash;

    public SplashScreen(FishcaveGame g) {
        super(g);
        stage = new Stage(new FitViewport(480, 640));
        Gdx.input.setInputProcessor(stage);

        game = g;

        splash = new SplashActor();
        stage.addActor(splash);
        startTime = TimeUtils.millis();

    }

    public void showGame() {
        if (TimeUtils.millis() > (startTime + 5000)) {
            game.setScreen(new GameScreen(game));
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
