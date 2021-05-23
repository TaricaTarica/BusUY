package datos;

import javax.ejb.Local;

import entities.Recorrido;

@Local
public interface DatosRecorridoLocal {
	public void altaRecorrido(Recorrido recorrido);
	public void modificarRecorrido(Recorrido recorrido);
	public void eliminarRecorrido(Recorrido recorrido);
	public Recorrido buscarRecorrido(long codigo);
}
