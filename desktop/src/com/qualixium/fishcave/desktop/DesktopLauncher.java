package com.qualixium.fishcave.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.qualixium.fishcave.FishcaveGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.title = "FishCave";
		config.useGL30 = false;
                config.width = 480;
		config.height = 720;
          new LwjglApplication(new FishcaveGame(new ActionResolverDesktop()), config);
	}
}
