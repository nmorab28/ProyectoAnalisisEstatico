package co.edu.unbosque.test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import co.edu.unbosque.view.PanelInformacion;
import co.edu.unbosque.view.VentanaAutenticacion;
import co.edu.unbosque.view.VentanaPrincipal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.controller.Controller;

class ValidarEmailTets {

	private Controller controller;

    @BeforeEach
    public void setUp() {
        controller = new Controller();
    }

    @Test
    void testBuscarUsuario() {
        VentanaPrincipal mockVp = mock(VentanaPrincipal.class);
        VentanaAutenticacion mockVa = mock(VentanaAutenticacion.class);
        PanelInformacion mockPi = mock(PanelInformacion.class);

        when(mockVp.getVentanaAutenticacion()).thenReturn(mockVa);
        when(mockVa.getPanelInfo()).thenReturn(mockPi);
        when(mockPi.getTxtId()).thenReturn("efectoMariposa");
        when(mockPi.getTxtContrasena()).thenReturn("mariposones2024");

        Controller controller = new Controller(mockVp);
        assertDoesNotThrow(() -> controller.buscarUsuario());
    }
}

