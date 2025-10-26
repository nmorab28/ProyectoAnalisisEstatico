package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Optional;

import co.edu.unbosque.model.Ciclista;

/**
 * La clase CiclistaDAO proporciona métodos para acceder y manipular datos de ciclistas
 * almacenados en un archivo binario.
 */
public class CiclistaDAO implements RegistroDAO<Ciclista, String> {
    private static final String ARCHIVO_CICLISTAS = "Ciclistas.dat";
    private ArrayList<Ciclista> listaCiclistas;

    /**
     * Crea un nuevo ciclista en el archivo binario.
     * 
     * @param c El ciclista a crear.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    @Override
    public void crear(Ciclista c) throws IOException {
        FileManager fm = new FileManager();
        // Leer los ciclistas existentes del archivo
        ArrayList<Ciclista> ciclistas = fm.leerCiclistas("Ciclistas.dat");
        // Agregar el nuevo ciclista a la lista
        ciclistas.add(c);
        // Escribir todos los ciclistas (incluyendo el nuevo) nuevamente en el archivo
        fm.escribirCiclistaBinario("Ciclistas.dat", ciclistas);
    }

    /**
     * Actualiza la información de un ciclista en el archivo binario.
     * 
     * @param entidad El identificador del ciclista a actualizar.
     * @param entidadActualizada La información actualizada del ciclista.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    @Override
    public void actualizar(String entidad, Ciclista entidadActualizada) throws IOException {
        for (Ciclista c : listaCiclistas) {
            if (c.getId().equals(entidad)) {
                c.setTiempoAC(entidadActualizada.getTiempoAC());
                break;
            }
        }
    }

    /**
     * Elimina un ciclista del archivo binario.
     * 
     * @param id El identificador del ciclista a eliminar.
     */
    public void eliminar(String id) {
        try {
            // Abre un flujo de lectura y escritura para el archivo binario
            RandomAccessFile file = new RandomAccessFile(ARCHIVO_CICLISTAS, "rw");
            boolean encontrado = false;

            while (file.getFilePointer() < file.length()) {
                long currentPosition = file.getFilePointer();

                // Lee el ID del ciclista en la posición actual
                String currentId = file.readUTF();

                // Compara el ID leído con el ID proporcionado
                if (currentId.equals(id)) {
                    encontrado = true;
                    // Establece el puntero en la posición actual para sobrescribir el registro eliminado
                    file.seek(currentPosition);
                    // Sobrescribe el ID con un valor nulo para indicar que el registro ha sido eliminado
                    file.writeUTF(""); // ID
                    file.writeUTF(""); // Nombre
                    file.writeUTF(""); // Edad (puedes establecerlo como 0 u otro valor predeterminado)
                    file.writeUTF("");
                    file.writeUTF("");
                    file.writeUTF("");
                    break;
                } else {
                    // Si el ID no coincide, salta los datos restantes del registro
                    file.readUTF(); // Nombre
                    file.readInt(); // Edad
                    // Aquí saltarías los demás datos que estén almacenados
                }
            }

            file.close();

            if (!encontrado) {
                System.out.println("Ciclista no encontrado.");
            }
        } catch (IOException e) {
            System.out.println("Error al intentar eliminar el ciclista.");
            e.printStackTrace();
        }
    }

    /**
     * Consulta un ciclista por su ID.
     * 
     * @param idEntidad El identificador del ciclista a consultar.
     * @return Un objeto Optional que contiene el ciclista si se encuentra, o un valor vacío si no se encuentra.
     */
    @Override
    public Optional<Ciclista> consultarPorId(String idEntidad) {
        return listaCiclistas.stream().filter(ciclista -> ciclista.getId().equals(idEntidad)).findFirst();
    }
}
