package controladores;

import javax.ejb.Remote;

import datatypes.DTAdministrador;

@Remote
public interface controladorAdministradorRemote {
	public void altaAdministrador(DTAdministrador administrador);
	public void modificarAdministrador(DTAdministrador administrador);
	public void eliminarAdministrador(DTAdministrador administrador);
	public DTAdministrador buscarAdministrador(String usuario);
	public boolean iniciarSesion(DTAdministrador dtAdministrador);
}
