package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * La clase Ciclista representa a un usuario que es ciclista. Hereda de la clase
 * Usuario y agrega atributos específicos para un ciclista, como la cadencia de
 * pedaleo y el tiempo acumulado en carrera.
 */
public class Ciclista extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private int tiempoAC; // Tiempo acumulado en carrera
	private int cadenciaPedaleo; // Cadencia de pedaleo
	private String tipo; // Tipo de ciclista

	/**
	 * Constructor por defecto de la clase Ciclista.
	 */
	public Ciclista() {
		// Llamada al constructor de la superclase Usuario
		super();
	}

	public Ciclista(String nombre) {
		super(nombre, "", "", "", "", "");
		this.cadenciaPedaleo = 0;
		this.tiempoAC = 0;
		this.tipo = "";
	}

	/**
	 * Constructor parametrizado de la clase Ciclista.
	 * 
	 * @param nombre          El nombre del ciclista.
	 * @param id              El identificador del ciclista.
	 * @param genero          El género del ciclista.
	 * @param correo          El correo electrónico del ciclista.
	 * @param usuario         El nombre de usuario del ciclista.
	 * @param contrasena      La contraseña del ciclista.
	 * @param tipo            El tipo de ciclista (por ejemplo, profesional o
	 *                        amateur).
	 * @param tiempoAC        El tiempo acumulado en carrera del ciclista.
	 * @param cadenciaPedaleo La cadencia de pedaleo del ciclista.
	 */
	public Ciclista(String nombre, String id, String genero, String correo, String usuario, String contrasena,
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

	@Override
	public String toString() {
		return "Ciclista{" + "nombre='" + getNombre() + '\'' + ", id='" + getId() + '\'' + ", genero='" + getGenero()
				+ '\'' + ", correo='" + getCorreo() + '\'' + ", usuario='" + getUsuario() + '\'' + ", tipo='" + tipo
				+ '\'' + ", tiempoAC=" + tiempoAC + ", cadenciaPedaleo=" + cadenciaPedaleo + '}';
	}

	public ArrayList<String> getEscuadras() {
		// TODO Auto-generated method stub
		return null;
	}

}
