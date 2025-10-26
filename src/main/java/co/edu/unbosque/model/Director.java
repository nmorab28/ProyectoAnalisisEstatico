package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase Director representa un director en el sistema, que es un tipo de usuario.
 * Hereda de la clase Usuario y agrega el atributo experiencia.
 */
public class Director extends Usuario implements Serializable {
    private String experiencia; // Experiencia del director

    /**
     * Constructor por defecto de la clase Director.
     */
    public Director() {
        // Llamada al constructor de la superclase Usuario
        super();
    }
    
    /**
     * Constructor parametrizado de la clase Director.
     * 
     * @param nombre       El nombre del director.
     * @param id           El identificador del director.
     * @param genero       El género del director.
     * @param correo       El correo electrónico del director.
     * @param usuario      El nombre de usuario del director.
     * @param contrasena   La contraseña del director.
     * @param experiencia  La experiencia del director.
     */
    public Director(String nombre, String id, String genero, String correo, String usuario, String contrasena, String experiencia) {
        // Llamada al constructor de la superclase Usuario
        super(nombre, id, genero, correo, usuario, contrasena);
        this.experiencia = experiencia;
    }

    /**
     * Obtiene la experiencia del director.
     * 
     * @return La experiencia del director.
     */
    public String getExperiencia() {
        return experiencia;
    }

    /**
     * Establece la experiencia del director.
     * 
     * @param experiencia La nueva experiencia del director.
     */
    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }
}
