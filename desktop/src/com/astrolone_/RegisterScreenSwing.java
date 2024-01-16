package com.astrolone_;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Objetos.Usuario;
import db.CargaUsuarios;

public class RegisterScreenSwing extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JTextField tfUsuario = new JTextField(15);
	private JTextField tfContrasenya = new JTextField(15);
	private JTextField tfConfirma = new JTextField(15);
	private CargaUsuarios cu = new CargaUsuarios();
	
	public RegisterScreenSwing(List<Usuario> listaUsuariosRecibida) {
		setTitle("Registra Usuario");
		setVisible(true);
		setSize(640,420);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel pCentral = new JPanel();
		JPanel pBotones = new JPanel();
		JPanel pSeparacion = new JPanel();
		
		
		JLabel lNombreUsuario = new JLabel("Nombre de Usuario");
		JLabel lContrasenya = new JLabel("Introduce tu contrasenya");
		JLabel lContrasenyaConfirmacion = new JLabel("Confirma la contrasenya");
		
		JButton bRegistrar = new JButton("Registrar");
		JButton bCancelar = new JButton("Cancelar");
		
		pCentral.setLayout(new GridLayout(3, 2));
		
		pCentral.add(lNombreUsuario,BorderLayout.CENTER);
		pCentral.add(tfUsuario,BorderLayout.CENTER);
		pCentral.add(lContrasenya,BorderLayout.CENTER);
		pCentral.add(tfContrasenya,BorderLayout.CENTER);
		pCentral.add(lContrasenyaConfirmacion,BorderLayout.CENTER);
		pCentral.add(tfConfirma,BorderLayout.CENTER);
	
		pBotones.add(bCancelar,BorderLayout.SOUTH);
		pBotones.add(bRegistrar,BorderLayout.SOUTH);
		
		add(pSeparacion,BorderLayout.NORTH);
		add(pCentral);
		add(pBotones,BorderLayout.SOUTH);
		
		
		
		pack();
		
		bCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginScreenSwing vent = new LoginScreenSwing(listaUsuariosRecibida);
			}
		});
		
		bRegistrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listaUsuariosRecibida.contains(new Usuario(tfUsuario.getText(),""))) {
					JOptionPane.showConfirmDialog(null, "Ya existe un Usuario con ese nickname elija otro");
				}else if (!tfContrasenya.getText().equals(tfConfirma.getText())) {
					JOptionPane.showConfirmDialog(null, "La contraseña introducida ha de ser la misma");
				} else {
					listaUsuariosRecibida.add(new Usuario(tfUsuario.getText(),tfContrasenya.getText()));
					JOptionPane.showConfirmDialog(null, "Te has registrado exitosamente");
					cu.insertarUsuario(tfUsuario.getText(), tfContrasenya.getText());
				}
			}
		});
		
		
		
		
	}
	
}
