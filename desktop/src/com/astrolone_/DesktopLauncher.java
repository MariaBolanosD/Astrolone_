package com.astrolone_;
import com.astrolone_.Drop;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
<<<<<<< HEAD
import com.astrolone_.Enemies;
=======


>>>>>>> 9a0a4200778361c6504de1905082976e379381f9
// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("astrolone_");
<<<<<<< HEAD
		new Lwjgl3Application(new Enemies(), config);
=======
		new Lwjgl3Application(new AstroLone_Juego(), config);
>>>>>>> 9a0a4200778361c6504de1905082976e379381f9

		
		Enemies enemy = new Enemies();
		enemy.create();
		enemy.render();
		enemy.dispose();
	}
}
