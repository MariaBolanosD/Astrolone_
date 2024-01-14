package Objetos;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.GestorFicheros;

public class Puntuacion {
	
	private int puntuacion;
	private String nickJugador;
	private String fecha;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	
	
	public Puntuacion(int puntuacion, String nickJugador) {
		this.puntuacion = puntuacion;
		this.nickJugador = nickJugador;
		this.fecha = sdf.format(new Date()) ;
	}
	
	


	public Puntuacion(int puntuacion, String nickJugador, String fecha) {
		super();
		this.puntuacion = puntuacion;
		this.nickJugador = nickJugador;
		this.fecha = fecha;
	}


	public void guardarPuntuacion() {
		
		GestorFicheros gf = new GestorFicheros();
		gf.puntuacionAFichero(this);
		
	}
	

	public int getPuntuacion() {
		return puntuacion;
	}




	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}




	public String getNickJugador() {
		return nickJugador;
	}




	public void setNickJugador(String nickJugador) {
		this.nickJugador = nickJugador;
	}




	public String getFecha() {
		return fecha;
	}




	public void setFecha(String fecha) {
		this.fecha = fecha;
	}




	@Override
	public String toString() {
		return nickJugador+";"+puntuacion+";"+fecha;
	}


		
	

}
