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

import com.badlogic.gdx.Gdx;

import Objetos.Puntuacion;
import Objetos.Usuario;

public class CargaUsuarios {
	private static Connection conexionBBDD = null;
	private static Statement stmtBBDD;
	
	public static void initConnection( ) {
		try{
			comprobarJDBC();
			conexionBBDD = DriverManager.getConnection("jdbc:sqlite:resources/data");
			stmtBBDD = conexionBBDD.createStatement();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}
	
	public static void comprobarJDBC() {
		try {
			Class.forName("org.sqlite.JDBC");
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
		if(Gdx.files.internal("resources/data.db")==null) {
			try{
				stmtBBDD.execute("create database data");
			crearTablas();
			}catch(SQLException e ) {
				e.printStackTrace();
			}
		}
	}
	
	public static Statement crearStatement() {
		if(stmtBBDD!=null) {
			
			return stmtBBDD;
		}
		
		try {
			return conexionBBDD.createStatement();
		}catch(SQLException e ) {
			e.printStackTrace();
		}catch(NullPointerException e) {
			
			e.printStackTrace();
			
		}
			
				return stmtBBDD;
	}
	
	public ArrayList<Usuario> leerUsuarios(String condicion){
		if(conexionBBDD==null) {
			initConnection();
		}
		ArrayList<Usuario> puntuaciones = new ArrayList<>();
		crearStatement();
		
		
		
		try {
			ResultSet rs = stmtBBDD.executeQuery("SELECT * FROM usuario" + condicion);
			while(rs.next()) {
				String usuario = rs.getString("nick");
				String contrasenya = rs.getString("contraseña");
				puntuaciones.add(new Usuario(usuario,contrasenya));
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
	public void insertarUsuario(String usuario,String contrasenya) {
		try{
			stmtBBDD.execute("INSERT INTO usuario VALUES('"+usuario+"','"+contrasenya+"')");
		}catch(SQLException e ) {
			e.printStackTrace();
		}
	}
	public void reiniciarUsuarios() {
		try{
			stmtBBDD.executeUpdate("DROP TABLE IF EXISTS usuario");
			crearTablaUsuarios();
		}catch(SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void crearTablaUsuarios() {
		try{
			stmtBBDD.executeUpdate("create table usuario (nick string not null, contraseña string)");
			stmtBBDD.executeUpdate("insert into usuario (nick,contraseña) values ('admin','admin')");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}


