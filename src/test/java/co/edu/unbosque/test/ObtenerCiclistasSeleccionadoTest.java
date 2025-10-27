package co.edu.unbosque.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import javax.swing.table.TableModel;

import org.junit.jupiter.api.Test;

import co.edu.unbosque.controller.Controller;
import co.edu.unbosque.model.Ciclista;

class ObtenerCiclistasSeleccionadoTest {

    @Test
    void testObtenerCiclistaSeleccionadoConMock() {
        Controller controller = new Controller();

        TableModel modeloMock = mock(TableModel.class);
        when(modeloMock.getRowCount()).thenReturn(1);
        when(modeloMock.getValueAt(0, 0)).thenReturn("Nombre1");
        when(modeloMock.getValueAt(0, 1)).thenReturn("ID1");
        when(modeloMock.getValueAt(0, 2)).thenReturn("Tipo1");
        when(modeloMock.getValueAt(0, 3)).thenReturn("Genero1");
        when(modeloMock.getValueAt(0, 4)).thenReturn("Correo1");
        when(modeloMock.getValueAt(0, 5)).thenReturn("Usuario1");

        Ciclista ciclista = controller.obtenerCiclistaSeleccionado(0, modeloMock);

        assertNotNull(ciclista);
        assertEquals("Nombre1", ciclista.getNombre());
    }
}