package co.edu.unbosque.view;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.unbosque.model.Ciclista;
import co.edu.unbosque.model.Masajista;

public class PanelMostrarInfo  extends JPanel{
	private JButton btnSalir;
	private JTextField txtNombre, txtId, txtGenero, txtCorreo,txtTipo, txtUsuario;
	private JLabel fondoVentana;
	private JComboBox<String>escuadras;
	
	public PanelMostrarInfo(ActionListener listener) {
		setLayout(null);
	
		
		txtNombre = new JTextField();
        txtNombre.setBounds(310, 230, 200, 30);
        add(txtNombre);

        txtId = new JTextField();
        txtId.setBounds(670, 230, 180, 30);
        add(txtId);

        txtGenero = new JTextField();
        txtGenero.setBounds(310, 385, 200, 30);
        add(txtGenero);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(310, 310, 200, 30);
        add(txtCorreo);

        txtTipo = new JTextField();
        txtTipo.setBounds(670, 310, 180, 30);
        add(txtTipo);
        
        txtUsuario = new JTextField();
        txtUsuario.setBounds(310, 460, 200, 30);
        add(txtUsuario);
        
        escuadras = new JComboBox<>();
        escuadras.setBounds(670, 380, 180, 30); 
		add(escuadras);
 
		btnSalir = new JButton();
		ImageIcon botonSalir = new ImageIcon("Imagenes/exit.png");
		btnSalir.addActionListener(listener);
		btnSalir.setBounds(880, 40, 75,65);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorder(null);
		btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSalir.setIcon(new ImageIcon(botonSalir.getImage().getScaledInstance(btnSalir.getWidth(), btnSalir.getHeight(), Image.SCALE_SMOOTH)));
		btnSalir.setActionCommand("BOTON_EXIT");
		
		fondoVentana = new JLabel();
		fondoVentana.setSize(1000, 650);
		fondoVentana.setIcon(new ImageIcon("Imagenes/infoUsuarios.png"));

		add(btnSalir);
		add(fondoVentana);		
	}
	
	public void mostrarCiclista(Ciclista ciclista) {
        txtNombre.setText(ciclista.getNombre());
        txtId.setText(ciclista.getId());
        txtGenero.setText(ciclista.getGenero());
        txtCorreo.setText(ciclista.getCorreo());
        txtTipo.setText(ciclista.getTipo());
        txtUsuario.setText(ciclista.getUsuario());
    }
	public void mostrarMasajista(Masajista masajista) {
        txtNombre.setText(masajista.getNombre());
        txtId.setText(masajista.getId());
        txtGenero.setText(masajista.getGenero());
        txtCorreo.setText(masajista.getCorreo());
        txtTipo.setText("Masajista");
        txtUsuario.setText(masajista.getUsuario());
    }
	
	 public void addEscuadra(String escuadraBox) {
	        escuadras.addItem(escuadraBox);
	    }

	    public JComboBox<String> getEscuadrasComboBox() {
	        return escuadras;
	    }
}