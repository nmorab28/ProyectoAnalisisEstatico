package co.edu.unbosque.test;

import static org.junit.jupiter.api.Assertions.*;

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
    public void testValidarEmail() {
        assertTrue(controller.validarEmail("correoQueSirve@gmail.com"));
        assertFalse(controller.validarEmail("correo-queno-sirve-email"));
    }
}

