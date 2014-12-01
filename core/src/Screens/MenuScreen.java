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
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
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
    private final Actor fish;

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

        final Image imgTitle = new Image(Assets.title);

        ImageButton btnRate, btnPlay, btnScoreboard, btnArchivements;
        ImageButtonStyle iconRate, iconPlay, iconScoreboard, iconArchivement;
        
        iconRate = new ImageButtonStyle(skin.get(ButtonStyle.class));
        iconRate.imageUp = new TextureRegionDrawable(new TextureRegion(Assets.rate));
        iconPlay = new ImageButtonStyle(skin.get(ButtonStyle.class));
        iconPlay.imageUp = new TextureRegionDrawable(new TextureRegion(Assets.play));
        iconScoreboard = new ImageButtonStyle(skin.get(ButtonStyle.class));
        iconScoreboard.imageUp = new TextureRegionDrawable(new TextureRegion(Assets.leaderboard));
        iconArchivement = new ImageButtonStyle(skin.get(ButtonStyle.class));
        iconArchivement.imageUp = new TextureRegionDrawable(new TextureRegion(Assets.archivements));
        
        btnRate = new ImageButton(iconRate);
        btnPlay = new ImageButton(iconPlay);
        btnScoreboard = new ImageButton(iconScoreboard);
        btnArchivements = new ImageButton(iconArchivement);
        
        Label lblCredits = new Label(" (c) Qualixium 2014", skin);
        
        final int sep = 10, span = 3, h = 80, w = 130;

        Table tblLayout = new Table();
        tblLayout.setFillParent(true);
        tblLayout.setBackground(tblBackground);
        tblLayout.add(imgCeiling).space(sep).colspan(span).row();
        tblLayout.add(imgTitle).space(sep).colspan(span).row();
        tblLayout.add(fish).space(sep).expand().colspan(span).row();
        tblLayout.add(btnPlay).pad(sep).size(200, h).colspan(span).row();
        tblLayout.add(btnScoreboard).space(sep).pad(5).size(w, h);
        tblLayout.add(btnArchivements).space(sep).pad(5).size(w, h);
        tblLayout.add(btnRate).space(sep).pad(5).size(w, h).row();
        tblLayout.add(lblCredits).pad(sep).colspan(span).row();
        tblLayout.add(imgGround).space(sep).colspan(span).row();

        btnRate.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.net.openURI("https://play.google.com/store/apps/details?id=com.qualixium.fishcave.android");
            }
        });

        btnPlay.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (!game.actionResolver.getSignedInGPGS()) {
                    game.actionResolver.loginGPGS();
                }
                game.setScreen(new GameScreen(game));
            }
        });

        btnScoreboard.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (game.actionResolver.getSignedInGPGS()) {
                    game.actionResolver.getLeaderboardGPGS();
                } else {
                    game.actionResolver.loginGPGS();
                }
            }
        });

        btnArchivements.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
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
