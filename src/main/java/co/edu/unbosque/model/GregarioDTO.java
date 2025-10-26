package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase GregarioDTO representa un Data Transfer Object (DTO) para transferir información de gregarios entre capas de la aplicación.
 * Se utiliza para encapsular los datos de un gregario y enviarlos a través de la red o almacenarlos en archivos de forma serializada.
 * La clase GregarioDTO extiende de la clase Ciclista y proporciona funcionalidad específica para este tipo de objeto de transferencia de datos.
 */
public class GregarioDTO extends Ciclista implements Serializable  {

    /**
     * Crea un nuevo objeto GregarioDTO sin inicializar sus atributos.
     */
    public GregarioDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Crea un nuevo objeto GregarioDTO con los atributos especificados.
     * 
     * @param nombre El nombre del gregario.
     * @param id El ID del gregario.
     * @param genero El género del gregario.
     * @param correo El correo electrónico del gregario.
     * @param usuario El nombre de usuario del gregario.
     * @param contrasena La contraseña del gregario.
     * @param tipo El tipo de ciclista (en este caso, "gregario").
     * @param tiempoAC El tiempo acumulado en carrera del gregario.
     * @param cadenciaPedaleo La cadencia de pedaleo del gregario.
     */
    public GregarioDTO(String nombre, String id, String genero, String correo, String usuario, String contrasena,
            String tipo, int tiempoAC, int cadenciaPedaleo) {
        super(nombre, id, genero, correo, usuario, contrasena, tipo, tiempoAC, cadenciaPedaleo);
    }
}
