package controladores;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
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
    
}
