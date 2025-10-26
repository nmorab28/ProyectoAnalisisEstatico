package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.Usuario;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaUsuariosPdf extends JFrame {
	private PanelTabla panelTabla;
	private ActionListener listener;

    public VentanaUsuariosPdf(ActionListener listener) {
    	this.listener = listener;
        setTitle("Usuarios registrados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        initComponents();
    }

	private void initComponents() {
		panelTabla = new PanelTabla(listener);
		add(panelTabla);	
	}
	public PanelTabla getPanelTabla() {
		return panelTabla;
	}
}

