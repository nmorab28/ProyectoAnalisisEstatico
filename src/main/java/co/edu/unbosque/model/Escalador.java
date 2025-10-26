package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase Escalador representa un ciclista especializado en escalar pendientes.
 * Hereda de la clase Ciclista y agrega los atributos aceleración promedio y grado de la rampa.
 */
public class Escalador extends Ciclista implements Serializable {
    private double aceleracionPromedio; // Aceleración promedio del escalador
    private double gradoRampa; // Grado de la rampa que el escalador puede ascender

    /**
     * Constructor por defecto de la clase Escalador.
     */
    public Escalador() {
        // Llamada al constructor de la superclase Ciclista
        super();
    }
    
    /**
     * Constructor parametrizado de la clase Escalador.
     * 
     * @param nombre               El nombre del escalador.
     * @param id                   El identificador del escalador.
     * @param genero               El género del escalador.
     * @param correo               El correo electrónico del escalador.
     * @param usuario              El nombre de usuario del escalador.
     * @param contrasena           La contraseña del escalador.
     * @param tipo                 El tipo de ciclista.
     * @param tiempoAC             El tiempo acumulado en carrera del escalador.
     * @param cadenciaPedaleo      La cadencia de pedaleo del escalador.
     * @param aceleracionPromedio  La aceleración promedio del escalador.
     * @param gradoRampa           El grado de la rampa que el escalador puede ascender.
     */
    public Escalador(String nombre, String id, String genero, String correo, String usuario, String contrasena,
            String tipo, int tiempoAC, int cadenciaPedaleo, double aceleracionPromedio, double gradoRampa) {
        // Llamada al constructor de la superclase Ciclista
        super(nombre, id, genero, correo, usuario, contrasena, tipo, tiempoAC, cadenciaPedaleo);
        this.aceleracionPromedio = aceleracionPromedio;
        this.gradoRampa = gradoRampa;
    }

    /**
     * Obtiene la aceleración promedio del escalador.
     * 
     * @return La aceleración promedio del escalador.
     */
    public double getAceleracionPromedio() {
        return aceleracionPromedio;
    }

    /**
     * Establece la aceleración promedio del escalador.
     * 
     * @param aceleracionPromedio La nueva aceleración promedio del escalador.
     */
    public void setAceleracionPromedio(double aceleracionPromedio) {
        this.aceleracionPromedio = aceleracionPromedio;
    }

    /**
     * Obtiene el grado de la rampa que el escalador puede ascender.
     * 
     * @return El grado de la rampa que el escalador puede ascender.
     */
    public double getGradoRampa() {
        return gradoRampa;
    }

    /**
     * Establece el grado de la rampa que el escalador puede ascender.
     * 
     * @param gradoRampa El nuevo grado de la rampa que el escalador puede ascender.
     */
    public void setGradoRampa(double gradoRampa) {
        this.gradoRampa = gradoRampa;
    }

}
