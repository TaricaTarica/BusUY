package controladores;

import java.util.List;

import javax.ejb.Remote;

import datatypes.DTCompania;

@Remote
public interface controladorCompaniaRemote {
	public void altaCompania(DTCompania compania);
	
	public void modificarCompania(DTCompania compania);
	
	public void eliminarCompania(DTCompania compania);
	
	public DTCompania buscarCompania(int id);
	
	public List<DTCompania> listarCompanias();
}
