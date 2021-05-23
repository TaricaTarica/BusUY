package datatypes;

import java.io.Serializable;

import entities.Administrador;

public class DTAdministrador implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nombreUsuario;
	private String contrasenia;
	
	public DTAdministrador() {
		super();
	}

	public DTAdministrador(String nombreUsuario, String contrasenia) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
	}



	public DTAdministrador(Administrador adm) {
		this.nombreUsuario = adm.getNombreUsuario();
		this.contrasenia = adm.getContrasena();
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

}
