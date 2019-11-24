package com.naglfar_package.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.naglfar_package.Naglfar_Main;
import com.naglfar_package.Connect;
import com.naglfar_package.Create_Sol_System;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Naglfar_Main(), config);
	}
}
