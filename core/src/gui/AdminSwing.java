package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import Objetos.Usuario;

public class AdminSwing extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminSwing(List<Usuario> listaUsuarios) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setSize(640,420);
		
		JTable tabla = new JTable(new ModeloTablaAdmin(listaUsuarios));
		
		JScrollPane scrollPane = new JScrollPane(tabla);
		JButton cerrar = new JButton("Cerrar");
		JPanel pInferior = new JPanel();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		pInferior.add(cerrar);
		add(scrollPane);
		add(pInferior,BorderLayout.SOUTH);
		
		cerrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
	}
	
}
