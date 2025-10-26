package co.edu.unbosque.model;

/**
 * Data Transfer Object (DTO) para la clase Administrador.
 * Esta clase encapsula los datos del administrador y proporciona
 * métodos para obtener y establecer estos valores.
 */
public class AdministradorDTO {
    private String usuario = "efectoMariposa";
    private String contraseña = "mariposones2024";
    
    /**
     * Crea un nuevo AdministradorDTO con los valores especificados de usuario y contraseña.
     * 
     * @param usuario El nombre de usuario del administrador.
     * @param contraseña La contraseña del administrador.
     */
    public AdministradorDTO(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    /**
     * Obtiene el nombre de usuario del administrador.
     * 
     * @return El nombre de usuario del administrador.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario del administrador.
     * 
     * @param usuario El nuevo nombre de usuario del administrador.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la contraseña del administrador.
     * 
     * @return La contraseña del administrador.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña del administrador.
     * 
     * @param contraseña La nueva contraseña del administrador.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
