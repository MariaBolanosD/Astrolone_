package gui;

import java.util.List;

import Objetos.Usuario;

public class ModeloTablaPuntuaciones {
	private String[] cabeceras = {"Usuario","Puntuación"};
	private List<Usuario>listaUsuarios;
	
	public ModeloTablaPuntuaciones(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios; 
	}
}
