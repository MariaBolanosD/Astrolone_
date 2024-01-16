package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
<<<<<<< HEAD
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


=======
import javax.swing.WindowConstants;
>>>>>>> main

public class PuntuacionesSwing extends JFrame{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
//	private static ArrayList<Puntuacion> puntuaciones; 
	
=======

>>>>>>> main
	public PuntuacionesSwing() {
		setSize(820,640);
		setLocationRelativeTo(null);
<<<<<<< HEAD
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
=======
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);



>>>>>>> main
	}

}
