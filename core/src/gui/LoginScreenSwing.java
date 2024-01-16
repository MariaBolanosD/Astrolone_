package gui;
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






public class LoginScreenSwing extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean inicioSesion = false;
	
	private JTextField nombreUsuario = new JTextField(20);
	private JTextField contrasenya = new JTextField(20);
	
	public LoginScreenSwing(List<Usuario> listaUsuariosRecibida) {
		final List<Usuario> listaUsuarios = listaUsuariosRecibida;
		listaUsuarios.add(new Usuario("admin","admin"));
		listaUsuarios.add(new Usuario("Victor","hola"));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("ASTROLONE");
		setVisible(true);
		JPanel pCentral = new JPanel();
		JPanel pBotones = new JPanel();
		JPanel pUsuario = new JPanel();
		JPanel pContrasenya = new JPanel();
		JLabel lUsuario = new JLabel("Introduce tu Usuario:");
		JLabel lContrasenya = new JLabel("Introduce tu constraseña:");
		JButton botonAceptar = new JButton("Aceptar");
		JButton botonCancelar = new JButton("Cancelar");
		JButton botonRegistrar = new JButton("Registrar");
		JButton botonPuntuaciones = new JButton("Puntuaciones");
		
		pUsuario.add(nombreUsuario,BorderLayout.SOUTH);
		pContrasenya.add(contrasenya,BorderLayout.SOUTH);
		
		pCentral.setLayout(new GridLayout(2,2,5,5));
		pCentral.add(lUsuario);
		pCentral.add(pUsuario);
		pCentral.add(lContrasenya);
		pCentral.add(pContrasenya);
		pBotones.add(botonPuntuaciones);
		pBotones.add(botonRegistrar);
		pBotones.add(botonCancelar);
		pBotones.add(botonAceptar);
		
		
		add(pCentral);
		
		
		add(pBotones,BorderLayout.SOUTH);
		pack();

		botonCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});	
		
		botonAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listaUsuarios.contains(new Usuario(nombreUsuario.getText(),contrasenya.getText()))) {
					if(nombreUsuario.getText().equals("admin") && contrasenya.getText().equals("admin")) {
						dispose();
						new AdminSwing(listaUsuarios);
					}else if(listaUsuarios.get(listaUsuarios.indexOf(new Usuario(nombreUsuario.getText(),""))).getContrasenyaUsuario().equals(contrasenya.getText())){
						JOptionPane.showMessageDialog(null, "Has iniciado sesion correctamente");
						
						inicioSesion = true;
						
					}else {
						JOptionPane.showMessageDialog(null, "La contraseña no coincide");
						
					}
				}else {
					JOptionPane.showMessageDialog(null, "No existe un usuario con los datos introducidos");
				}
			}
		});
		botonRegistrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				 new RegisterScreenSwing(listaUsuarios);
			}
		});
		
		botonPuntuaciones.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				PuntuacionesSwing ventana = new PuntuacionesSwing();
			}
		});
//		nombreUsuario.getDocument().addDocumentListener(new DocumentListener() {
//			
//			@Override
//			public void removeUpdate(DocumentEvent e) {
//				ajustarTamanyoTexto(nombreUsuario);
//			}
//			
//			@Override
//			public void insertUpdate(DocumentEvent e) {
//				ajustarTamanyoTexto(nombreUsuario);
//			}
//			
//			@Override
//			public void changedUpdate(DocumentEvent e) {
//				ajustarTamanyoTexto(nombreUsuario);
//			}
//		});
		
		
	}
	
	public static void ajustarTamanyoTexto(JTextField campo) {
		if(campo.getText().length()>15) {
			campo.setSize(campo.getPreferredSize());
			campo.getParent().revalidate();	
		}
		
	}
	
	
	
	public boolean getInicioSesion() {
		return inicioSesion;
	}

	public static void main(String[] args) {
		List<Usuario> lista = new ArrayList<>();
		LoginScreenSwing vent = new LoginScreenSwing(lista);
	}
	
	
}
