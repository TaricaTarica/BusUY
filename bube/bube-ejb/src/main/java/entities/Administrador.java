package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import datatypes.DTAdministrador;

@Entity
public class Administrador {

	@Id
	private String nombreUsuario;
	private String contrasena;
			
	public Administrador() {
		super();
	}

	

	public Administrador(String nombreUsuario, String contrasena) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
	}


	public Administrador(DTAdministrador administrador) {
		super();
		this.nombreUsuario = administrador.getNombreUsuario();
		this.contrasena = administrador.getContrasenia();
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	
}
