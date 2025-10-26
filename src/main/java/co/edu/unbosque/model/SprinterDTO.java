package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase SprinterDTO representa a un objeto de transferencia de datos (DTO) para un sprinter.
 * Extiende de la clase Ciclista y hereda sus atributos y métodos.
 * Es utilizada para transferir datos relacionados con un sprinter entre diferentes componentes del sistema.
 */
public class SprinterDTO extends Ciclista implements Serializable {

    /**
     * Crea un nuevo objeto SprinterDTO sin inicializar sus atributos.
     */
    public SprinterDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Crea un nuevo objeto SprinterDTO con los atributos especificados.
     * 
     * @param nombre El nombre del sprinter.
     * @param id El ID del sprinter.
     * @param genero El género del sprinter.
     * @param correo El correo electrónico del sprinter.
     * @param usuario El nombre de usuario del sprinter.
     * @param contrasena La contraseña del sprinter.
     * @param tipo El tipo de ciclista (en este caso, "Sprinter").
     * @param tiempoAC El tiempo acumulado en carrera del sprinter.
     * @param cadenciaPedaleo La cadencia de pedaleo del sprinter.
     */
    public SprinterDTO(String nombre, String id, String genero, String correo, String usuario, String contrasena,
            String tipo, int tiempoAC, int cadenciaPedaleo) {
        super(nombre, id, genero, correo, usuario, contrasena, tipo, tiempoAC, cadenciaPedaleo);
        // TODO Auto-generated constructor stub
    }
}
