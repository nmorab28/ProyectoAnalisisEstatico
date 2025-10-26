package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase RodadorDTO es una versión de transferencia de datos (DTO) de un rodador.
 * Extiende de la clase Ciclista y hereda sus atributos y métodos.
 * Es utilizada para transferir datos relacionados con un rodador entre diferentes componentes del sistema.
 */
public class RodadorDTO extends Ciclista implements Serializable {

    /**
     * Crea un nuevo objeto RodadorDTO sin inicializar sus atributos.
     */
    public RodadorDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Crea un nuevo objeto RodadorDTO con los atributos especificados.
     * 
     * @param nombre El nombre del rodador.
     * @param id El ID del rodador.
     * @param genero El género del rodador.
     * @param correo El correo electrónico del rodador.
     * @param usuario El nombre de usuario del rodador.
     * @param contrasena La contraseña del rodador.
     * @param tipo El tipo de ciclista (en este caso, "Rodador").
     * @param tiempoAC El tiempo acumulado en carrera del rodador.
     * @param cadenciaPedaleo La cadencia de pedaleo del rodador.
     */
    public RodadorDTO(String nombre, String id, String genero, String correo, String usuario, String contrasena,
            String tipo, int tiempoAC, int cadenciaPedaleo) {
        super(nombre, id, genero, correo, usuario, contrasena, tipo, tiempoAC, cadenciaPedaleo);
        // TODO Auto-generated constructor stub
    }

}
