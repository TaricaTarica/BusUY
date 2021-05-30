package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import datatypes.DTParada;
import enumerations.Estado;

@Entity
public class Parada {

	@Id
	@GeneratedValue
	private int gid;
	private String nombre;
	@Lob @Basic(fetch=FetchType.LAZY)
    @Column(name = "geom", columnDefinition = "geometry(point)")
	private String geom;
	@Enumerated(value = EnumType.STRING)
	private Estado estado;
	private LocalDate fechaMod;
	
	@OneToMany(mappedBy="parada",cascade=CascadeType.ALL,orphanRemoval=true) 
	private List<LineaParada> lineaParada = new ArrayList<>(); 
	
	//********* CONSTRUCTORS **************
	
	//Constructor por defecto vacio
	public Parada() {
		super();
	}
	
	public Parada(int gid, String nombre, String geom, Estado estado, LocalDate fechaMod,
			List<LineaParada> lineaParada) {
		super();
		this.gid = gid;
		this.nombre = nombre;
		this.geom = geom;
		this.estado = estado;
		this.fechaMod = fechaMod;
		this.lineaParada = lineaParada;
	}


	//Se crea un objeto Parada a partir de un Data Type
	public Parada(DTParada p) {
		super();
		this.gid = p.getGid();
		this.nombre = p.getNombre();
		this.geom = p.getGeom();
		this.estado = p.getEstado();
		this.fechaMod = LocalDate.parse(p.getFechaMod(), DateTimeFormatter.ofPattern("d/MM/yyyy"));
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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
