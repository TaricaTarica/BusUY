package datos;

import javax.ejb.Local;

import entities.Parada;

@Local
public interface DatosParadaLocal {
	public void altaParada(Parada parada);
	public void modificarParada(Parada parada);
	public void eliminarParada(Parada parada);
	public Parada buscarParada(int gid);

}
