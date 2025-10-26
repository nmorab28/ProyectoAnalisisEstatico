package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase Usuario representa a un usuario genérico del sistema.
 * Contiene información básica como nombre, identificación, género, correo electrónico,
 * nombre de usuario y contraseña.
 */
public class Usuario implements Serializable {
    private String nombre, id, genero, usuario, correo, contrasena;

    /**
     * Crea un nuevo objeto Usuario sin inicializar sus atributos.
     */
    public Usuario() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Crea un nuevo objeto Usuario con los atributos especificados.
     * 
     * @param nombre El nombre del usuario.
     * @param id La identificación del usuario.
     * @param genero El género del usuario.
     * @param correo El correo electrónico del usuario.
     * @param usuario El nombre de usuario del usuario.
     * @param contrasena La contraseña del usuario.
     */
    public Usuario(String nombre, String id, String genero, String correo, String usuario, String contrasena) {
        super();
        this.nombre = nombre;
        this.id = id;
        this.genero = genero;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el nombre de usuario.
     * 
     * @return El nombre de usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario.
     * 
     * @param usuario El nombre de usuario a establecer.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    /**
     * Obtiene la contraseña del usuario.
     * 
     * @return La contraseña del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     * 
     * @param contrasena La contraseña del usuario a establecer.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
