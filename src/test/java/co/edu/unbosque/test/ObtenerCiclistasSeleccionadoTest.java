package co.edu.unbosque.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.jupiter.api.Test;

import co.edu.unbosque.controller.Controller;

class ObtenerCiclistasSeleccionadoTest {

	@Test
	void testObtenerCiclistaSeleccionado() {
        Controller controller = new Controller();
        JTable tabla = new JTable(); // Tabla de prueba
        // Crear el modelo de datos para la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel(
            new Object[][] {
                {"Nombre1", "ID1", "Tipo1", "Genero1", "Correo1", "Usuario1", "Experiencia1"}
            },
            new String[] {"Nombre", "ID", "Tipo", "Genero", "Correo", "Usuario", "Experiencia"}
        );
        tabla.setModel(modeloTabla); // Establecer el modelo de datos en la tabla
        // Indicar la fila seleccionada para la prueba
        int filaSeleccionada = 0; // Fila seleccionada para la prueba
        assertNotNull(controller.obtenerCiclistaSeleccionado(filaSeleccionada, tabla));
    }
}
