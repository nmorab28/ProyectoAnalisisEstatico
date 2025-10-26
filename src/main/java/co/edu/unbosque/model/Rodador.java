package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase Rodador representa a un tipo específico de ciclista llamado "Rodador".
 * Extiende de la clase Ciclista y hereda sus atributos y métodos.
 */
public class Rodador extends Ciclista implements Serializable {

    /**
     * Crea un nuevo objeto Rodador sin inicializar sus atributos.
     */
    public Rodador() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Crea un nuevo objeto Rodador con los atributos especificados.
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
    public Rodador(String nombre, String id, String genero, String correo, String usuario, String contrasena,
            String tipo, int tiempoAC, int cadenciaPedaleo) {
        super(nombre, id, genero, correo, usuario, contrasena, tipo, tiempoAC, cadenciaPedaleo);
        // TODO Auto-generated constructor stub
    }

}
