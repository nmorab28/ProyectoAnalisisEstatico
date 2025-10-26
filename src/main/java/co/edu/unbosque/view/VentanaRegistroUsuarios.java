package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


public class VentanaRegistroUsuarios extends JFrame {
	private PanelRegistro panelRegistro;
	private ActionListener listener;

	public VentanaRegistroUsuarios(ActionListener listener) {
		this.listener = listener; // Asigna el ActionListener recibido al campo de clase
		setSize(1010, 680);
		setTitle("Cosito proyecto");
		setLayout(new BorderLayout()); // Usamos BorderLayout para organizar los componentes
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
		setLocationRelativeTo(null); // Centra la ventana en la pantalla
		setVisible(true);

	}

	private void initComponents() {
		panelRegistro = new PanelRegistro(listener);
		add(panelRegistro);
	}

	public PanelRegistro getPanelRegistro() {
		return this.panelRegistro;
	}
}