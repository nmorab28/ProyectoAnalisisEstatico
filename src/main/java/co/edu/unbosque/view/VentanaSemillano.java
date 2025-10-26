package co.edu.unbosque.view;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class VentanaSemillano extends JFrame{
	private PanelSemillano panelSemi;
	private ActionListener listener;
	
	public VentanaSemillano(ActionListener listener) {
		this.listener = listener;
		setSize(1000, 650);
		setTitle("Simulacion Semi-Llano");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		initProgram();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initProgram() {
		panelSemi = new PanelSemillano(listener);
		add(panelSemi);
		
	}

	public PanelSemillano getPanelSemillano() {
		// TODO Auto-generated method stub
		return panelSemi;
	}

}
