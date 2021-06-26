package controladores;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datatypes.DTHorario;
import datatypes.DTLineaParada;
import datatypes.DTLineaSimple;
import datos.DatosLineaParadaLocal;

import entities.LineaParada;

/**
 * Session Bean implementation class controladorLineaParada
 */
@Stateless
@LocalBean
public class controladorLineaParada implements controladorLineaParadaRemote {

	@EJB
	DatosLineaParadaLocal dlpl;
    /**
     * Default constructor. 
     */
    public controladorLineaParada() {
        // TODO Auto-generated constructor stub
    }

	public void altaLineaParada(DTLineaParada dtLineaParada) {
    	LineaParada newLineaParada = new LineaParada(dtLineaParada);
    	dlpl.altaLineaParada(newLineaParada);
    }
    
    public void modificarLinea(DTLineaParada dtLineaParada, int hora, int minuto) {
    	LineaParada newLineaParada = new LineaParada(dtLineaParada);
    	dlpl.modificarHorario(newLineaParada, hora, minuto);
    }
    
    public void eliminarLineaParada(DTLineaParada dtLineaParada) {
    	LineaParada newLineaParada = new LineaParada(dtLineaParada);
    	dlpl.eliminarLineaParada(newLineaParada);
    }
    
    public List<DTLineaSimple> getLineasForParada(int idParada){
    	List<DTLineaSimple> listaLineas = dlpl.getLineasForParada(idParada);
    	return listaLineas;
    }
    
    public List<DTHorario> getHorariosLineaParada(int idParada, int idLinea){
    	return dlpl.getHorariosLineaParada(idParada, idLinea);
    }
    
    public boolean agregarHorario(int idparada, int idlinea, int hora, int minuto) {
    	boolean res= dlpl.agregarHorario(idparada, idlinea, hora, minuto);
    	return res;
    }
    
	public List<DTLineaSimple> getLineasNoAsociadasParada(int idParada){
		List<DTLineaSimple> listaLineas = dlpl.getLineasNoAsociadasParada(idParada);
    	return listaLineas;
	}
	
    public boolean borrarLineaParada(int idparada, int idlinea) {
    	boolean res= dlpl.borrarLineaParada(idparada, idlinea);
    	return res;
    }

	

    
}
