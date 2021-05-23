package datos;

import javax.ejb.Local;

import entities.Compania;

@Local
public interface DatosCompaniaLocal {
	public void altaCompania(Compania compania);
	public void modificarCompania(Compania compania);
	public void eliminarCompania(Compania compania);
	public Compania buscarCompania(int id);
}
