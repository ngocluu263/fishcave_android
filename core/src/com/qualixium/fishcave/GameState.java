/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualixium.fishcave;

/**
 *
 * @author homepro
 */
public class GameState {

    public static State state = State.Start;;


    public enum State {

        Start, Running, GameOver
    }

}
