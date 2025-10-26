package co.edu.unbosque.view;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAdmin extends JPanel{
	private JButton simulacion, verUsuarios;
	private JLabel fondoVentana;
	
	public PanelAdmin(ActionListener listener) {
		setLayout(null);
	
		
		simulacion = new JButton("pdf");
		ImageIcon botonSimulacion = new ImageIcon("Imagenes/simulacion.png");
		simulacion.addActionListener(listener);
		simulacion.setBounds(330, 440, 373,54);
		simulacion.setContentAreaFilled(false);
		simulacion.setBorder(null);
		simulacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		simulacion.setIcon(new ImageIcon(botonSimulacion.getImage().getScaledInstance(simulacion.getWidth(), simulacion.getHeight(), Image.SCALE_SMOOTH)));
		simulacion.setActionCommand("BOTON_SIMULACION");
		
		verUsuarios = new JButton("pdf");
		ImageIcon botonUsuarios = new ImageIcon("Imagenes/usuarios.png");
		verUsuarios.addActionListener(listener);
		verUsuarios.setBounds(330, 300, 378,54);
		verUsuarios.setContentAreaFilled(false);
		verUsuarios.setBorder(null);
		verUsuarios.setCursor(new Cursor(Cursor.HAND_CURSOR));
		verUsuarios.setIcon(new ImageIcon(botonUsuarios.getImage().getScaledInstance(verUsuarios.getWidth(), verUsuarios.getHeight(), Image.SCALE_SMOOTH)));
		verUsuarios.setActionCommand("BOTON_VER_USUARIOS");
		
		
		fondoVentana = new JLabel();
		fondoVentana.setSize(1000, 650);
		fondoVentana.setIcon(new ImageIcon("Imagenes/imAdmin.png"));

		add(simulacion);
		add(verUsuarios);
		add(fondoVentana);
	}

}
