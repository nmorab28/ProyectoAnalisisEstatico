package co.edu.unbosque.view;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInicio extends JPanel {
	private JButton botonIniciar, botonRegistrarse;
	private JLabel fondoInicio;

	public PanelInicio(ActionListener listener) {

		setLayout(null);
		
		botonIniciar = new JButton();
		ImageIcon botonI = new ImageIcon("Imagenes/inicioo.png");
		botonIniciar.addActionListener(listener);
		botonIniciar.setBounds(146, 463, 332,63);
		botonIniciar.setContentAreaFilled(false);
		botonIniciar.setBorder(null);
		botonIniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonIniciar.setIcon(new ImageIcon(botonI.getImage().getScaledInstance(botonIniciar.getWidth(), botonIniciar.getHeight(), Image.SCALE_SMOOTH)));
		botonIniciar.setActionCommand("BOTON_INICIO");
		add(botonIniciar);

		botonRegistrarse = new JButton();
		ImageIcon boton = new ImageIcon("Imagenes/inicioRegis.png");
		botonRegistrarse.addActionListener(listener);
		botonRegistrarse.setBounds(532, 463, 332,63);
		botonRegistrarse.setContentAreaFilled(false);
		botonRegistrarse.setBorder(null);
		botonRegistrarse.setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonRegistrarse.setIcon(new ImageIcon(boton.getImage().getScaledInstance(botonRegistrarse.getWidth(), botonRegistrarse.getHeight(), Image.SCALE_SMOOTH)));
		botonRegistrarse.setActionCommand("BOTON_INICIO_REGISTRAR");
		add(botonRegistrarse);
			 
		fondoInicio = new JLabel();
		fondoInicio.setSize(1000, 650);
		fondoInicio.setIcon(new ImageIcon("Imagenes/Inicio.png"));
		add(fondoInicio);
	}

}
