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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.badlogic.gdx.Gdx;

public class Settings {
	public static boolean soundEnabled = true;
	public final static int[] highscores = new int[] {40, 30, 20, 10, 0};
	public final static String file = ".fishCave";

	public static void load () {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(Gdx.files.external(file).read()));
			soundEnabled = Boolean.parseBoolean(in.readLine());
			for (int i = 0; i < 5; i++) {
				highscores[i] = Integer.parseInt(in.readLine());
			}
		} catch (Throwable e) {
			// :( It's ok we have defaults
		} finally {
			try {
				if (in != null) in.close();
			} catch (IOException e) {
			}
		}
	}

	public static void save () {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(Gdx.files.external(file).write(false)));
			out.write(Boolean.toString(soundEnabled));
			for (int i = 0; i < 5; i++) {
				out.write(Integer.toString(highscores[i]));
			}

		} catch (Throwable e) {
		} finally {
			try {
				if (out != null) out.close();
			} catch (IOException e) {
			}
		}
	}

	public static void addScore (int score) {
		for (int i = 0; i < 5; i++) {
			if (highscores[i] < score) {
				for (int j = 4; j > i; j--)
					highscores[j] = highscores[j - 1];
				highscores[i] = score;
				break;
			}
		}
	}
}
