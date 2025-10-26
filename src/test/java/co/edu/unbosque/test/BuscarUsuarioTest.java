package co.edu.unbosque.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import co.edu.unbosque.controller.Controller;

class BuscarUsuarioTest {

	@Test
    void testBuscarUsuario() {
        Controller controller = new Controller();
        String usuario = "efectoMariposa"; // Usuario de prueba
        String contrasena = "mariposones2024"; // Contraseña de prueba
        assertDoesNotThrow(() -> controller.buscarUsuario());
    }
}
