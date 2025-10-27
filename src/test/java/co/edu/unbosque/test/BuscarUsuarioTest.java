package co.edu.unbosque.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import co.edu.unbosque.controller.Controller;
import co.edu.unbosque.view.*;

class BuscarUsuarioTest {

    @Test
    void testBuscarUsuario() {
        // Mocks
        VentanaPrincipal mockVp = mock(VentanaPrincipal.class);
        VentanaAutenticacion mockVa = mock(VentanaAutenticacion.class);
        PanelInformacion mockPi = mock(PanelInformacion.class);

        // Simular cadena de llamadas
        when(mockVp.getVentanaAutenticacion()).thenReturn(mockVa);
        when(mockVa.getPanelInfo()).thenReturn(mockPi);
        when(mockPi.getTxtId()).thenReturn("efectoMariposa");
        when(mockPi.getTxtContrasena()).thenReturn("mariposones2024");

        // Crear controlador con mock
        Controller controller = new Controller(mockVp);

        // Ejecutar prueba
        assertDoesNotThrow(() -> controller.buscarUsuario());
    }
}