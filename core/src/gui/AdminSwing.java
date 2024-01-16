package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.table.TableCellRenderer;

import Objetos.Usuario;

public class AdminSwing extends JFrame{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTextField busqueda = new JTextField(10);
	public AdminSwing(List<Usuario> listaUsuarios) {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setSize(640,420);


		class MyRenderer extends JLabel implements TableCellRenderer{
			/**
			 *
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {

				setText(value.toString());
				if( value.toString().startsWith(busqueda.getText()) && !busqueda.getText().isBlank()) {
					this.setBackground(Color.CYAN);
				}else {
					this.setBackground(Color.WHITE);
				}

				setOpaque(true);
				return this;
			}
		}

		JTable tabla = new JTable(new ModeloTablaAdmin(listaUsuarios));
		tabla.setDefaultRenderer(Object.class, new MyRenderer());
		JScrollPane scrollPane = new JScrollPane(tabla);
		JButton cerrar = new JButton("Cerrar");
		JButton buscar = new JButton("Buscar");
		JPanel pInferior = new JPanel();

		JPanel pIzquierdo = new JPanel();
		JLabel lBusqueda = new JLabel("Buscar usuarios: ");

		pIzquierdo.add(lBusqueda);
		pIzquierdo.add(busqueda);
		add(pIzquierdo,BorderLayout.WEST);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		pInferior.add(cerrar);
		pInferior.add(buscar);
		add(scrollPane);
		add(pInferior,BorderLayout.SOUTH);

		cerrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		busqueda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Buscando");
				repaint();
			}
		});
		buscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint();
			}
		});


	}

}
