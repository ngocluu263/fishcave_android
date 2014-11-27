/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.delay;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveBy;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.parallel;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.qualixium.fishcave.Assets;
import com.qualixium.fishcave.FishcaveGame;
import com.qualixium.fishcave.actors.FishActor;

/**
 *
 * @author homepro
 */
public class MenuScreen extends Screens {

    private Stage stage;
    private TextureRegionDrawable tblBackground;
    private TextureRegion ceiling, ground;
    private Image imgCeiling, imgGround;
    private Actor fish;

    public MenuScreen(FishcaveGame game) {
        super(game);

        fish = new FishActor();

    }

    @Override
    public void show() {
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        tblBackground = new TextureRegionDrawable(new TextureRegion(Assets.background));
        ground = new TextureRegion(Assets.ground);
        ceiling = new TextureRegion(Assets.ground);
        ceiling.flip(false, true);
        imgGround = new Image(ground);
        imgCeiling = new Image(ceiling);

        Label lblTitle = new Label("FishCave", skin);

        final TextButton btnRate, btnPlay, btnScoreboard;
        btnRate = new TextButton("Rate", skin);
        btnPlay = new TextButton("Play", skin);
        btnScoreboard = new TextButton("ScoreBoard", skin);

        // Posicionamos los elementos en una tabla.
        final int sep = 20, span = 2;
        Table tblLayout = new Table().debug();
        tblLayout.setFillParent(true);
        tblLayout.setBackground(tblBackground);
        tblLayout.add(imgCeiling).space(sep).colspan(span).row();
        tblLayout.add(lblTitle).space(sep).colspan(span).row();
        tblLayout.add(fish).space(sep).expand().colspan(span).row();
        tblLayout.add(btnRate).space(sep).pad(sep).colspan(span).row();
        tblLayout.add(btnPlay).pad(sep);
        tblLayout.add(btnScoreboard).pad(sep).row();
        tblLayout.add(imgGround).space(sep).colspan(span).row();

        // Al hacer clic en el botón nuevo juego, los botones se van.
        btnRate.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // Píxeles verticales que se desplazarán los botones. Movemos
                // el alto de la pantalla porque es matemáticamente imposible
                // que se sigan viendo los botones tras la animación.
                final int desplY = Gdx.graphics.getHeight();

                // Segundos de delay entre el movimiento de cada botón.
                final float espera = 0.1f;

                // Cuanto tiempo dura la animación del botón volando.
                final float duracion = 0.5f;

                btnRate.addAction(sequence(delay(0 * espera),
                        parallel(moveBy(0, desplY, duracion), fadeOut(duracion))));
                imgCeiling.addAction(sequence(delay(1 * espera),
                        parallel(moveBy(0, desplY, duracion), fadeOut(duracion))));
                imgGround.addAction(sequence(delay(2 * espera),
                        parallel(moveBy(0, desplY, duracion), fadeOut(duracion))));
            }

        });

        stage = new Stage();
        tblLayout.setFillParent(true);
        stage.addActor(tblLayout);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        stage.act();

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

}
