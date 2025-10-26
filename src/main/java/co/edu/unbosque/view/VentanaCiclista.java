package co.edu.unbosque.view;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class VentanaCiclista extends JFrame {
	private PanelOpcion panelOp;
	private ActionListener listener;

	public VentanaCiclista(ActionListener listener) {
		this.listener = listener;
		setSize(1000, 650);
		setTitle("Creacion de escuadra");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		initComponents();
		setLocationRelativeTo(null); // Centra la ventana en la pantalla
		setVisible(true);
	}

	private void initComponents() {	
		panelOp = new PanelOpcion(listener);
		add(panelOp);

	}
	public PanelOpcion getPanelOpcion() {
		return this.panelOp;
	}

}
