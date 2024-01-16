package db;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Objetos.Puntuacion;
import Objetos.Usuario;

public class CargaUsuarios {
	private static Connection conexionBBDD = null;
	private static Statement stmtBBDD= null;
	
	public static void initConnection( String nombreBBDD) {
		try{
			comprobarJDBC();
			conexionBBDD = DriverManager.getConnection(nombreBBDD);
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}
	
	public static void comprobarJDBC() {
		try {
			Class.forName("org:sqlite.JDBC");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static void cerrarConection() {
		try{
			conexionBBDD.close();
		}catch(SQLException e ) {
			e.printStackTrace();
		}
	}
	
	public static void crearTablas() {
		stmtBBDD=crearStatement();
		String sql = "CREATE TABLE usuario (nick VARCHAR(20) not null,contraseña VARCHAR(20), PRIMARY KEY(nick)) ";
		try{
			stmtBBDD.executeQuery(sql);
		}catch(SQLException e ) {
			e.printStackTrace();
			System.out.println("Error al crear la tabla usuario");
		}
		sql = "CREATE TABLE puntuacion (nick VARCHAR(20) not null, puntuacion INTEGER, fecha VARCHAR(20), PRIMARY KEY(nick))";
		try {
			stmtBBDD.executeQuery(sql);
		}catch(SQLException e )
		{
			e.printStackTrace();
			System.out.println("Error al crear la tabla puntuacion");
		}
	}
	
	public static Statement crearStatement() {
		if(stmtBBDD!=null)return stmtBBDD;
		
		try {
			return conexionBBDD.createStatement();
		}catch(SQLException e ) {
			e.printStackTrace();
		}
				return null;
	}
	
	public static ArrayList<Puntuacion> leerUsuarios(String condicion){
		ArrayList<Puntuacion> puntuaciones = new ArrayList<>();
		crearStatement();
		
		try {
			ResultSet rs = stmtBBDD.executeQuery("SELECT * FROM usuario" + condicion);
			while(rs.next()) {
				String usuario = rs.getString("nick");
				String fecha = rs.getString("fecha");
				int puntuacion = rs.getInt("puntuacion");
				puntuaciones.add(new Puntuacion(puntuacion, usuario, fecha));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return puntuaciones;
	}
	
	public static Connection getConexionBBDD() {
		return conexionBBDD;
	}

	public static void setConexionBBDD(Connection conexionBBDD) {
		CargaUsuarios.conexionBBDD = conexionBBDD;
	}

	public static void main(String[] args) {
		initConnection("AstroloneBBDD");
	}
}


