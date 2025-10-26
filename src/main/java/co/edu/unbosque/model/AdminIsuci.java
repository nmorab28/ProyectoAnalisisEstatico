package co.edu.unbosque.model;

import java.io.IOException;
import java.util.ArrayList;
import co.edu.unbosque.model.persistence.CiclistaDAO;
import co.edu.unbosque.model.persistence.DirectorDAO;
import co.edu.unbosque.model.persistence.EscuadraDAO;
import co.edu.unbosque.model.persistence.EtapaDAO;
import co.edu.unbosque.model.persistence.FileManager;
import co.edu.unbosque.model.persistence.MasajistaDAO;

public class AdminIsuci {
	private ArrayList<Ciclista> ciclistas;
	private ArrayList<CiclistaDTO> ciclistasDTO;
	private ArrayList<Contrarreloj> contrarreloj;
	private ArrayList<ContrarrelojDTO> contrarrelojDTO;
	private ArrayList<Director> directores;
	private ArrayList<DirectorDTO> directoresDTO;
	private ArrayList<Escalador> escaladores;
	private ArrayList<EscaladorDTO> escaladoresDTO;
	private ArrayList<Escuadra>escuadras;
	private ArrayList<EscuadraDTO>escuadrasDTO;
	private ArrayList<Etapa> etapas;
	private ArrayList<EtapaDTO> etapasDTO;
	private ArrayList<Gregario> gregarios;
	private ArrayList<GregarioDTO> gregarioDTO;
	private ArrayList<Masajista> masajistas;
	private ArrayList<MasajistaDTO> masajistasDTO;
	private ArrayList<Rodador> rodadores;
	private ArrayList<RodadorDTO> rodadoresDTO;
	private ArrayList<Sprinter> sprinter;
	private ArrayList<SprinterDTO> sprinterDTO;
	private ArrayList<Usuario> usuarios;
	private ArrayList<UsuarioDTO> usuariosDTO;
	private CiclistaDAO cidao;
	private DirectorDAO didao;
	private EscuadraDAO edao;
	private EtapaDAO etdao;
	private MasajistaDAO madao;
	private FileManager fm;

	public AdminIsuci() {
		super();
		ciclistas = new ArrayList<Ciclista>();
		ciclistasDTO = new ArrayList<CiclistaDTO>();
		contrarreloj = new ArrayList<Contrarreloj>();
		contrarrelojDTO = new ArrayList<ContrarrelojDTO>();
		directores = new ArrayList<Director>();
		directoresDTO = new ArrayList<DirectorDTO>();
		escaladores = new ArrayList<Escalador>();
		escaladoresDTO = new ArrayList<EscaladorDTO>();
		escuadras = new ArrayList<Escuadra>();
		escuadrasDTO = new ArrayList<EscuadraDTO>();
		etapas = new ArrayList<Etapa>();
		etapasDTO = new ArrayList<EtapaDTO>();
		gregarios = new ArrayList<Gregario>();
		gregarioDTO = new ArrayList<GregarioDTO>();
		masajistas = new ArrayList<Masajista>();
		masajistasDTO = new ArrayList<MasajistaDTO>();
		rodadores = new ArrayList<Rodador>();
		rodadoresDTO = new ArrayList<RodadorDTO>();
		sprinter = new ArrayList<Sprinter>();
		sprinterDTO = new ArrayList<SprinterDTO>();
		usuarios = new ArrayList<Usuario>();
		usuariosDTO = new ArrayList<UsuarioDTO>();
		cidao = new CiclistaDAO();
		didao = new DirectorDAO();
		edao= new EscuadraDAO();
		madao = new MasajistaDAO();
		fm = new FileManager();
	}

	
	public ArrayList<Escuadra> getEscuadras() {
		return escuadras;
	}


	public void setEscuadras(ArrayList<Escuadra> escuadras) {
		this.escuadras = escuadras;
	}


	public ArrayList<EscuadraDTO> getEscuadrasDTO() {
		return escuadrasDTO;
	}


	public void setEscuadrasDTO(ArrayList<EscuadraDTO> escuadrasDTO) {
		this.escuadrasDTO = escuadrasDTO;
	}


	public EscuadraDAO getEdao() {
		return edao;
	}


	public void setEdao(EscuadraDAO edao) {
		this.edao = edao;
	}


	public DirectorDAO getDidao() {
		return didao;
	}

	public void setDidao(DirectorDAO didao) {
		this.didao = didao;
	}

	public ArrayList<Ciclista> getCiclistas() {
		return ciclistas;
	}

	public void setCiclistas(ArrayList<Ciclista> ciclistas) {
		this.ciclistas = ciclistas;
	}

	public ArrayList<CiclistaDTO> getCiclistasDTO() {
		return ciclistasDTO;
	}

	public void setCiclistasDTO(ArrayList<CiclistaDTO> ciclistasDTO) {
		this.ciclistasDTO = ciclistasDTO;
	}

	public ArrayList<Contrarreloj> getContrarreloj() {
		return contrarreloj;
	}

	public void setContrarreloj(ArrayList<Contrarreloj> contrarreloj) {
		this.contrarreloj = contrarreloj;
	}

	public ArrayList<ContrarrelojDTO> getContrarrelojDTO() {
		return contrarrelojDTO;
	}

