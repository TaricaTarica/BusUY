package datatypes;

import java.io.Serializable;

import entities.Parada;
import enumerations.Estado;

public class DTParada implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int gid;
	private String nombre;
	private String geom;
	private Estado estado;
	private String fechaMod;
	
	
	//********* CONSTRUCTORS **************
	
	//Constructor por defecto vacio
	public DTParada() {
		super();
	}

	public DTParada(int gid, String nombre, String geom, Estado estado, String fechaMod) {
		super();
		this.gid = gid;
		this.nombre = nombre;
		this.geom = geom;
		this.estado = estado;
		this.fechaMod = fechaMod;
	}



	public DTParada(Parada p) {
		super();
		this.gid = p.getGid();
		this.nombre = p.getNombre();
		this.geom = p.getGeom();
		this.estado = p.getEstado();
		this.fechaMod = p.getFechaMod().toString();
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

	public String getFechaMod() {
		return fechaMod;
	}

	public void setFechaMod(String fechaMod) {
		this.fechaMod = fechaMod;
	}

}
