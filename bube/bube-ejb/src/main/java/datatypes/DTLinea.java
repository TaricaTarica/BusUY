package datatypes;

import java.io.Serializable;
import java.time.LocalDate;

import entities.Linea;

public class DTLinea implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int gid;
	private String codigo;
	private String origen;
	private String destino;
	private String geom;
	private Boolean desvio;
	private LocalDate fechaMod;
	private DTCompania compania;
	
	//********* CONSTRUCTORS **************
	
	//Constructor por defecto vacio
	public DTLinea() {
		super();
	}

	public DTLinea(int gid, String codigo, String origen, String destino, String geom, Boolean desvio,
			LocalDate fechaMod, DTCompania compania) {
		super();
		this.gid = gid;
		this.codigo = codigo;
		this.origen = origen;
		this.destino = destino;
		this.geom = geom;
		this.desvio = desvio;
		this.fechaMod = fechaMod;
		this.compania = compania;
	}

	//Se crea un DTLinea a partir de un objeto Linea
	public DTLinea(Linea linea) {
		this.gid = linea.getGid();
		this.codigo = linea.getCodigo();
		this.origen = linea.getOrigen();
		this.destino = linea.getDestino();
		this.geom = linea.getGeom();
		this.desvio = linea.getDesvio();
		this.fechaMod = linea.getFechaMod();
		this.compania = new DTCompania(linea.getCompania());
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getGeom() {
		return geom;
	}

	public void setGeom(String geom) {
		this.geom = geom;
	}

	public Boolean getDesvio() {
		return desvio;
	}

	public void setDesvio(Boolean desvio) {
		this.desvio = desvio;
	}

	public LocalDate getFechaMod() {
		return fechaMod;
	}

	public void setFechaMod(LocalDate fechaMod) {
		this.fechaMod = fechaMod;
	}

	public DTCompania getCompania() {
		return compania;
	}

	public void setCompania(DTCompania compania) {
		this.compania = compania;
	}
	
}
