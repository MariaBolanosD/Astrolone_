package com.astrolone_;
<<<<<<< HEAD
import java.util.ArrayList;


import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import gui.LoginScreenSwing;

=======
>>>>>>> main

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	private static boolean inicio;
	private static LoginScreenSwing vent;
	public static void main (String[] arg) {
<<<<<<< HEAD
		
//		vent = new LoginScreenSwing(new ArrayList<>());
//		while(vent.isFocused())
//		if(vent.getInicioSesion()) {
		vent = new LoginScreenSwing(new ArrayList<>());
			Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
			config.setForegroundFPS(60);
			config.setTitle("astrolone_");
			new Lwjgl3Application(new AstroLone_Juego(), config);
	
			
			
//		}
=======
		//Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		//config.setForegroundFPS(60);
		//config.setTitle("astrolone_");
		
		//new Lwjgl3Application(new AstroLone_Juego(), config);
		
		
        LoginScreenSwing.main(arg);
       
		//Drop drop = new Drop();
		//drop.create();
		//drop.render();
>>>>>>> main
	}
}
