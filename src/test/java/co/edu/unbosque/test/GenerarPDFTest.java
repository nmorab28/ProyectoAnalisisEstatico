package co.edu.unbosque.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import co.edu.unbosque.controller.Controller;
import co.edu.unbosque.model.Ciclista;

class GenerarPDFTest {

    @Test
    void testGenerarPDF() {
        Controller c = new Controller();
        Ciclista ciclista = new Ciclista("John Doe", "123", "Male", "john@example.com", "johndoe", "", "Ciclista", 80, 0);
        assertDoesNotThrow(() -> c.generarPDF(ciclista));
    }
}