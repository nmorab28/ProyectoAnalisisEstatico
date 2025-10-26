package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import co.edu.unbosque.model.Escuadra;

/**
 * La clase EscuadraDAO proporciona métodos para realizar operaciones CRUD
 * (Crear, Leer, Actualizar, Eliminar) en un archivo binario que almacena objetos de tipo Escuadra.
 */
public class EscuadraDAO implements RegistroDAO<Escuadra, String> {
    private ArrayList<Escuadra> listaEscuadras;

    /**
     * Crea un nuevo registro para una Escuadra en el archivo binario.
     * 
     * @param esc La Escuadra a ser creada.
     * @throws IOException Si ocurre un error de entrada/salida al escribir en el archivo.
     */
    @Override
    public void crear(Escuadra esc) throws IOException {
        FileManager fm = new FileManager();
        // Leer las escuadras existentes del archivo
        ArrayList<Escuadra> escuadras = fm.leerEscuadras("Escuadras.dat");
        // Agregar el nuevo escuadra a la lista
        escuadras.add(esc);
        // Escribir todos las escuadras (incluyendo el nuevo) de nuevo en el archivo
        fm.escribirEscuadrasBinario("Escuadras.dat", escuadras);
    }

    /**
     * Actualiza la información de una Escuadra en el archivo binario.
     * 
     * @param entidad El nombre de la Escuadra a ser actualizada.
     * @param entidadActualizada El objeto Escuadra actualizado.
     * @throws IOException Si ocurre un error de entrada/salida al escribir en el archivo.
     */
    @Override
    public void actualizar(String entidad, Escuadra entidadActualizada) throws IOException {
        for (Escuadra e : listaEscuadras) {
            if (e.getNombre().equals(entidad)) {
                e.setMiembros(null);
                break;
            }
        }
    }

    /**
     * Elimina una Escuadra del archivo binario.
     * 
     * @param idEntidad El nombre de la Escuadra a ser eliminada.
     */
    @Override
    public void eliminar(String idEntidad) {
        for (Escuadra e : listaEscuadras) {
            if (e.getNombre().equals(idEntidad)) {
                listaEscuadras.remove(e);
                break;
            }
        }
    }

    /**
     * Consulta una Escuadra por su nombre.
     * 
     * @param idEntidad El nombre de la Escuadra a ser consultada.
     * @return Un objeto Optional que puede contener la Escuadra si se encuentra, o un valor vacío si no se encuentra.
     */
    @Override
    public Optional<Escuadra> consultarPorId(String idEntidad) {
        return listaEscuadras.stream().filter(escuadra -> escuadra.getNombre().equals(idEntidad)).findFirst();
    }
}
