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
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.qualixium.fishcave.Assets;
import com.qualixium.fishcave.FishcaveGame;
import com.qualixium.fishcave.GameState;
import com.qualixium.fishcave.Settings;
import com.qualixium.fishcave.actors.SignActor;
import java.util.Arrays;

/**
 *
 * @author homepro
 */
public class GameoverScreen extends Screens {

    public static Stage stage;
    private TextureRegionDrawable tblBackground;
    private TextureRegion ceiling, ground;
    private Image imgCeiling, imgGround;

    public GameoverScreen(FishcaveGame game) {
        super(game);
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

        final Image imgGameover = new Image(Assets.gameOver);

         ImageButton btnPlay, btnScoreboard, btnArchivements;
        ImageButton.ImageButtonStyle iconPlay, iconScoreboard, iconArchivement;
        
        iconPlay = new ImageButton.ImageButtonStyle(skin.get(Button.ButtonStyle.class));
        iconPlay.imageUp = new TextureRegionDrawable(new TextureRegion(Assets.play));
        iconScoreboard = new ImageButton.ImageButtonStyle(skin.get(Button.ButtonStyle.class));
        iconScoreboard.imageUp = new TextureRegionDrawable(new TextureRegion(Assets.leaderboard));
        iconArchivement = new ImageButton.ImageButtonStyle(skin.get(Button.ButtonStyle.class));
        iconArchivement.imageUp = new TextureRegionDrawable(new TextureRegion(Assets.archivements));
        
        btnPlay = new ImageButton(iconPlay);
        btnScoreboard = new ImageButton(iconScoreboard);
        btnArchivements = new ImageButton(iconArchivement);

        final int sep = 20, span = 2, h = 80, w = 150;

        Table tblLayout = new Table();
        tblLayout.setFillParent(true);
        tblLayout.setBackground(tblBackground);
        tblLayout.add(imgCeiling).space(sep).colspan(span).row();
        tblLayout.add(imgGameover).space(sep).colspan(span).row();

        Table tblResults = new Table();
        Label stringScore = new Label(GameScreen.scroreString, skin);
        Label currentScore = new Label(Integer.toString(SignActor.score), skin);
        Label stringBest = new Label("Best", skin);
        Label bestScore = new Label(Integer.toString(Settings.highscores[4]), skin);
        
        stringScore.setFontScale(2);
        currentScore.setFontScale(2);
        stringBest.setFontScale(2);
        bestScore.setFontScale(2);
        
        tblResults.add(stringScore).pad(sep);
        tblResults.add(currentScore).pad(sep).row();
        tblResults.add(stringBest).pad(sep);
        tblResults.add(bestScore).pad(sep).row();
        
        tblLayout.add(tblResults).space(sep).expand().colspan(span).row();
        
        tblLayout.add(btnPlay).pad(sep).size(w, h).colspan(span).row();
        tblLayout.add(btnArchivements).pad(sep).size(w, h);
        tblLayout.add(btnScoreboard).pad(sep).size(w, h).row();
        tblLayout.add(imgGround).space(sep).colspan(span).row();

        // Al hacer clic en el botón nuevo juego, los botones se van.
        btnPlay.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                if (!game.actionResolver.getSignedInGPGS()) {
                    game.actionResolver.loginGPGS();
                }
                game.setScreen(new GameScreen(game));

                GameState.state = GameState.State.Start;
                GameScreen.resetWorld();
            }
        });

        btnScoreboard.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                if (game.actionResolver.getSignedInGPGS()) {
                    game.actionResolver.getLeaderboardGPGS();
                } else {
                    game.actionResolver.loginGPGS();
                }
            }
        });

        btnArchivements.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                if (game.actionResolver.getSignedInGPGS()) {
                    game.actionResolver.getAchievementsGPGS();
                } else {
                    game.actionResolver.loginGPGS();
                }
            }
        });

        stage = new Stage();
        tblLayout.setFillParent(true);
        stage.addActor(tblLayout);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        stage.act();

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

}
