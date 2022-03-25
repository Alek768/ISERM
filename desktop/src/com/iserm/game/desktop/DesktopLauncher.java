package com.iserm.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.iserm.game.IserMain;
import com.iserm.game.SQL;

import java.io.IOException;
import java.sql.*;

public class DesktopLauncher {
	public static void main (String[] arg) throws IOException, SQLException {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new IserMain(), config);
		//Créations d'une instance SQL
		SQL s = SQL.getInstance();
		//Chargement du Player.
		Joueur J = new Joueur(1);
		J.config(s);
		System.out.println(J.toString());
	}
}
