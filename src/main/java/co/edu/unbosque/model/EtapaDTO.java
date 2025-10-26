package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class EtapaDTO implements Serializable  {
	private ArrayList<Escuadra> escuadras;
	private int distancia;
	private String tiempo;
	
	public EtapaDTO() {
		// TODO Auto-generated constructor stub
	}
	public EtapaDTO(ArrayList<Escuadra> escuadras, int distancia, String tiempo) {
		this.escuadras = escuadras;
		this.distancia = distancia;
		this.tiempo = tiempo;
	}

	public ArrayList<Escuadra> getEscuadras() {
		return escuadras;
	}

	public void setEscuadras(ArrayList<Escuadra> escuadras) {
		this.escuadras = escuadras;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	

}
