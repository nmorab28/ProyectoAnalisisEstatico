package co.edu.unbosque.model.persistence;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.Ciclista;

class CiclistaDAOTest {

    @Test
    void testCrearCiclista() {
        CiclistaDAO dao = new CiclistaDAO();
        Ciclista ciclista = new Ciclista("Test Nombre", "999", "Masculino", "test@correo.com", "testUser", "clave123", "Ciclista", 85, 120);

        assertDoesNotThrow(() -> {
            dao.crear(ciclista);
        });

        // Verificar que el ciclista fue agregado
        FileManager fm = new FileManager();
        ArrayList<Ciclista> ciclistas = fm.leerCiclistas("Ciclistas.dat");

        boolean encontrado = ciclistas.stream()
                .anyMatch(c -> c.getId().equals("999") && c.getUsuario().equals("testUser"));

        assertTrue(encontrado, "El ciclista debería estar en el archivo");
    }
}