package com.iserm.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.iserm.game.IserMain;

import java.io.IOException;
import java.sql.*;

public class DesktopLauncher {
	public static void main (String[] arg) throws IOException, SQLException {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new IserMain(), config);
	}
}
