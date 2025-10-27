package co.edu.unbosque.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.table.DefaultTableModel;

import org.junit.jupiter.api.Test;

import co.edu.unbosque.controller.Controller;
import co.edu.unbosque.model.Ciclista;

class ObtenerCiclistasSeleccionadoTest {

    @Test
    void testObtenerCiclistaSeleccionado() {
        Controller controller = new Controller();

        DefaultTableModel modeloTabla = new DefaultTableModel(
                new Object[][] {
                        {"Nombre1", "ID1", "Tipo1", "Genero1", "Correo1", "Usuario1"}
                },
                new String[] {"Nombre", "ID", "Tipo", "Genero", "Correo", "Usuario"}
        );

        int filaSeleccionada = 0;
        Ciclista ciclista = controller.obtenerCiclistaSeleccionado(filaSeleccionada, modeloTabla);

        assertNotNull(ciclista);
        assertEquals("Nombre1", ciclista.getNombre());
        assertEquals("ID1", ciclista.getId());
        assertEquals("Tipo1", ciclista.getTipo());
        assertEquals("Genero1", ciclista.getGenero());
        assertEquals("Correo1", ciclista.getCorreo());
        assertEquals("Usuario1", ciclista.getUsuario());
    }
}