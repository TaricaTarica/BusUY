package datos;

import javax.ejb.Local;

import entities.Administrador;

@Local
public interface DatosAdministradorLocal {
	public void altaAdminsitrador(Administrador administrador);
	public void modificarAdministrador(Administrador administrador);
	public void eliminarAdministrador(Administrador administrador);
	public Administrador buscarAdministrador(String usuario);
}
