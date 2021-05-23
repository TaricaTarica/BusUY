package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import datatypes.DTCompania;

@Entity
public class Compania {
	
	@Id
	@GeneratedValue
	private int id;
	private String nombre;
	
	@OneToMany(mappedBy="compania",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Linea> Lineas = new ArrayList<>();

	
	//Constructor por defecto vacio
	public Compania() {
		super();
	}

	public Compania(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	//Se crea un objeto Compania a partir de un Data Type
	public Compania(DTCompania dtComp) {
		this.id = dtComp.getId();
		this.nombre = dtComp.getNombre();
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
