package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase Gregario representa un tipo específico de ciclista que trabaja para el beneficio de su equipo.
 * El término "gregario" se refiere a un ciclista que sacrifica su propio éxito personal en favor del éxito del equipo.
 * La clase Gregario extiende de la clase Ciclista y proporciona funcionalidad específica para este tipo de ciclista.
 */
public class Gregario extends Ciclista implements Serializable {
    
    /**
     * Crea un nuevo objeto Gregario sin inicializar sus atributos.
     */
    public Gregario() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Crea un nuevo objeto Gregario con los atributos especificados.
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
    public Gregario(String nombre, String id, String genero, String correo, String usuario, String contrasena,
            String tipo, int tiempoAC, int cadenciaPedaleo) {
        super(nombre, id, genero, correo, usuario, contrasena, tipo, tiempoAC, cadenciaPedaleo);
    }
}
