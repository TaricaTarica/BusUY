package datos;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Recorrido;

/**
 * Session Bean implementation class DatosRecorrido
 */
@Singleton
@LocalBean
public class DatosRecorrido implements DatosRecorridoLocal {

	@PersistenceContext(name = "bubePersistenceUnit")
	private EntityManager em;

    public DatosRecorrido() {
        // TODO Auto-generated constructor stub
    }
    
    public void altaRecorrido(Recorrido recorrido) {
    	em.persist(recorrido);
    	
    }
    
    public void modificarRecorrido(Recorrido recorrido) {
    	Recorrido toUpdate = em.find(Recorrido.class, recorrido.getCodigo());
    	toUpdate.setNombre(recorrido.getNombre());
    	toUpdate.setDesvio(recorrido.getDesvio());
    	toUpdate.setFechaMod(recorrido.getFechaMod());
    	toUpdate.setGeom(recorrido.getGeom());
    	em.refresh(toUpdate);
    }

    public void eliminarRecorrido(Recorrido recorrido) {
    	em.remove(recorrido);
    }
    public Recorrido buscarRecorrido(long codigo) {
    	return em.find(Recorrido.class, codigo);
    }
}
