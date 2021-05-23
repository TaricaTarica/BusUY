package beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import controladores.controladorAdministradorRemote;
import datatypes.DTAdministrador;

@Named("IniciarSesion")
@ViewScoped
public class IniciarSesion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private controladorAdministradorRemote car;
	private String usuario;
	private String password;
	
	public IniciarSesion() {
		// TODO Auto-generated constructor stub
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String iniciarSesion() {
		DTAdministrador administrador = new DTAdministrador(usuario, password);
		String redireccion = null;
		try {
			if(car.iniciarSesion(administrador)) {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("administrador", true);
				redireccion = "index?faces-redirect=true";
			}
			else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Usuario y/o contraseña invalidos" ));
			}
		}
		catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "No se puedo iniciar sesion" ));
		}
		return redireccion;
	}

}
