package controladores;

import java.util.ArrayList;
import java.util.List;

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
    
    public List<DTLinea> listarLineaCompania(int id){
    	List<Linea> lineas = dll.listarLineaCompania(id);
    	List<DTLinea> retorno = new ArrayList<>();
    	if(!lineas.isEmpty()) {
    		for(Linea l: lineas) {
    			retorno.add(new DTLinea(l));
    		}
    	}
    	return retorno;
    }

}