	public void setContrarrelojDTO(ArrayList<ContrarrelojDTO> contrarrelojDTO) {
		this.contrarrelojDTO = contrarrelojDTO;
	}

	public ArrayList<Director> getDirectores() {
		return directores;
	}

	public void setDirectores(ArrayList<Director> directores) {
		this.directores = directores;
	}

	public ArrayList<DirectorDTO> getDirectoresDTO() {
		return directoresDTO;
	}

	public void setDirectoresDTO(ArrayList<DirectorDTO> directoresDTO) {
		this.directoresDTO = directoresDTO;
	}

	public ArrayList<Escalador> getEscaladores() {
		return escaladores;
	}

	public void setEscaladores(ArrayList<Escalador> escaladores) {
		this.escaladores = escaladores;
	}

	public ArrayList<EscaladorDTO> getEscaladoresDTO() {
		return escaladoresDTO;
	}

	public void setEscaladoresDTO(ArrayList<EscaladorDTO> escaladoresDTO) {
		this.escaladoresDTO = escaladoresDTO;
	}

	public ArrayList<Etapa> getEtapas() {
		return etapas;
	}

	public void setEtapas(ArrayList<Etapa> etapas) {
		this.etapas = etapas;
	}

	public ArrayList<EtapaDTO> getEtapasDTO() {
		return etapasDTO;
	}

	public void setEtapasDTO(ArrayList<EtapaDTO> etapasDTO) {
		this.etapasDTO = etapasDTO;
	}

	public ArrayList<Gregario> getGregarios() {
		return gregarios;
	}

	public void setGregarios(ArrayList<Gregario> gregarios) {
		this.gregarios = gregarios;
	}

	public ArrayList<GregarioDTO> getGregarioDTO() {
		return gregarioDTO;
	}

	public void setGregarioDTO(ArrayList<GregarioDTO> gregarioDTO) {
		this.gregarioDTO = gregarioDTO;
	}

	public ArrayList<Masajista> getMasajistas() {
		return masajistas;
	}

	public void setMasajistas(ArrayList<Masajista> masajistas) {
		this.masajistas = masajistas;
	}

	public ArrayList<MasajistaDTO> getMasajistasDTO() {
		return masajistasDTO;
	}

	public void setMasajistasDTO(ArrayList<MasajistaDTO> masajistasDTO) {
		this.masajistasDTO = masajistasDTO;
	}

	public ArrayList<Rodador> getRodadores() {
		return rodadores;
	}

	public void setRodadores(ArrayList<Rodador> rodadores) {
		this.rodadores = rodadores;
	}

	public ArrayList<RodadorDTO> getRodadoresDTO() {
		return rodadoresDTO;
	}

	public void setRodadoresDTO(ArrayList<RodadorDTO> rodadoresDTO) {
		this.rodadoresDTO = rodadoresDTO;
	}

	public ArrayList<Sprinter> getSprinter() {
		return sprinter;
	}

	public void setSprinter(ArrayList<Sprinter> sprinter) {
		this.sprinter = sprinter;
	}

	public ArrayList<SprinterDTO> getSprinterDTO() {
		return sprinterDTO;
	}

	public void setSprinterDTO(ArrayList<SprinterDTO> sprinterDTO) {
		this.sprinterDTO = sprinterDTO;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public ArrayList<UsuarioDTO> getUsuariosDTO() {
		return usuariosDTO;
	}

	public void setUsuariosDTO(ArrayList<UsuarioDTO> usuariosDTO) {
		this.usuariosDTO = usuariosDTO;
	}

	public CiclistaDAO getCidao() {
		return cidao;
	}

	public void setCidao(CiclistaDAO cidao) {
		this.cidao = cidao;
	}

	public EtapaDAO getEtdao() {
		return etdao;
	}

	public void setEtdao(EtapaDAO etdao) {
		this.etdao = etdao;
	}


	public MasajistaDAO getMadao() {
		return madao;
	}

	public void setMadao(MasajistaDAO madao) {
		this.madao = madao;
	}

	public void crearCiclista(Ciclista traducirdeDTO) throws IOException {
		cidao.crear(traducirdeDTO);
	}

	public void crearMasajista(Masajista traducirdeDTO) throws IOException {
		madao.crear(traducirdeDTO);
	}

	public void crearDt(Director traducirdeDTO) throws IOException {
		didao.crear(traducirdeDTO);
	}
	
	public ArrayList<Ciclista> leerCiclista() {
		return fm.leerCiclistas("Ciclistas.dat");
	}
	public ArrayList<Masajista> leerMasajistas() {
		return fm.leerMasajistas("Masajistas.dat");
	}
	public ArrayList<Director> leerDirectores() {
		return fm.leerDirectores("Directores.dat");
	}
	public void crearEscuadra(Escuadra traducirdeDTO)throws IOException{
	edao.crear(traducirdeDTO);
	}

	public void eliminarCiclista(String id) throws IOException {
	    cidao.eliminar(id);
	}


	public void eliminarMasajista(String id) throws IOException {
	    madao.eliminar(id);
	}

	public void eliminarDirector(String id) throws IOException {
	    didao.eliminar(id);
	}


	public ArrayList<Escuadra> leerEscuadras() {
		return fm.leerEscuadras("Escuadras.dat");
	}
}
