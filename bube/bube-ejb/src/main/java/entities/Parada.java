package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	private String ubicacion;
	private long x;
	private long y;
	@Lob @Basic(fetch=FetchType.LAZY)
    @Column(name = "geom", columnDefinition = "geometry(point)")
	private String geom;
	private int hora;
	private int min;
	private Estado estado;
	
	@OneToMany(mappedBy="parada",cascade=CascadeType.ALL,orphanRemoval=true) 
	private List<LineaParada> lineaParada = new ArrayList<>(); 
	
	//********* CONSTRUCTORS **************
	
	//Constructor por defecto vacio
	public Parada() {
		super();
	}

	public Parada(int gid, String nombre, String ubicacion, long x, long y, String geom, int hora, int min,
			Estado estado) {
		super();
		this.gid = gid;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.x = x;
		this.y = y;
		this.geom = geom;
		this.hora = hora;
		this.min = min;
		this.estado = estado;
	}



	//Se crea un objeto Parada a partir de un Data Type
	public Parada(DTParada p) {
		super();
		this.gid = p.getGid();
		this.nombre = p.getNombre();
		this.ubicacion = p.getUbicacion();
		this.x = p.getX();
		this.y = p.getY();
		this.geom = p.getGeom();
		this.hora = p.getHora();
		this.min = p.getMin();
		this.estado = p.getEstado();
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

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public long getX() {
		return x;
	}

	public void setX(long x) {
		this.x = x;
	}

	public long getY() {
		return y;
	}

	public void setY(long y) {
		this.y = y;
	}

	public String getGeom() {
		return geom;
	}

	public void setGeom(String geom) {
		this.geom = geom;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
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
