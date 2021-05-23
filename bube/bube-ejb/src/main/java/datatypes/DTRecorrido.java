package datatypes;

import java.io.Serializable;
import java.time.LocalDate;

import entities.Recorrido;

public class DTRecorrido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long codigo;
	private String nombre;
	private Boolean desvio;
	private LocalDate fechaMod;
	private String geom;
	
	//********* CONSTRUCTORS **************
	
	//Constructor por defecto vacio
	public DTRecorrido() {
		super();
	}

	public DTRecorrido(long codigo, String nombre, Boolean desvio, LocalDate fechaMod, String geom) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.desvio = desvio;
		this.fechaMod = fechaMod;
		this.geom = geom;
	}

	//Se crea un DTRecorrido a partir de un objeto Recorrido
	public DTRecorrido(Recorrido recorrido) {
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
		
	
}
