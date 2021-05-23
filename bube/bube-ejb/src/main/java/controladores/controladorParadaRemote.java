package controladores;

import javax.ejb.Remote;

import datatypes.DTParada;

@Remote
public interface controladorParadaRemote {
	public void altaParada(DTParada parada);
	public void modificarParada(DTParada parada);
	public void eliminarParada(DTParada parada);
	public DTParada buscarParda(int gid);
}
