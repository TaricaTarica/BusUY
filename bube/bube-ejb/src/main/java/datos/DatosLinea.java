package datos;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Linea;

/**
 * Session Bean implementation class DatosLinea
 */
@Singleton
@LocalBean
public class DatosLinea implements DatosLineaLocal {

	@PersistenceContext(name = "bubePersistenceUnit")
    private EntityManager em;
	
    public DatosLinea() {
        // TODO Auto-generated constructor stub
    }
    
    public void altaLinea(Linea linea) {
    	em.persist(linea);
    }
    
    public void modificarLinea(Linea linea) {
    	Linea toUpdate = em.find(Linea.class, linea.getGid());
    	toUpdate.setCodigo(linea.getCodigo());
    	toUpdate.setOrigen(linea.getOrigen());
    	toUpdate.setDestino(linea.getDestino());
    	toUpdate.setGeom(linea.getGeom());
    }
    
    public void eliminarLinea(Linea linea) {
    	em.remove(linea);
    }
    
    public Linea buscarLinea(int gid) {
    	return em.find(Linea.class, gid);
    }


}
