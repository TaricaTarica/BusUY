package controladores;

import java.util.List;

import javax.ejb.Remote;

import datatypes.DTHorario;
import datatypes.DTLineaParada;
import datatypes.DTLineaSimple;

@Remote
public interface controladorLineaParadaRemote {
	
	public void altaLineaParada(DTLineaParada dtLineaParada);
	
	public void modificarLinea(DTLineaParada dtLineaParada, int hora, int minuto);
	
	public void eliminarLineaParada(DTLineaParada dtLineaParada);
	
	public List<DTLineaSimple> getLineasForParada(int idParada);
	
	public List<DTHorario> getHorariosLineaParada(int idParada, int idLinea);
	
    public boolean agregarHorario(int idparada, int idlinea, int hora, int minuto);
    
	public List<DTLineaSimple> getLineasNoAsociadasParada(int idParada);
    
    public boolean borrarLineaParada(int idparada, int idlinea);
    
    public List<String> buscarParadaCambio();
    
    public List<String> buscarRecorridoCambio();

}
