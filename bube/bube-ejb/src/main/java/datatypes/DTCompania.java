package datatypes;

import java.io.Serializable;

import entities.Compania;

public class DTCompania implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	private String nombre;

	
	//********* CONSTRUCTORS **************
	
	//Constructor por defecto vacio
	public DTCompania() {
		super();
	}

	public DTCompania(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	//Se crea un DTCompania a partir de un objeto Compania
	public DTCompania(Compania comp) {
		this.id = comp.getId();
		this.nombre = comp.getNombre();
	}

	//******** GETTERS AND SETTERS ************
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
