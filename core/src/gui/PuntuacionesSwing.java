
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Objetos.Puntuacion;
import io.GestorFicheros;



public class PuntuacionesSwing extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	private GestorFicheros gF = new GestorFicheros();
	private ArrayList<Puntuacion> puntuaciones = gF.leerPuntuaciones();  
	public PuntuacionesSwing() {
		setSize(820,640);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		System.out.println(puntuaciones);
		
		JButton bVolver = new JButton("Volver");
		JButton bBuscar = new JButton("Buscar");
		JPanel pBotones = new JPanel();
		JTable tabla = new JTable(new ModeloTablaPuntuaciones(puntuaciones));
		JScrollPane scrollPane = new JScrollPane(tabla);
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
	
//	public static ArrayList<Puntuacion>  separarPuntuaciones(ArrayList<Puntuacion> list, int inicio, int fin) {
//		ArrayList<Puntuacion> ordenada = new ArrayList<>() ;
//		if (inicio + 1< fin) {
//	        int mid= (inicio + fin) / 2;
//	        separarPuntuaciones(list, inicio, mid);
//	        separarPuntuaciones(list, mid , fin);
//	       ordenada = juntarLista(list, inicio, mid, fin);
//	    }
//		return ordenada;
//	   
//	}
//	public static ArrayList<Puntuacion> juntarLista(ArrayList<Puntuacion> list, int inicio, int mitad, int fin) {
//	    ArrayList<Puntuacion> izquierda = new ArrayList<>(list.subList(inicio, mitad));
//	    ArrayList<Puntuacion> derecha = new ArrayList<>(list.subList(mitad, fin));
//	    ArrayList<Puntuacion> ordenada = new ArrayList<>();
//	    int i = 0;
//	    int j = 0;
//	    int k = inicio;
//	    
//	    while (i < izquierda.size() && j < derecha.size()) {
//	        if (izquierda.get(i).getPuntuacion() <= derecha.get(j).getPuntuacion()) {
//	            ordenada.add(k, izquierda.get(i));
//	            i++;
//	        } else {
//	            ordenada.add(k, derecha.get(j));
//	            j++;
//	        }
//	        k++;
//	    }
//	    
//	    while (i < izquierda.size()) {
//	        ordenada.add(k, izquierda.get(i));
//	        i++;
//	        k++;
//	    }
//
//	    while (j < derecha.size()) {
//	        try {
//	            ordenada.add(k, derecha.get(j));
//	            j++;
//	            k++;
//	        }finally {
//				
//			}
//	    }
//	    return ordenada;
//	}
	
	
//	public static void ordenarPuntuaciones(List<Puntuacion> listaPuntuaciones2){
//		ArrayList<Puntuacion> puntuaciones = new ArrayList<>();
//
//		if(listaPuntuaciones2==null || listaPuntuaciones2.size()<= 1) {
//			return;
//		}
//
//		int mitad = puntuaciones.size()/2;
//		ArrayList<Puntuacion> izquierda = new ArrayList<>();
//		ArrayList<Puntuacion> derecha = new ArrayList<>();
//
//		System.arraycopy(listaPuntuaciones2, 0, izquierda, 0, mitad);
//
//		if(listaPuntuaciones2.size()-mitad>=0) {
//			System.arraycopy(listaPuntuaciones2, mitad, derecha, 0,puntuaciones.size() - mitad);
//		}
//
//		ordenarPuntuaciones(derecha);
//		ordenarPuntuaciones(izquierda);
//		juntar(izquierda, derecha, listaPuntuaciones2);
//
//	}
//
//	public static void juntar(ArrayList<Puntuacion> izquierda, ArrayList<Puntuacion> derecha,List<Puntuacion> listaPuntuaciones2) {
//		int i=0, j=0,k=0;
//		while(i<izquierda.size() && j<derecha.size()) {
//			if(izquierda.get(i).getPuntuacion() <= derecha.get(j).getPuntuacion() ) {
//				listaPuntuaciones2.set(k, izquierda.get(i));
//				k++;
//				i++;
//			}else {
//				listaPuntuaciones2.set(k, derecha.get(j));
//				k++;
//				j++;
//			}
//		}
//
//		while(i<izquierda.size()) {
//			listaPuntuaciones2.set(k,izquierda.get(i));
//			i++;
//			k++;
//		}
//
//		while(j<derecha.size()) {
//			listaPuntuaciones2.set(k, derecha.get(j));
//			j++;
//			k++;
//		}
//
//
//	}
	
}



