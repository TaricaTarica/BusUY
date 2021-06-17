package datos;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTLineaSimple;
import entities.LineaParada;

@Local
public interface DatosLineaParadaLocal {
	public void altaLineaParada(LineaParada lineaParada);
	
	public void modificarHorario(LineaParada lineaParada, int hora, int minuto); 
	
	public void eliminarLineaParada(LineaParada lineaParada);
	
	public List<DTLineaSimple> getLineasForParada(int idParada);
	
}