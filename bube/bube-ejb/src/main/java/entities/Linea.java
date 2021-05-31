package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import datatypes.DTLinea;

@Entity
public class Linea {

	@Id
	private int gid;
	private String codigo;
	private String origen;
	private String destino;
	private Boolean desvio;
	private LocalDate fechaMod;
	@Lob @Basic(fetch=FetchType.LAZY)
    @Column(name = "geom", columnDefinition = "geometry(linestring)")
	private String geom;
	
	@ManyToOne
	private Compania compania;
	
	
	@OneToMany(mappedBy="parada",cascade=CascadeType.ALL,orphanRemoval=true) 
	private List<LineaParada> lineaParada = new ArrayList<>();
	
	//********* CONSTRUCTORS **************
	
	//Constructor por defecto vacio
	public Linea() {
		super();
	}

	public Linea(int gid, String codigo, String origen, String destino, Boolean desvio, LocalDate fechaMod, String geom,
			Compania compania) {
		super();
		this.gid = gid;
		this.codigo = codigo;
		this.origen = origen;
		this.destino = destino;
		this.desvio = desvio;
		this.fechaMod = fechaMod;
		this.geom = geom;
		this.compania = compania;
	}

	//Se crea un objeto Linea a partir de un Data Type
	public Linea(DTLinea linea) {
		this.gid = linea.getGid();
		this.codigo = linea.getCodigo();
		this.origen = linea.getOrigen();
		this.destino = linea.getDestino();
		this.geom = linea.getGeom();
		this.fechaMod = linea.getFechaMod();
		this.desvio = linea.getDesvio();
		this.compania = new Compania(linea.getCompania());
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


	public Compania getCompania() {
		return compania;
	}


	public void setCompania(Compania compania) {
		this.compania = compania;
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

	public List<LineaParada> getLineaParada() {
		return lineaParada;
	}


	public void setLineaParada(List<LineaParada> lineaParada) {
		this.lineaParada = lineaParada;
	}
	
	public void addLineaParada(LineaParada lineaParada) {
		this.lineaParada.add(lineaParada);
	}
	
}
