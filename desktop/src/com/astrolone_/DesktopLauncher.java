package com.astrolone_;
import javax.swing.SwingUtilities;

import com.astrolone_.Drop;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;


// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	
	public static void main (String[] arg) {
		//Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		//config.setForegroundFPS(60);
		//config.setTitle("astrolone_");
		
		//new Lwjgl3Application(new AstroLone_Juego(), config);
		
		
        LoginScreenSwing.main(arg);
       
		//Drop drop = new Drop();
		//drop.create();
		//drop.render();
	}
}
