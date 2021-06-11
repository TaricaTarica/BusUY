package controladores;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datos.DatosCalleLocal;

/**
 * Session Bean implementation class controladorCalle
 */
@Stateless
@LocalBean
public class controladorCalle implements controladorCalleRemote {

	@EJB
	DatosCalleLocal dcl;
	
    public controladorCalle() {
        // TODO Auto-generated constructor stub
    }
    
    public String buscarCruceCalles(String calleA, String calleB){
    	return dcl.buscarCruceCalles(calleA, calleB);
    }

}
