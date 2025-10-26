package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.Optional;
/**
 * La interfaz RegistroDAO proporciona métodos para realizar operaciones CRUD
 * (crear, leer, actualizar, eliminar) en objetos de un tipo específico en un almacenamiento
 * persistente.
 *
 * @param <T> El tipo de objeto con el que trabaja la implementación de la interfaz.
 * @param <K> El tipo de identificador utilizado para buscar objetos en el almacenamiento persistente.
 */
public interface RegistroDAO<T, K> {

    /**
     * Crea un nuevo objeto en el almacenamiento persistente.
     *
     * @param entidad El objeto que se va a crear.
     * @throws IOException si ocurre un error durante la escritura en el almacenamiento persistente.
     */
    void crear(T entidad) throws IOException;

    /**
     * Elimina un objeto del almacenamiento persistente según su identificador.
     *
     * @param idEntidad El identificador del objeto que se va a eliminar.
     * @throws IOException si ocurre un error durante la eliminación en el almacenamiento persistente.
     */
    void eliminar(K idEntidad) throws IOException;

    /**
     * Actualiza la información de un objeto existente en el almacenamiento persistente.
     *
     * @param idEntidad           El identificador del objeto que se va a actualizar.
     * @param entidadActualizada  El objeto con la información actualizada.
     * @throws IOException si ocurre un error durante la actualización en el almacenamiento persistente.
     */
    void actualizar(K idEntidad, T entidadActualizada) throws IOException;

    /**
     * Consulta un objeto por su identificador en el almacenamiento persistente.
     *
     * @param idEntidad El identificador del objeto que se desea consultar.
     * @return Un objeto Optional que contiene el objeto encontrado o vacío si no se encuentra ningún objeto con el identificador especificado.
     */
    Optional<T> consultarPorId(K idEntidad);
}
