package co.edu.unbosque.model.persistence;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Optional;
import co.edu.unbosque.model.Director;

/**
 * La clase DirectorDAO proporciona métodos para realizar operaciones CRUD
 * (Crear, Leer, Actualizar, Eliminar) en un archivo binario que almacena objetos de tipo Director.
 */
public class DirectorDAO implements RegistroDAO<Director, String> {
    private static final String ARCHIVO_DIRECTORES = "Directores.dat";
    private ArrayList<Director> listaDirectores;

    /**
     * Crea un nuevo registro para un Director en el archivo binario.
     * 
     * @param di El Director a ser creado.
     * @throws IOException Si ocurre un error de entrada/salida al escribir en el archivo.
     */
    @Override
    public void crear(Director di) throws IOException {
        FileManager fm = new FileManager();
        // Leer los directores existentes del archivo
        ArrayList<Director> directores = fm.leerDirectores("Directores.dat");
        // Agregar el nuevo director a la lista
        directores.add(di);
        // Escribir todos los directores (incluyendo el nuevo) de nuevo en el archivo
        fm.escribirDirectorBinario("Directores.dat", directores);
    }

    /**
     * Actualiza la información de un Director en el archivo binario.
     * 
     * @param entidad El ID del Director a ser actualizado.
     * @param entidadActualizada El objeto Director actualizado.
     * @throws IOException Si ocurre un error de entrada/salida al escribir en el archivo.
     */
    @Override
    public void actualizar(String entidad, Director entidadActualizada) throws IOException {
        for (Director d : listaDirectores) {
            if (d.getId().equals(entidad)) {
                d.setExperiencia(entidadActualizada.getExperiencia());
                break;
            }
        }
    }

    /**
     * Elimina un registro de Director del archivo binario.
     * 
     * @param id El ID del Director a ser eliminado.
     */
    public void eliminar(String id) {
        FileManager fm = new FileManager();
        try (RandomAccessFile file = new RandomAccessFile(ARCHIVO_DIRECTORES, "rw")) {
            boolean encontrado = false;
            listaDirectores = fm.leerDirectores("Directores.dat"); // Actualizar la lista de directores

            while (file.getFilePointer() < file.length()) {
                long currentPosition = file.getFilePointer();
                
                // Lee el ID del director en la posición actual
                String currentId = file.readUTF();
                
                // Compara el ID leído con el ID proporcionado
                if (currentId.equals(id)) {
                    encontrado = true;
                    // Establece el puntero en la posición actual para sobrescribir el registro eliminado
                    file.seek(currentPosition);
                    // Sobrescribe el registro con valores nulos
                    file.writeUTF(""); // ID
                    file.writeUTF(""); // Nombre
                    break;
                } else {
                    // Si el ID no coincide, salta los datos restantes del registro
                    file.readUTF(); // Nombre
                    file.readInt(); // Edad
                }
            }
            
            if (!encontrado) {
                System.out.println("Director no encontrado.");
            }
        } catch (IOException e) {
            System.out.println("Error al intentar eliminar el director.");
            e.printStackTrace();
        }
    }


    /**
     * Consulta un Director por su ID.
     * 
     * @param idEntidad El ID del Director a ser consultado.
     * @return Un objeto Optional que puede contener el Director si se encuentra, o un valor vacío si no se encuentra.
     */
    @Override
    public Optional<Director> consultarPorId(String idEntidad) {
        return listaDirectores.stream().filter(director -> director.getId().equals(idEntidad)).findFirst();
    }
}
