package controladores;

import java.util.List;

import javax.ejb.Remote;

import datatypes.DTLinea;
import datatypes.DTLineaSimple;

@Remote
public interface controladorLineaRemote {
	
	public void altaLinea(DTLinea linea);
	
	public void modificarLinea(DTLinea linea);
	
	public void eliminarLinea(DTLinea linea);
	
	public DTLinea buscarLinea(int gid);

	public List<DTLineaSimple> listarLineaCompania(int id);
}
