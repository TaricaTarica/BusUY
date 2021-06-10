package datos;

import javax.ejb.Local;

import entities.LineaParada;

@Local
public interface DatosLineaParadaLocal {
	public void altaLineaParada(LineaParada lineaParada);
	
	public void modificarHorario(LineaParada lineaParada, int hora, int minuto); 
	
	public void eliminarLineaParada(LineaParada lineaParada);
	
}
