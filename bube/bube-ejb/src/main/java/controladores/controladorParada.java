package controladores;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datatypes.DTParada;
import datos.DatosParadaLocal;
import entities.Parada;

/**
 * Session Bean implementation class controladorParada
 */
@Stateless
@LocalBean
public class controladorParada implements controladorParadaRemote {

    @EJB
    DatosParadaLocal dpl;
    public controladorParada() {
        // TODO Auto-generated constructor stub
    }
    
    public void altaParada(DTParada parada) {
    	Parada newParada = new Parada(parada);
    	dpl.altaParada(newParada);
    }
    
    public void modificarParada(DTParada parada) {
    	Parada newParada = new Parada(parada);
    	dpl.modificarParada(newParada);
    }
    
    public void eliminarParada(DTParada parada) {
    	Parada newParada = new Parada(parada);
    	dpl.eliminarParada(newParada);
    }
    
    public DTParada buscarParda(int gid) {
    	Parada parada = dpl.buscarParada(gid);
    	if(parada != null) {
    		DTParada dtParada = new DTParada(parada);
    		return dtParada;
    	}
    	else {
    		return null;
    	}
    }

}
