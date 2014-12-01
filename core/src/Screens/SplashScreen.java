/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.qualixium.fishcave.Assets;
import com.qualixium.fishcave.FishcaveGame;

/**
 *
 * @author homepro
 */
public class SplashScreen extends Screens {

    public static Stage stage;
    private long startTime;
    Image splashImg;

    public SplashScreen(FishcaveGame game) {
        super(game);
        stage = new Stage(new FitViewport(640, 480));
        stage.addActor(new Image(Assets.splash));

        splashImg = new Image(Assets.splash);
        splashImg.setSize(stage.getWidth(), stage.getHeight());

        stage.addActor(splashImg);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (TimeUtils.millis() > (startTime + 5000)) {
            game.setScreen(new MenuScreen(game));
        }

        stage.draw();
        stage.act();
    }

    @Override
    public void show() {
        startTime = TimeUtils.millis();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

}
