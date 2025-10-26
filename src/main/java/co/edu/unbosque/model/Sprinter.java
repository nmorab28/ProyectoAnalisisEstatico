package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase Sprinter representa a un ciclista de tipo sprinter.
 * Extiende de la clase Ciclista y hereda sus atributos y métodos.
 * Es utilizada para modelar a un ciclista especializado en sprints.
 */
public class Sprinter extends Ciclista implements Serializable {
	
    /**
     * Crea un nuevo objeto Sprinter sin inicializar sus atributos.
     */
    public Sprinter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Crea un nuevo objeto Sprinter con los atributos especificados.
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
    public Sprinter(String nombre, String id, String genero, String correo, String usuario, String contrasena,
            String tipo, int tiempoAC, int cadenciaPedaleo) {
        super(nombre, id, genero, correo, usuario, contrasena, tipo, tiempoAC, cadenciaPedaleo);
        // TODO Auto-generated constructor stub
    }
}
