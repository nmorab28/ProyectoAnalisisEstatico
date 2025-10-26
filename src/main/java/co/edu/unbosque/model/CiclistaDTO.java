package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase CiclistaDTO representa un objeto de transferencia de datos
 * para un ciclista. Contiene información sobre el tiempo acumulado en
 * carrera, la cadencia de pedaleo y el tipo de ciclista.
 * Hereda de la clase Usuario y agrega atributos específicos para un
 * ciclista DTO.
 */
public class CiclistaDTO extends Usuario implements Serializable {
    private int tiempoAC; // Tiempo acumulado en carrera
    private int cadenciaPedaleo; // Cadencia de pedaleo
    private String tipo; // Tipo de ciclista

    /**
     * Constructor por defecto de la clase CiclistaDTO.
     */
    public CiclistaDTO() {
        // Llamada al constructor de la superclase Usuario
        super();
    }

    /**
     * Constructor parametrizado de la clase CiclistaDTO.
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
     */
    public CiclistaDTO(String nombre, String id, String genero, String correo, String usuario, String contrasena,
            String tipo, int tiempoAC, int cadenciaPedaleo) {
        // Llamada al constructor de la superclase Usuario
        super(nombre, id, genero, correo, usuario, contrasena);
        this.tiempoAC = tiempoAC;
        this.cadenciaPedaleo = cadenciaPedaleo;
        this.tipo = tipo;
    }

    /**
     * Obtiene el tipo de ciclista.
     * 
     * @return El tipo de ciclista.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de ciclista.
     * 
     * @param tipo El nuevo tipo de ciclista.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el tiempo acumulado en carrera del ciclista.
     * 
     * @return El tiempo acumulado en carrera.
     */
    public int getTiempoAC() {
        return tiempoAC;
    }

    /**
     * Establece el tiempo acumulado en carrera del ciclista.
     * 
     * @param tiempoAC El nuevo tiempo acumulado en carrera.
     */
    public void setTiempoAC(int tiempoAC) {
        this.tiempoAC = tiempoAC;
    }

    /**
     * Obtiene la cadencia de pedaleo del ciclista.
     * 
     * @return La cadencia de pedaleo.
     */
    public int getCadenciaPedaleo() {
        return cadenciaPedaleo;
    }

    /**
     * Establece la cadencia de pedaleo del ciclista.
     * 
     * @param cadenciaPedaleo La nueva cadencia de pedaleo.
     */
    public void setCadenciaPedaleo(int cadenciaPedaleo) {
        this.cadenciaPedaleo = cadenciaPedaleo;
    }

}
