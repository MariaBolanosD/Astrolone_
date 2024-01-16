package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Objetos.Puntuacion;
import io.GestorFicheros;

public class ModeloTablaPuntuaciones extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] cabeceras = {"Usuario","Puntuación","Fecha"};
	private List<Puntuacion>listaPuntuaciones;
	private GestorFicheros gF = new GestorFicheros();
	
	
	public ModeloTablaPuntuaciones() {
		this.listaPuntuaciones = gF.leerPuntuaciones(); 
	}
	@Override
	public int getColumnCount() {
		return cabeceras.length;
	}

	@Override
	public int getRowCount() {
		return listaPuntuaciones.size();
	}

	@Override
	public String getColumnName(int column) {
		return cabeceras[column];
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		switch(column) {
		case 0: return listaPuntuaciones.get(row).getNickJugador();
		case 1: return listaPuntuaciones.get(row).getPuntuacion();
		default :return listaPuntuaciones.get(row).getFecha();
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	
	
	
}
