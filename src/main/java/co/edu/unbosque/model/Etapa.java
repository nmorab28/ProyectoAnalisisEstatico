package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * La clase Etapa representa una etapa de una competencia de ciclismo.
 */
public class Etapa implements Serializable {
    private ArrayList<Escuadra> escuadras; // Lista de escuadras que participan en la etapa
    private int distancia; // Distancia de la etapa
    private String tiempo; // Tiempo estimado de la etapa

    /**
     * Constructor por defecto de la clase Etapa.
     */
    public Etapa() {
        // No se inicializan los atributos ya que dependen de la lógica de la aplicación
    }

    /**
     * Constructor parametrizado de la clase Etapa.
     * 
     * @param escuadras La lista de escuadras que participan en la etapa.
     * @param distancia La distancia de la etapa.
     * @param tiempo    El tiempo estimado de la etapa.
     */
    public Etapa(ArrayList<Escuadra> escuadras, int distancia, String tiempo) {
        this.escuadras = escuadras;
        this.distancia = distancia;
        this.tiempo = tiempo;
    }

    /**
     * Obtiene la lista de escuadras que participan en la etapa.
     * 
     * @return La lista de escuadras que participan en la etapa.
     */
    public ArrayList<Escuadra> getEscuadras() {
        return escuadras;
    }

    /**
     * Establece la lista de escuadras que participan en la etapa.
     * 
     * @param escuadras La nueva lista de escuadras que participan en la etapa.
     */
    public void setEscuadras(ArrayList<Escuadra> escuadras) {
        this.escuadras = escuadras;
    }

    /**
     * Obtiene la distancia de la etapa.
     * 
     * @return La distancia de la etapa.
     */
    public int getDistancia() {
        return distancia;
    }

    /**
     * Establece la distancia de la etapa.
     * 
     * @param distancia La nueva distancia de la etapa.
     */
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    /**
     * Obtiene el tiempo estimado de la etapa.
     * 
     * @return El tiempo estimado de la etapa.
     */
    public String getTiempo() {
        return tiempo;
    }

    /**
     * Establece el tiempo estimado de la etapa.
     * 
     * @param tiempo El nuevo tiempo estimado de la etapa.
     */
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
}
