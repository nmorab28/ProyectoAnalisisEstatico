package co.edu.unbosque.view;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class VentanaMontana extends JFrame {
	private PanelMontana panelMon;
	private ActionListener listener;

	public VentanaMontana(ActionListener listener) {
		this.listener = listener;
		setSize(1000, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		initComponents();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initComponents() {
		panelMon = new PanelMontana(listener);
		add(panelMon);

	}

	public PanelMontana getPanelMontana() {
		return panelMon;
	}

}
