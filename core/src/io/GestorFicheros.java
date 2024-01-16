package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


import Objetos.Puntuacion;

public class GestorFicheros {

	private BufferedReader bf;
	private BufferedWriter bf2;
	public void puntuacionAFichero(Puntuacion p) {

		Path path = Paths.get("");

		try {
			


			FileWriter fileW = new FileWriter(path+"resources/puntuaciones.csv",true);
			fileW.write(p.toString()+"\n");
			fileW.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	public ArrayList<Puntuacion> leerPuntuaciones(){
		Path path = Paths.get("");
		ArrayList<Puntuacion> puntuaciones = new ArrayList<>();
		File archivo = new File(path+"resources/puntuaciones.csv");
		try{
			FileReader fr = new FileReader(archivo);
			bf = new BufferedReader(fr);
			try {

				String linea = bf.readLine();
				while(null!=linea && linea!="") {
					String[] campos = linea.split(";");
					puntuaciones.add(new Puntuacion((int) Integer.valueOf(campos[1]),campos[0],campos[2]));
					linea = bf.readLine();
				}

				return puntuaciones;
			}catch(IOException e) {
				e.printStackTrace();
				return puntuaciones;
			}catch(NullPointerException e) {
				e.printStackTrace();
				return puntuaciones;
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}



	}
	public void reiniciarPuntuaciones() {
		try {
			Path path = Paths.get("");
			bf2 = new BufferedWriter(new FileWriter(path+"resources/puntuaciones.csv"));
			bf2.write("");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}


}
