package co.edu.unbosque.view;

import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class VentanaAutenticacion extends JFrame{
	private PanelInformacion panelInfo;
	private ActionListener listener;
	
	public VentanaAutenticacion(ActionListener listener) {
		this.listener = listener;
		setSize(1000, 650);
		setTitle("ISUCI - EfectoMariposa");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		initComponents();
		setLocationRelativeTo(null); // Centra la ventana en la pantalla
		setVisible(true);
	}

	private void initComponents() {
		panelInfo = new PanelInformacion(listener);
		add(panelInfo);	
	}
	public PanelInformacion getPanelInfo() {
		return panelInfo;
	}

}
