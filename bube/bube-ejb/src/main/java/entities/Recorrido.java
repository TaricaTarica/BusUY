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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import datatypes.DTRecorrido;

@Entity
public class Recorrido {

	@Id
	private long codigo;
	private String nombre;
	private Boolean desvio;
	private LocalDate fechaMod;
	@Lob @Basic(fetch=FetchType.LAZY)
    @Column(name = "geom", columnDefinition = "geometry(linestring)")
	private String geom;

	@ManyToOne
	private Linea linea;
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Parada> paradas = new ArrayList<>();
	
	
	//********* CONSTRUCTORS **************
	
	//Constructor por defecto vacio
	public Recorrido() {
		super();
	}

	public Recorrido(long codigo, String nombre, Boolean desvio, LocalDate fechaMod, String geom, Linea linea) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.desvio = desvio;
		this.fechaMod = fechaMod;
		this.geom = geom;
		this.linea = linea;
	}

	//Se crea un objeto Recorrido a partir de un Data Type
	public Recorrido(DTRecorrido recorrido) {
		this.codigo = recorrido.getCodigo();
		this.nombre = recorrido.getNombre();
		this.desvio = recorrido.getDesvio();
		this.fechaMod = recorrido.getFechaMod();
		this.geom = recorrido.getGeom();
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getGeom() {
		return geom;
	}

	public void setGeom(String geom) {
		this.geom = geom;
	}

	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	public List<Parada> getParadas() {
		return paradas;
	}

	public void setParadas(List<Parada> paradas) {
		this.paradas = paradas;
	}

}
