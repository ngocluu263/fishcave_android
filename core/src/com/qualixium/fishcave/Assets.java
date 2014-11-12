/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualixium.fishcave;

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
    public static Texture gameReady;
    public static Texture gameOver;
    public static Texture splash;

    public static void load() {
        ground = new Texture("images/ground.png");
        fish = new Texture("images/fish.png");
        background = new Texture("images/background.png");
        rock = new Texture("images/rock.png");
        gameReady = new Texture("images/ready.png");
        gameOver = new Texture("images/gameover.png");
        splash = new Texture("images/classic_splash.jpg");
    }

    public static void dispose() {
        ground.dispose();
        fish.dispose();
        background.dispose();
        rock.dispose();
        gameReady.dispose();
        gameOver.dispose();
        splash.dispose();
    }

}
