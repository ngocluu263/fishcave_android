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
        
        rate = new Texture("images/rate.png");
        play = new Texture("images/play.png");
        archivements = new Texture("images/archivements.png");
        leaderboard = new Texture("images/podium.png");
        
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
        
        sample.dispose();
        gameReady.dispose();
        gameOver.dispose();
        
        splash.dispose();
        music.dispose();
        explode.dispose();
    }

}
