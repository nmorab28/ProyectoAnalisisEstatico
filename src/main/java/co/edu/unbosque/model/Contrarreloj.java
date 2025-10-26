package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase Contrarreloj representa un tipo de ciclista especializado en pruebas
 * contrarreloj. Hereda de la clase Ciclista y agrega el atributo de velocidad máxima.
 */
public class Contrarreloj extends Ciclista implements Serializable {
    private double velocidadMax; // Velocidad máxima del ciclista contrarreloj

    /**
     * Constructor por defecto de la clase Contrarreloj.
     */
    public Contrarreloj() {
        // Llamada al constructor de la superclase Ciclista
        super();
    }

    /**
     * Constructor parametrizado de la clase Contrarreloj.
     * 
     * @param nombre          El nombre del ciclista.
     * @param id              El identificador del ciclista.
     * @param genero          El género del ciclista.
     * @param correo          El correo electrónico del ciclista.
     * @param usuario         El nombre de usuario del ciclista.
     * @param contrasena      La contraseña del ciclista.
     * @param tipo            El tipo de ciclista (por ejemplo, profesional o amateur).
     * @param tiempoAC        El tiempo acumulado en carrera del ciclista.
     * @param cadenciaPedaleo La cadencia de pedaleo del ciclista.
     * @param velocidadMax    La velocidad máxima del ciclista contrarreloj.
     */
    public Contrarreloj(String nombre, String id, String genero, String correo, String usuario, String contrasena,
            String tipo, int tiempoAC, int cadenciaPedaleo, double velocidadMax) {
        // Llamada al constructor de la superclase Ciclista
        super(nombre, id, genero, correo, usuario, contrasena, tipo, tiempoAC, cadenciaPedaleo);
        this.velocidadMax = velocidadMax;
    }

    /**
     * Obtiene la velocidad máxima del ciclista contrarreloj.
     * 
     * @return La velocidad máxima del ciclista contrarreloj.
     */
    public double getVelocidadMax() {
        return velocidadMax;
    }

    /**
     * Establece la velocidad máxima del ciclista contrarreloj.
     * 
     * @param velocidadMax La nueva velocidad máxima del ciclista contrarreloj.
     */
    public void setVelocidadMax(double velocidadMax) {
        this.velocidadMax = velocidadMax;
    }

}
