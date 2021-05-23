package datos;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Parada;

/**
 * Session Bean implementation class DatosParada
 */
@Singleton
@LocalBean
public class DatosParada implements DatosParadaLocal {

	/**
	 * Default constructor.
	 */
	public DatosParada() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(name = "bubePersistenceUnit")
	private EntityManager em;

	public void altaParada(Parada parada) {
		em.persist(parada);
	}

	public void modificarParada(Parada parada) {
		Parada toUpdate = em.find(Parada.class, parada.getGid());
		toUpdate.setNombre(parada.getNombre());
		toUpdate.setUbicacion(parada.getUbicacion());
		toUpdate.setX(parada.getX());
		toUpdate.setY(parada.getY());
		toUpdate.setGeom(parada.getGeom());
		toUpdate.setHora(parada.getHora());
		toUpdate.setMin(parada.getMin());
		toUpdate.setEstado(parada.getEstado());
		em.refresh(toUpdate);
	}

	public void eliminarParada(Parada parada) {
		em.remove(parada);
	}

	public Parada buscarParada(int gid) {
		return em.find(Parada.class, gid);
	}
    
}
