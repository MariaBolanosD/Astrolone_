package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Objetos.Usuario;

public class ModeloTablaAdmin extends AbstractTableModel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Usuario> listaUsuarios;
	private String[] cabeceras = {"Nombre","Contraseña"};
	public ModeloTablaAdmin(List<Usuario> usuarios) {
		this.listaUsuarios = usuarios;
	}
	@Override
	public int getColumnCount() {
		return cabeceras.length;
	}
	@Override
	public int getRowCount() {
		return listaUsuarios.size();
	}
	@Override
	public String getColumnName(int column) {
		return cabeceras[column];
	}
	@Override
	public Object getValueAt(int row, int column) {
		switch(column) {
		
		case 1:{
			listaUsuarios.get(row).getContrasenyaUsuario();
		}
		default:{
			return listaUsuarios.get(row).getNombreUsuario();
		}
		}
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	
	
	
}
