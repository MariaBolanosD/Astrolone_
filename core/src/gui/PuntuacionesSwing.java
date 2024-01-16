
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class PuntuacionesSwing extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private static ArrayList<Puntuacion> puntuaciones; 
	
	public PuntuacionesSwing() {
		setSize(820,640);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		JButton bVolver = new JButton("Volver");
		JButton bBuscar = new JButton("Buscar");
		JPanel pBotones = new JPanel();
		JTable tabla = new JTable(new ModeloTablaPuntuaciones());
		JScrollPane scrollPane = new JScrollPane(tabla);
//		DefaultTableCellRenderer centrarContenidos = new DefaultTableCellRenderer();
//		centrarContenidos.setHorizontalAlignment(JLabel.CENTER);
//		for(int i = 0; i< tabla.getColumnCount();i++) {
//			tabla.getColumn(i).setCellRenderer(centrarContenidos);
//		}
		
		pBotones.add(bBuscar);
		pBotones.add(bVolver);
		this.add(scrollPane);
		setVisible(true);
		
		bVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
}



