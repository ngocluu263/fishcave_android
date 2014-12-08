/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualixium.fishcave;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

/**
 *
 * @author homepro
 */
public class Assets {

    public static Texture ground;
    public static Texture fish;
    public static Texture background;
    public static Texture rock;
    public static Texture title;

    public static Texture rate;
    public static Texture share;
    public static Texture info;
    public static Texture settings;

    public static Texture audio;

    public static Texture facebook;
    public static Texture twitter;
    public static Texture instagram;
    public static Texture gplus;
    public static Texture youtube;
    public static Texture pinterest;
    public static Texture tumblr;

    public static Texture play;
    public static Texture archivements;
    public static Texture leaderboard;

    public static Texture sample;
    public static Texture gameReady;
    public static Texture gameOver;

    public static Texture splash;
    public static Music music;
    public static Sound explode;

    public static void load() {
        ground = new Texture("images/ground.png");
        fish = new Texture("images/fish.png");
        background = new Texture("images/background.png");
        rock = new Texture("images/rock.png");
        title = new Texture("images/title.png");

        rate = new Texture("images/icons/star.png");
        play = new Texture("images/icons/play.png");
        archivements = new Texture("images/icons/trophy.png");
        leaderboard = new Texture("images/icons/leaders.png");

        share = new Texture("images/icons/share.png");
        info = new Texture("images/icons/info.png");
        settings = new Texture("images/icons/tools.png");
        audio = new Texture("images/icons/audio.png");
        facebook = new Texture("images/icons/facebook.png");
        twitter = new Texture("images/icons/twitter.png");
        instagram = new Texture("images/icons/instagram.png");
        gplus = new Texture("images/icons/gplus.png");
        youtube = new Texture("images/icons/youtube.png");
        pinterest = new Texture("images/icons/pinterest.png");
        tumblr = new Texture("images/icons/tumblr.png");

        sample = new Texture("images/sample.png");
        gameReady = new Texture("images/ready.png");
        gameOver = new Texture("images/gameover.png");

        splash = new Texture("images/splash.jpg");

        music = Gdx.audio.newMusic(Gdx.files.internal("sounds/music.mp3"));
        explode = Gdx.audio.newSound(Gdx.files.internal("sounds/explode.wav"));

    }

    public static void dispose() {
        ground.dispose();
        fish.dispose();
        background.dispose();
        rock.dispose();
        title.dispose();

        rate.dispose();
        play.dispose();
        archivements.dispose();
        leaderboard.dispose();
        
        share.dispose();
        info.dispose();
        settings.dispose();
        audio.dispose();
        facebook.dispose();
        twitter.dispose();
        instagram.dispose();
        gplus.dispose();
        youtube.dispose();
        pinterest.dispose();
        tumblr.dispose();

        sample.dispose();
        gameReady.dispose();
        gameOver.dispose();

        splash.dispose();
        music.dispose();
        explode.dispose();
    }

}
