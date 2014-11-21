/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.qualixium.fishcave.Assets;
import static com.qualixium.fishcave.actors.ObstaclesActor.Rock;
import com.qualixium.fishcave.FishcaveGame;
import com.qualixium.fishcave.GameState;
import com.qualixium.fishcave.actors.BackgroundActor;
import com.qualixium.fishcave.actors.ObstaclesActor;
import com.qualixium.fishcave.actors.FishActor;
import static com.qualixium.fishcave.actors.FishActor.rotation;
import com.qualixium.fishcave.actors.SignActor;

/**
 *
 * @author homepro
 */
public class GameScreen extends Screens {

    public static Stage stage;
    private final Actor fish, background, obstacles, sign;
    Rectangle fishRect = new Rectangle();
    Rectangle rockRect = new Rectangle();

    public GameScreen(FishcaveGame game) {
        super(game);
        stage = new Stage(new ExtendViewport(480, 720));
        Gdx.input.setInputProcessor(stage);

        background = new BackgroundActor();
        background.setSize(stage.getWidth(), stage.getHeight());
        stage.addActor(background);

        obstacles = new ObstaclesActor();
        stage.addActor(obstacles);

        fish = new FishActor();
        stage.addActor(fish);

        sign = new SignActor();
        stage.addActor(sign);

        Assets.music.setLooping(true);
        Assets.music.play();

        resetWorld();

    }

    private void resetWorld() {
        SignActor.score = 0;
        ObstaclesActor.groundOffsetX = 0;
        fish.setPosition(FishActor.START_X, FishActor.START_Y);

        FishActor.velocity.set(0, 0);
        fish.setRotation(0);
        FishActor.rotation.y = 0;
        stage.getCamera().position.x = 400;

        ObstaclesActor.rocks.clear();
        for (int i = 0; i < 5; i++) {
            boolean isDown = MathUtils.randomBoolean();
            ObstaclesActor.rocks.add(new Rock(700 + i * 200, isDown ? stage.getHeight()
                    - ObstaclesActor.rock.getRegionHeight() : 0, isDown
                            ? ObstaclesActor.rockDown : ObstaclesActor.rock));
        }
    }

    private void createWorld() {

        float deltaTime = Gdx.graphics.getDeltaTime();

        if (Gdx.input.justTouched()) {
            if (GameState.state == GameState.State.Start) {
                GameState.state = GameState.State.Running;
            }
            if (GameState.state == GameState.State.Running) {
                FishActor.velocity.set(FishActor.SPEED, FishActor.JUMP_IMPULSE);
                FishActor.rotation.y = 30;
            }
            if (GameState.state == GameState.State.GameOver) {
                GameState.state = GameState.State.Start;
                resetWorld();
            }
        }

        if (GameState.state != GameState.State.Start) {
            FishActor.velocity.y += FishActor.GRAVITY;
            if (FishActor.velocity.y < 0) {
                FishActor.rotation.y -= 60 * deltaTime;
                if (FishActor.rotation.y < -91) {
                    FishActor.rotation.y = -90;
                }
            }
        }

        stage.getCamera().position.x = fish.getX() + 200;

        if (stage.getCamera().position.x - ObstaclesActor.groundOffsetX
                > ObstaclesActor.ground.getRegionWidth() + 400) {
            ObstaclesActor.groundOffsetX += ObstaclesActor.ground.getRegionWidth();
        }

        fishRect.set(fish.getX(), fish.getY(), fish.getWidth(), fish.getHeight());

        for (Rock r : ObstaclesActor.rocks) {
            if (stage.getCamera().position.x - r.position.x > 400 + r.image.getRegionWidth()) {
                boolean isDown = MathUtils.randomBoolean();
                r.position.x += 5 * 200;
                r.position.y = isDown ? stage.getHeight() - ObstaclesActor.rock.getRegionHeight() : 0;
                r.image = isDown ? ObstaclesActor.rockDown : ObstaclesActor.rock;
                r.counted = false;
            }

            rockRect.set(r.position.x + (r.image.getRegionWidth() - 30) / 2 + 20,
                    r.position.y, 20, r.image.getRegionHeight() - 10);
            if (fishRect.overlaps(rockRect)) {
                if (GameState.state != GameState.State.GameOver) {
                    Assets.explode.play();
                }
                GameState.state = GameState.State.GameOver;
                FishActor.velocity.x = 0;
            }
            if (r.position.x < fish.getX() && !r.counted) {
                SignActor.score++;
                r.counted = true;
            }
        }

        if (fish.getY() < ObstaclesActor.ground.getRegionHeight() - 20
                || fish.getY() + fish.getHeight() > stage.getHeight() - ObstaclesActor.ground.getRegionHeight() + 20) {
            if (GameState.state != GameState.State.GameOver) {
                Assets.explode.play();
            }
            GameState.state = GameState.State.GameOver;
            FishActor.velocity.x = 0;
        }

    }

    @Override
    public void render(float delta) {
        createWorld();
        stage.draw();
        stage.act();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
        background.setSize(width, height);
    }

}
