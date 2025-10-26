package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class VentanaEmergente {
	 public static void mostrarMensaje(String msj) {
	        JOptionPane.showMessageDialog(null, msj, "Mensaje del sistema", JOptionPane.INFORMATION_MESSAGE);
	    }
	 public static void mostrarMensajeError(String msj) {
	        JOptionPane.showMessageDialog(null, msj, "Error en el aplicativo", JOptionPane.ERROR_MESSAGE);
	    }
}
