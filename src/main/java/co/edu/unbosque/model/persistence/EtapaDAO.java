package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import co.edu.unbosque.model.Etapa;

/**
 * La clase EtapaDAO proporciona métodos para realizar operaciones CRUD
 * (Crear, Leer, Actualizar, Eliminar) en un archivo binario que almacena objetos de tipo Etapa.
 */
public class EtapaDAO implements RegistroDAO<Etapa, String> {

    private ArrayList<Etapa> listaEtapas;

    /**
     * Crea un nuevo registro para una Etapa en el archivo binario.
     * 
     * @param et La Etapa a ser creada.
     * @throws IOException Si ocurre un error de entrada/salida al escribir en el archivo.
     */
    @Override
    public void crear(Etapa et) throws IOException {
        FileManager fm = new FileManager();
        // Leer las etapas existentes del archivo
        ArrayList<Etapa> etapas = fm.leerEtapas("Simulacion.dat");
        // Agregar la nueva etapa a la lista
        etapas.add(et);
        // Escribir todas las etapas (incluyendo la nueva) de nuevo en el archivo
        fm.escribirSimulacionBinario("Simulacion.dat", etapas);
    }

    /**
     * Actualiza la información de una Etapa en el archivo binario.
     * 
     * @param entidad El tiempo de la Etapa a ser actualizada.
     * @param entidadActualizada El objeto Etapa actualizado.
     * @throws IOException Si ocurre un error de entrada/salida al escribir en el archivo.
     */
    @Override
    public void actualizar(String entidad, Etapa entidadActualizada) throws IOException {
        for (Etapa e : listaEtapas) {
            if (e.getTiempo().equals(entidad)) {
                e.setDistancia(entidadActualizada.getDistancia());
                break;
            }
        }   
    }

    /**
     * Elimina una Etapa del archivo binario.
     * 
     * @param idEntidad El tiempo de la Etapa a ser eliminada.
     */
    @Override
    public void eliminar(String idEntidad) {
        for (Etapa e : listaEtapas) {
            if (e.getTiempo().equals(idEntidad)) {
                listaEtapas.remove(e);
                break;
            }
        }
    }

    /**
     * Consulta una Etapa por su tiempo.
     * 
     * @param idEntidad El tiempo de la Etapa a ser consultada.
     * @return Un objeto Optional que puede contener la Etapa si se encuentra, o un valor vacío si no se encuentra.
     */
    @Override
    public Optional<Etapa> consultarPorId(String idEntidad) {
        return listaEtapas.stream().filter(etapa -> etapa.getTiempo().equals(idEntidad)).findFirst();
    }
}
