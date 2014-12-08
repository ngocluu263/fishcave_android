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
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.qualixium.fishcave.Assets;
import com.qualixium.fishcave.FishcaveGame;
import com.qualixium.fishcave.actors.FishActor;
import com.qualixium.fishcave.Settings;

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
    public static boolean socialShow = false;
    public static boolean settingsShow = false;

    public MenuScreen(FishcaveGame game) {
        super(game);

        fish = new FishActor();
        Assets.music.setLooping(true);
        Assets.music.play();

    }

    @Override
    public void show() {

        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        final int sep = 10, span = 3, h = 80, w = 130;

        tblBackground = new TextureRegionDrawable(new TextureRegion(Assets.background));
        ground = new TextureRegion(Assets.ground);
        ceiling = new TextureRegion(Assets.ground);
        ceiling.flip(false, true);
        imgGround = new Image(ground);
        imgCeiling = new Image(ceiling);

        final Image imgTitle = new Image(Assets.title);

        final ImageButton btnRate, btnPlay, btnScoreboard, btnArchivements, btnShare,
                btnInfo, btnSettings, btnAudio, btnFacebook, btnTwitter, btnInstagram, btnGplus,
                btnYoutube, btnPinterest, btnTumblr;

        btnRate = new ImageButton(new TextureRegionDrawable(new TextureRegion(Assets.rate)));
        btnPlay = new ImageButton(new TextureRegionDrawable(new TextureRegion(Assets.play)));
        btnScoreboard = new ImageButton(new TextureRegionDrawable(new TextureRegion(Assets.leaderboard)));
        btnArchivements = new ImageButton(new TextureRegionDrawable(new TextureRegion(Assets.archivements)));
        btnShare = new ImageButton(new TextureRegionDrawable(new TextureRegion(Assets.share)));
        btnInfo = new ImageButton(new TextureRegionDrawable(new TextureRegion(Assets.info)));
        btnSettings = new ImageButton(new TextureRegionDrawable(new TextureRegion(Assets.settings)));
        btnAudio = new ImageButton(new TextureRegionDrawable(new TextureRegion(Assets.audio)));
        btnFacebook = new ImageButton(new TextureRegionDrawable(new TextureRegion(Assets.facebook)));
        btnTwitter = new ImageButton(new TextureRegionDrawable(new TextureRegion(Assets.twitter)));
        btnInstagram = new ImageButton(new TextureRegionDrawable(new TextureRegion(Assets.instagram)));
        btnGplus = new ImageButton(new TextureRegionDrawable(new TextureRegion(Assets.gplus)));
        btnYoutube = new ImageButton(new TextureRegionDrawable(new TextureRegion(Assets.youtube)));
        btnPinterest = new ImageButton(new TextureRegionDrawable(new TextureRegion(Assets.pinterest)));
        btnTumblr = new ImageButton(new TextureRegionDrawable(new TextureRegion(Assets.tumblr)));

        Label lblCredits = new Label(" (c) QUALIXIUM 2014", skin);

        Table tblLayout = new Table();
        tblLayout.setFillParent(true);

        Table tblBar = new Table();

        final Dialog settings = new Dialog("Settings:", skin);
        Table settingsBar = new Table();
        settingsBar.add(btnAudio).minSize(w / 2, h / 2).space(sep).row();
        settings.add(settingsBar);

        tblBar.add(btnSettings).minSize(w / 2, h / 2).space(30);
        
        final Dialog dialogAbout = new Dialog("About", skin);
        Table tblAbout = new Table();
        tblAbout.setFillParent(true);
        TextButton btnAboutClose = new TextButton("OK", skin);
        tblAbout.add(new Label("Fish Cave (c) QUALIXIUM", skin)).center().padTop(sep).row();
        tblAbout.add(new Label("Music", skin)).center().padTop(sep).row();
        tblAbout.add(new Label("'n-Dimensions'", skin)).center().row();
        tblAbout.add(new Label("Matthew Pablo (http://www.matthewpablo.com)", skin)).center().row();
        tblAbout.add(new Label("Images and font", skin)).center().padTop(sep).row();
        tblAbout.add(new Label("Kenney (www.kenney.nl)", skin)).center().row();
        tblAbout.add(new Label("Icons made by", skin)).center().padTop(sep).row();
        tblAbout.add(new Label("Elegant Themes, Yannick, Freepik (www.flaticon.com)  ", skin)).center().row();
        tblAbout.add(new Label("licensed by CC BY 3.0", skin)).center().row();
        tblAbout.add(btnAboutClose).minSize(w / 2, h / 2).space(sep).center().row();
        dialogAbout.add(tblAbout);
        
        tblBar.add(btnInfo).minSize(w / 2, h / 2).space(30);

        final Dialog social = new Dialog("Follow us:", skin);
        Table socialBar = new Table();
        socialBar.add(btnFacebook).minSize(w / 2, h / 2).space(sep).row();
        socialBar.add(btnTwitter).minSize(w / 2, h / 2).space(sep).row();
        socialBar.add(btnInstagram).minSize(w / 2, h / 2).space(sep).row();
        socialBar.add(btnGplus).minSize(w / 2, h / 2).space(sep).row();
        socialBar.add(btnYoutube).minSize(w / 2, h / 2).space(sep).row();
        socialBar.add(btnPinterest).minSize(w / 2, h / 2).space(sep).row();
        socialBar.add(btnTumblr).minSize(w / 2, h / 2).space(sep).row();
        social.add(socialBar);

        tblBar.add(btnShare).minSize(w / 2, h / 2).space(30);
        tblBar.add(btnRate).minSize(w / 2, h / 2).space(30).row();

        Table tblMain = new Table();
        tblMain.setBackground(tblBackground);

        tblMain.add(imgCeiling).space(sep).colspan(span).minSize(w, h).row();
        tblMain.add(imgTitle).space(sep).colspan(span).minSize(w, h).row();
        tblMain.add(fish).space(sep).expand().colspan(span).minSize(w, h).row();
        tblMain.add(btnPlay).pad(sep).minSize(w, h).colspan(span).row();
        tblMain.add(btnScoreboard).pad(5).minSize(w, h);
        tblMain.add().pad(5);
        tblMain.add(btnArchivements).pad(5).minSize(w, h).row();
        tblMain.add(lblCredits).pad(sep).colspan(span).row();
        tblMain.add(imgGround).space(sep).minSize(w, h).colspan(span).row();

        tblLayout.add(tblMain).space(sep).expand().row();
        tblLayout.add(tblBar).space(sep).row();

        btnShare.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (!socialShow) {
                    social.show(stage);
                    social.setPosition(btnShare.getRight(), btnShare.getTop());
                    social.setMovable(false);
                    social.setModal(false);
                    socialShow = true;
                } else {
                    social.hide();
                    socialShow = false;
                }
            }

        });
        
        btnInfo.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                dialogAbout.show(stage);
            }
        });
        
        btnAboutClose.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                dialogAbout.hide();
            }
        });

        btnFacebook.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                social.hide();
                socialShow = false;
                Gdx.net.openURI("https://www.facebook.com/qualixium");
            }
        });

        btnTwitter.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                social.hide();
                socialShow = false;
                Gdx.net.openURI("https://twitter.com/qualixium");
            }
        });

        btnInstagram.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                social.hide();
                socialShow = false;
                Gdx.net.openURI("http://instagram.com/qualixiumgames");
            }
        });

        btnGplus.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                social.hide();
                socialShow = false;
                Gdx.net.openURI("http://gplus.to/qualixium");
            }
        });

        btnYoutube.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                social.hide();
                socialShow = false;
                Gdx.net.openURI("https://www.youtube.com/channel/UCzpZWFmPWBWKG4H0q0yP3AQ");
            }
        });

        btnPinterest.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                social.hide();
                socialShow = false;
                Gdx.net.openURI("http://www.pinterest.com/qualixium/");
            }
        });

        btnTumblr.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                social.hide();
                socialShow = false;
                Gdx.net.openURI("http://qualixium.tumblr.com/");
            }
        });

        btnSettings.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (!settingsShow) {
                    settings.show(stage);
                    settings.setPosition(btnSettings.getRight(), btnSettings.getTop());
                    settings.setMovable(false);
                    settings.setModal(false);
                     settingsShow = true;
                } else {
                    settings.hide();
                    settingsShow = false;
                }
            }

        });

        btnAudio.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Settings.soundEnabled = !Settings.soundEnabled;
                if (Settings.soundEnabled) {
                    Assets.music.play();
                } else {
                    Assets.music.pause();
                }
            }

        });

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

        stage = new Stage(new ExtendViewport(480, 720));
        stage.addActor(tblLayout);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(58 / 255f, 80 / 255f, 175 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        stage.act();

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

}
