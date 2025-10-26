package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase Escuadra representa un equipo de ciclismo.
 */
public class EscuadraDTO implements Serializable {
    private static final long serialVersionUID = 2105548043932592610L;
    private String nombre; // Nombre de la escuadra
    private String pais; // País de origen de la escuadra
    private ArrayList<Usuario> miembros; // Lista de miembros de la escuadra
    private List<Ciclista> ciclistas; // Lista de ciclistas de la escuadra

    /**
     * Constructor por defecto de la clase Escuadra.
     */
    public EscuadraDTO() {
        // Inicialización de la lista de ciclistas para evitar NullPointerException
        this.ciclistas = new ArrayList<>();
    }

    /**
     * Constructor parametrizado de la clase Escuadra.
     * 
     * @param nombre    El nombre de la escuadra.
     * @param pais      El país de origen de la escuadra.
     * @param miembros  La lista de miembros de la escuadra.
     */
    public EscuadraDTO(String nombre, String pais, ArrayList<Usuario> miembros) {
        this(); // Llamada al constructor por defecto para inicializar la lista de ciclistas
        this.nombre = nombre;
        this.pais = pais;
        this.miembros = miembros;
    }

    /**
     * Obtiene el nombre de la escuadra.
     * 
     * @return El nombre de la escuadra.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la escuadra.
     * 
     * @param nombre El nuevo nombre de la escuadra.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el país de origen de la escuadra.
     * 
     * @return El país de origen de la escuadra.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Establece el país de origen de la escuadra.
     * 
     * @param pais El nuevo país de origen de la escuadra.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Obtiene la lista de miembros de la escuadra.
     * 
     * @return La lista de miembros de la escuadra.
     */
    public ArrayList<Usuario> getMiembros() {
        return miembros;
    }

    /**
     * Establece la lista de miembros de la escuadra.
     * 
     * @param miembros La nueva lista de miembros de la escuadra.
     */
    public void setMiembros(ArrayList<Usuario> miembros) {
        this.miembros = miembros;
    }

    /**
     * Obtiene la lista de ciclistas de la escuadra.
     * 
     * @return La lista de ciclistas de la escuadra.
     */
    public List<Ciclista> getCiclistas() {
        return ciclistas;
    }

    /**
     * Establece la lista de ciclistas de la escuadra.
     * 
     * @param ciclistas La nueva lista de ciclistas de la escuadra.
     */
    public void setCiclistas(List<Ciclista> ciclistas) {
        this.ciclistas = ciclistas;
    }

    /**
     * Devuelve una representación de cadena de la escuadra (en este caso, su nombre).
     * 
     * @return El nombre de la escuadra.
     */
    @Override
    public String toString() {
        return nombre; // Devolver el nombre de la escuadra para que se muestre en el JComboBox
    }
}
