package co.edu.unbosque.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import co.edu.unbosque.controller.Controller;

class BuscarUsuarioExistente {
	
	@Test
	void testBuscarUsuario_UsuarioExistente() {
        Controller ventanaPrincipal = new Controller();
        try {
            assertDoesNotThrow(() -> ventanaPrincipal.buscarUsuario());
        } catch (Exception e) {
            fail("Se lanzó una excepción: " + e.getMessage());
        }
    }
}
