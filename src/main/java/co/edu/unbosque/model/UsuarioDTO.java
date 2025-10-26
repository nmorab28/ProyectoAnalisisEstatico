package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase UsuarioDTO es un objeto de transferencia de datos que contiene información básica
 * de un usuario para ser transferido entre diferentes capas de la aplicación.
 */
public class UsuarioDTO implements Serializable {
    private String nombre, id, genero, correo;
	
    /**
     * Crea un nuevo objeto UsuarioDTO sin inicializar sus atributos.
     */
    public UsuarioDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Crea un nuevo objeto UsuarioDTO con los atributos especificados.
     * 
     * @param nombre El nombre del usuario.
     * @param id La identificación del usuario.
     * @param genero El género del usuario.
     * @param correo El correo electrónico del usuario.
     */
    public UsuarioDTO(String nombre, String id, String genero, String correo) {
        super();
        this.nombre = nombre;
        this.id = id;
        this.genero = genero;
        this.correo = correo;
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * 
     * @param nombre El nombre del usuario a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la identificación del usuario.
     * 
     * @return La identificación del usuario.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece la identificación del usuario.
     * 
     * @param id La identificación del usuario a establecer.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el género del usuario.
     * 
     * @return El género del usuario.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género del usuario.
     * 
     * @param genero El género del usuario a establecer.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * 
     * @return El correo electrónico del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     * 
     * @param correo El correo electrónico del usuario a establecer.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
