package co.edu.unbosque.view;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class VentanaAdministrador extends JFrame {
	private PanelAdmin panelAdmin;
	private ActionListener listener;
	
	public VentanaAdministrador(ActionListener listener) {
		this.listener = listener;
		setTitle("Administrador");
		setSize(1000,680);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		initComponents();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initComponents() {
		panelAdmin = new PanelAdmin(listener);
		add(panelAdmin);
		
	}

}
