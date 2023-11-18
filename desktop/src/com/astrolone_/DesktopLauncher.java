package com.astrolone_;
import com.astrolone_.Drop;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.astrolone_.Enemies;
// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("astrolone_");
		new Lwjgl3Application(new Enemies(), config);

		
		Enemies enemy = new Enemies();
		enemy.create();
		enemy.render();
		enemy.dispose();
	}
}
