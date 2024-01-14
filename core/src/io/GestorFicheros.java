package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.badlogic.gdx.Gdx;

import Objetos.Puntuacion;

public class GestorFicheros {

	public void puntuacionAFichero(Puntuacion p) {
	
		Path path = Paths.get("");
		
		try {
			System.out.println(path.toAbsolutePath());
			
			
			FileWriter fileW = new FileWriter(path+"puntuaciones.csv",true);
			BufferedWriter bF = new BufferedWriter(fileW);
			fileW.write(p.toString()+"\n");
			fileW.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
