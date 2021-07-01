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
	
	public DTLineaSimple buscarLinea(int gid);

	public List<DTLineaSimple> listarLineaCompania(int id);
	
	public void modificarRecorridoLinea(String geomCoordenadas, int gidLinea);
	
	public void modificarParada(String geomCoordenadas, int gidParada);
}
