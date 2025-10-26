package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Ciclista;
import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.Director;
import co.edu.unbosque.model.DirectorDTO;
import co.edu.unbosque.model.Escuadra;
import co.edu.unbosque.model.EscuadraDTO;
import co.edu.unbosque.model.Etapa;
import co.edu.unbosque.model.EtapaDTO;
import co.edu.unbosque.model.Masajista;
import co.edu.unbosque.model.MasajistaDTO;

/**
 * La clase DataMapper proporciona métodos para traducir objetos DTO (Data Transfer Objects)
 * a objetos del modelo de dominio y viceversa.
 */
public class DataMapper {

    /**
     * Traduce un objeto CiclistaDTO a un objeto Ciclista.
     * 
     * @param dto El objeto CiclistaDTO a traducir.
     * @return Un objeto Ciclista.
     */
    public static Ciclista traducirdeDTO(CiclistaDTO dto) {
        Ciclista cl = new Ciclista(dto.getNombre(), dto.getId(), dto.getGenero(), dto.getCorreo(), dto.getUsuario(), dto.getContrasena(), dto.getTipo(), dto.getTiempoAC(), dto.getCadenciaPedaleo());
        return cl;
    }

    /**
     * Traduce un objeto MasajistaDTO a un objeto Masajista.
     * 
     * @param dto El objeto MasajistaDTO a traducir.
     * @return Un objeto Masajista.
     */
    public static Masajista traducirdeDTO(MasajistaDTO dto) {
        Masajista ma = new Masajista(dto.getNombre(), dto.getId(), dto.getGenero(), dto.getCorreo(), dto.getUsuario(), dto.getContrasena(), dto.getExperiencia());
        return ma;
    }

    /**
     * Traduce un objeto DirectorDTO a un objeto Director.
     * 
     * @param dto El objeto DirectorDTO a traducir.
     * @return Un objeto Director.
     */
    public static Director traducirdeDTO(DirectorDTO dto) {
        Director dt = new Director(dto.getNombre(), dto.getId(), dto.getGenero(), dto.getCorreo(), dto.getUsuario(), dto.getContrasena(), dto.getExperiencia());
        return dt;
    }

    /**
     * Traduce un objeto EtapaDTO a un objeto Etapa.
     * 
     * @param dto El objeto EtapaDTO a traducir.
     * @return Un objeto Etapa.
     */
    public static Etapa traducirdeDTO(EtapaDTO dto) {
        Etapa et = new Etapa(dto.getEscuadras(), dto.getDistancia(), dto.getTiempo());
        return et;
    }

    /**
     * Traduce un objeto EscuadraDTO a un objeto Escuadra.
     * 
     * @param dto El objeto EscuadraDTO a traducir.
     * @return Un objeto Escuadra.
     */
    public static Escuadra traducirdeDTO(EscuadraDTO dto) {
        Escuadra es = new Escuadra(dto.getNombre(), dto.getPais(), dto.getMiembros());
        return es;
    }

}
