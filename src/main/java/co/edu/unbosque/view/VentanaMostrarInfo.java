package co.edu.unbosque.view;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import co.edu.unbosque.model.Ciclista;
import co.edu.unbosque.model.Masajista;

public class VentanaMostrarInfo extends JFrame {
	
	private PanelMostrarInfo mostrarInfo;
	private ActionListener listener;
	
	public VentanaMostrarInfo(ActionListener listener) {
		this.listener = listener;
		setSize(1000, 650);
		setTitle("Mi información");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		ejecutar();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void ejecutar() {
		mostrarInfo = new PanelMostrarInfo(listener);
		add(mostrarInfo);
	}
	public PanelMostrarInfo getPanelMostrarInfo() {
		return mostrarInfo;
	}
	public void mostrarCiclista(Ciclista ciclista) {
        mostrarInfo.mostrarCiclista(ciclista);
    }

    public void mostrarMasajista(Masajista masajista) {
        mostrarInfo.mostrarMasajista(masajista);
    }

	public void agregarUsuario(String nombre, String id) {
		// TODO Auto-generated method stub	
	}

}