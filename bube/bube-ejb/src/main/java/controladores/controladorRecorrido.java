package controladores;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datatypes.DTRecorrido;
import datos.DatosRecorridoLocal;
import entities.Recorrido;


@Stateless
@LocalBean
public class controladorRecorrido implements controladorRecorridoRemote {

	@EJB
	DatosRecorridoLocal drl;
	
    public controladorRecorrido() {
        // TODO Auto-generated constructor stub
    }
    
    public void altaRecorrido(DTRecorrido recorrido) {
    	Recorrido newRecorrido = new Recorrido(recorrido);
    	drl.altaRecorrido(newRecorrido);
    }
    
    public void modificarRecorrido(DTRecorrido recorrido) {
    	Recorrido newRecorrido = new Recorrido(recorrido);
    	drl.modificarRecorrido(newRecorrido);
    }
    
    public void eliminarRecorrido(DTRecorrido recorrido) {
    	Recorrido newRecorrido = new Recorrido(recorrido);
    	drl.eliminarRecorrido(newRecorrido);
    }
    
    public DTRecorrido buscarrRecorrido(long codigo) {
    	Recorrido recorrido = drl.buscarRecorrido(codigo);
    	if(recorrido != null) {
    		DTRecorrido dtRecorrido = new DTRecorrido(recorrido);
    		return dtRecorrido;
    	}
    	else {
    		return null;
    	}
    }
    

}
