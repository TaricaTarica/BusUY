package datos;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTHorario;
import datatypes.DTLineaSimple;
import entities.LineaParada;

@Local
public interface DatosLineaParadaLocal {
	public void altaLineaParada(LineaParada lineaParada);
	
	public void modificarHorario(LineaParada lineaParada, int hora, int minuto); 
	
	public void eliminarLineaParada(LineaParada lineaParada);
	
	public List<DTLineaSimple> getLineasForParada(int idParada);
	
	public List<DTHorario> getHorariosLineaParada(int idParada, int idLinea);
	
	public boolean agregarHorario(int idparada, int idlinea, int hora, int minuto);
	
	public boolean borrarLineaParada(int idparada, int idlinea);
	
	public List<DTLineaSimple> getLineasNoAsociadasParada(int idParada);

	
}
