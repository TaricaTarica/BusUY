package controladores;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datatypes.DTLinea;
import datos.DatosLineaLocal;
import entities.Linea;


@Stateless
@LocalBean
public class controladorLinea implements controladorLineaRemote {

    @EJB
    DatosLineaLocal dll;
	
    public controladorLinea() {
        // TODO Auto-generated constructor stub
    }
    
    public void altaLinea(DTLinea linea) {
    	Linea newLinea = new Linea(linea);
    	dll.altaLinea(newLinea);
    }
    
    public void modificarLinea(DTLinea linea) {
    	Linea newLinea = new Linea(linea);
    	dll.modificarLinea(newLinea);
    }
    
    public void eliminarLinea(DTLinea linea) {
    	Linea newLinea = new Linea(linea);
    	dll.altaLinea(newLinea);
    }
    
    public DTLinea buscarLinea(int gid) {
    	Linea linea = dll.buscarLinea(gid);
    	if(linea != null) {
    		DTLinea dtLinea = new DTLinea(linea);
    		return dtLinea;
    	}
    	else {
    		return null;
    	}
    }

}
