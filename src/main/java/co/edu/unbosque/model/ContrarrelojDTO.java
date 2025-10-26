package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase ContrarrelojDTO representa un objeto de transferencia de datos (DTO) para
 * un ciclista especializado en pruebas contrarreloj. Esta clase se utiliza para transferir
 * datos relacionados con el ciclista contrarreloj entre el cliente y el servidor.
 * Hereda de la clase Ciclista y agrega el atributo de velocidad máxima.
 */
public class ContrarrelojDTO extends Ciclista implements Serializable {
    private double velocidadMax; // Velocidad máxima del ciclista contrarreloj

    /**
     * Constructor por defecto de la clase ContrarrelojDTO.
     */
    public ContrarrelojDTO() {
        // Llamada al constructor de la superclase Ciclista
        super();
    }

    /**
     * Constructor parametrizado de la clase ContrarrelojDTO.
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
    public ContrarrelojDTO(String nombre, String id, String genero, String correo, String usuario, String contrasena,
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
