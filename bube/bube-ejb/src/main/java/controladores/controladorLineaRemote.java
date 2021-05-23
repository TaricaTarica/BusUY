package controladores;

import javax.ejb.Remote;

import datatypes.DTLinea;

@Remote
public interface controladorLineaRemote {
	public void altaLinea(DTLinea linea);
	public void modificarLinea(DTLinea linea);
	public void eliminarLinea(DTLinea linea);
	public DTLinea buscarLinea(int gid);
}
