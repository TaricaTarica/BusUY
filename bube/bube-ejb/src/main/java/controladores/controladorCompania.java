package controladores;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datatypes.DTCompania;
import datos.DatosCompaniaLocal;
import entities.Compania;

/**
 * Session Bean implementation class controladorCompania
 */
@Stateless
@LocalBean
public class controladorCompania implements controladorCompaniaRemote {

    @EJB
    DatosCompaniaLocal dcl;
    
    public controladorCompania() {
        // TODO Auto-generated constructor stub
    }
    
    public void altaCompania(DTCompania compania) {
    	Compania newCompania = new Compania(compania);
    	dcl.altaCompania(newCompania);
    }
    
    public void modificarCompania(DTCompania compania) {
    	Compania newCompania = new Compania(compania);
    	dcl.modificarCompania(newCompania);
    }
    
    public void eliminarCompania(DTCompania compania) {
    	Compania newCompania = new Compania(compania);
    	dcl.eliminarCompania(newCompania);
    }
    
    public DTCompania buscarCompania(int id) {
    	Compania compania = dcl.buscarCompania(id);
    	if(compania != null) {
    		DTCompania dtCompania = new DTCompania(compania);
    		return dtCompania;
    	}
    	else {
    		return null;
    	}
    }

}
