package co.edu.unbosque.view;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class VentanaLlano extends JFrame {
	private PanelLlano panelLlano;
	private ActionListener listener;

	public VentanaLlano(ActionListener listener) {
		this.listener = listener;
		setSize(1000, 650);
		setTitle("mostar tu info");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		initProgram();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initProgram() {
		panelLlano = new PanelLlano(listener);
		add(panelLlano);

	}
	public PanelLlano getPanelMontana() {
		return panelLlano;
	}

}
