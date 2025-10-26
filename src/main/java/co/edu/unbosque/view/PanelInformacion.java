package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PanelInformacion extends JPanel {
	private JTextField txtId;
	private JPasswordField txtContrasena;
	private JButton back, btnRegistrar;
	private JLabel fondoVentana;

	public PanelInformacion(ActionListener listener) {
		setLayout(null);

		txtId = new JTextField();
		txtId.setBorder(BorderFactory.createEmptyBorder());
		txtId.setOpaque(false);
		txtId.setBackground(new Color(0, 0, 0, 0));
		txtId.setForeground(Color.BLACK);
		txtId.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		txtId.setBounds(525, 195, 280, 43);

        txtContrasena = new JPasswordField();
        txtContrasena.setBorder(BorderFactory.createEmptyBorder());
        txtContrasena.setOpaque(false);
		txtContrasena.setForeground(Color.BLACK);
		txtContrasena.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		txtContrasena.setBounds(525, 350, 280, 43);

		back = new JButton();
		ImageIcon casa = new ImageIcon("Imagenes/home.png");
		back.setBounds(890, 43, 35, 35);
		back.setContentAreaFilled(false);
		back.setBorder(null);
		back.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back.setIcon(new ImageIcon(
				casa.getImage().getScaledInstance(back.getWidth(), back.getHeight(), Image.SCALE_SMOOTH)));
		back.setActionCommand("BOTON_BACK");
		back.addActionListener(listener);

		btnRegistrar = new JButton();
		ImageIcon flechita = new ImageIcon("Imagenes/RegisAuth.png");
		btnRegistrar.setBounds(720, 490, 78, 75);
		btnRegistrar.setContentAreaFilled(false);
		btnRegistrar.setBorder(null);
		btnRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRegistrar.setIcon(new ImageIcon(flechita.getImage().getScaledInstance(btnRegistrar.getWidth(),
				btnRegistrar.getHeight(), Image.SCALE_SMOOTH)));
		btnRegistrar.setActionCommand("BOTON_REGISTRAR_AUTH");
		btnRegistrar.addActionListener(listener);

//		 btnMostrarContrasena = new JToggleButton("Mostrar");
//	        btnMostrarContrasena.setBounds(810, 350, 100, 30);
//	        btnMostrarContrasena.addItemListener(new ItemListener() {
//	            public void itemStateChanged(ItemEvent e) {
//	                if (e.getStateChange() == ItemEvent.SELECTED) {
//	                    // Mostrar contraseña
//	                    txtContrasena.setEchoChar((char) 0);
//	                } else {
//	                    // Ocultar contraseña
//	                    txtContrasena.setEchoChar('\u2022'); // Carácter de viñeta para ocultar
//	                }
//	            }
//	        });

		fondoVentana = new JLabel();
		fondoVentana.setSize(1000, 650);
		ImageIcon icono = new ImageIcon("Imagenes/Login.png");
		Image imagen = icono.getImage();
		imagen = imagen.getScaledInstance(fondoVentana.getWidth(), fondoVentana.getHeight(), Image.SCALE_SMOOTH);
		fondoVentana.setIcon(new ImageIcon(imagen));

		add(back);
		add(txtId);
		add(txtContrasena);
		add(btnRegistrar);
		add(fondoVentana);

	}

	public String getTxtId() {
		return txtId.getText();
	}

	public String getTxtContrasena() {
	    // Obtener el arreglo de caracteres de la contraseña
	    char[] contrasenaChars = txtContrasena.getPassword();
	    
	    // Convertir el arreglo de caracteres a una cadena de texto
	    String txtContrasena = new String(contrasenaChars);
	    
	    return txtContrasena;
	}

}
