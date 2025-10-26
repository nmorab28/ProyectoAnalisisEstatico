package co.edu.unbosque.view;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelEtapa extends JPanel{
	private JLabel fondoVentana;
	private JButton montaña, llano, semiLlano, btnSalir;
	
	public PanelEtapa(ActionListener listener) {
		setLayout(null);
		
		montaña= new JButton();
		ImageIcon flechita = new ImageIcon("Imagenes/montaña.png");
		montaña.setBounds(70, 500, 229, 35);
		montaña.setContentAreaFilled(false);
		montaña.setBorder(null);
		montaña.setCursor(new Cursor(Cursor.HAND_CURSOR));
		montaña.setIcon(new ImageIcon(flechita.getImage().getScaledInstance(montaña.getWidth(),
				montaña.getHeight(), Image.SCALE_SMOOTH)));
		montaña.setActionCommand("BOTON_MONTAÑA");
		montaña.addActionListener(listener);
		add(montaña);
		
		llano= new JButton();
		ImageIcon flechitaLlano = new ImageIcon("Imagenes/llano.png");
		llano.setBounds(380, 500, 230, 36);
		llano.setContentAreaFilled(false);
		llano.setBorder(null);
		llano.setCursor(new Cursor(Cursor.HAND_CURSOR));
		llano.setIcon(new ImageIcon(flechitaLlano.getImage().getScaledInstance(llano.getWidth(),
				llano.getHeight(), Image.SCALE_SMOOTH)));
		llano.setActionCommand("BOTON_LLANO");
		llano.addActionListener(listener);
		add(llano);
		
		semiLlano= new JButton();
		ImageIcon flechitaSemiLlano = new ImageIcon("Imagenes/semillano.png");
		semiLlano.setBounds(710, 500, 230, 36);
		semiLlano.setContentAreaFilled(false);
		semiLlano.setBorder(null);
		semiLlano.setCursor(new Cursor(Cursor.HAND_CURSOR));
		semiLlano.setIcon(new ImageIcon(flechitaSemiLlano.getImage().getScaledInstance(semiLlano.getWidth(),
				semiLlano.getHeight(), Image.SCALE_SMOOTH)));
		semiLlano.setActionCommand("BOTON_SEMILLANO");
		semiLlano.addActionListener(listener);
		add(semiLlano);
		
		
		btnSalir = new JButton();
		ImageIcon botonSalir = new ImageIcon("Imagenes/exit.png");
		btnSalir.addActionListener(listener);
		btnSalir.setBounds(880, 40, 75,65);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorder(null);
		btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSalir.setIcon(new ImageIcon(botonSalir.getImage().getScaledInstance(btnSalir.getWidth(), btnSalir.getHeight(), Image.SCALE_SMOOTH)));
		btnSalir.setActionCommand("BOTON_EXIT_ETAPA");
		add(btnSalir);
		
		fondoVentana = new JLabel();
		fondoVentana.setSize(1000, 640);
		ImageIcon icono = new ImageIcon("Imagenes/etapas.png");
		Image imagen = icono.getImage();
		imagen = imagen.getScaledInstance(fondoVentana.getWidth(), fondoVentana.getHeight(), Image.SCALE_SMOOTH);
		fondoVentana.setIcon(new ImageIcon(imagen));
		add(fondoVentana);
	}
}
