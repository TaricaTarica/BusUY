package datos;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.LineaParada;

/**
 * Session Bean implementation class DatosLineaParada
 */
@Singleton
@LocalBean
public class DatosLineaParada implements DatosLineaParadaLocal {

	@PersistenceContext(name = "bubePersistenceUnit")
    private EntityManager em;
    /**
     * Default constructor. 
     */
    public DatosLineaParada() {
        // TODO Auto-generated constructor stub
    }
    
	public void altaLineaParada(LineaParada lineaParada) {
		em.persist(lineaParada);
	}
	
	public void modificarHorario(LineaParada lineaParada, int hora, int minuto) {
		LineaParada toUpdate = em.createQuery("SELECT lp FROM LineaParada lp WHERE lp.hora == :hora AND "
				+ "lp.minuto == :minuto AND lp.linea == :linea AND lp.parada == :parada", LineaParada.class)
				.setParameter("hora", lineaParada.getHora())
				.setParameter("minuto", lineaParada.getMinuto())
				.setParameter("linea", lineaParada.getLinea())
				.setParameter("parada", lineaParada.getParada()).getSingleResult();
		toUpdate.setHora(hora);
		toUpdate.setMinuto(minuto);
		em.refresh(toUpdate);
	}
	
	public void eliminarLineaParada(LineaParada lineaParada) {
		em.remove(lineaParada);
	}
    

}
