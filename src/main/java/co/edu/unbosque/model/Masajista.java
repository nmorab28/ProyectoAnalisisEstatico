package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase Masajista representa a un usuario del sistema que también es un masajista.
 * Extiende de la clase Usuario y agrega un atributo específico para almacenar la experiencia del masajista.
 */
public class Masajista extends Usuario implements Serializable {
    private String experiencia;

    /**
     * Crea un nuevo objeto Masajista sin inicializar sus atributos.
     */
    public Masajista() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Crea un nuevo objeto Masajista con los atributos especificados.
     * 
     * @param nombre El nombre del masajista.
     * @param id El ID del masajista.
     * @param genero El género del masajista.
     * @param correo El correo electrónico del masajista.
     * @param usuario El nombre de usuario del masajista.
     * @param contrasena La contraseña del masajista.
     * @param experiencia La experiencia del masajista en años.
     */
    public Masajista(String nombre, String id, String genero, String correo, String usuario, String contrasena, String experiencia) {
        super(nombre, id, genero, correo, usuario, contrasena);
        this.experiencia = experiencia;
    }

    /**
     * Obtiene la experiencia del masajista.
     * 
     * @return La experiencia del masajista.
     */
    public String getExperiencia() {
        return experiencia;
    }

    /**
     * Establece la experiencia del masajista.
     * 
     * @param experiencia La nueva experiencia del masajista.
     */
    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }
}
