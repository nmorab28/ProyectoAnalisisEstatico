package co.edu.unbosque.view;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class VentanaEtapa extends JFrame{
	private PanelEtapa panelEtapa;
	private ActionListener listener;
	
	public VentanaEtapa(ActionListener listener) {
		this.listener = listener;
		setSize(1000, 650);
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		initComponents();
		setLocationRelativeTo(null); // Centra la ventana en la pantalla
		setVisible(true);
	}

	private void initComponents() {
		panelEtapa = new PanelEtapa(listener);
		add(panelEtapa);
		
	}

}
