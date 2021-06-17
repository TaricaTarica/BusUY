package datos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import datatypes.DTLineaSimple;
import entities.LineaParada;

/**
 * Session Bean implementation class DatosLineaParada
 */
@Singleton
@LocalBean
public class DatosLineaParada implements DatosLineaParadaLocal {

	@PersistenceContext(name = "bubePersistenceUnit")
    private EntityManager em;
	
	@EJB
    DatosLineaLocal dll;
	
	@EJB
	DatosCompaniaLocal dcl;
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
    
	public List<DTLineaSimple> getLineasForParada(int idParada){
		Query q = em.createNativeQuery("SELECT lp.linea_gid FROM lineaparada lp WHERE lp.parada_gid = :idparada")
				.setParameter("idparada", idParada);
		List<Object> findLineas = q.getResultList();
		List<DTLineaSimple> listLineas = new ArrayList<DTLineaSimple>();
		for (Object o: findLineas){
			System.out.println("Entro");
			int gid = (int) o;
			DTLineaSimple lp = dll.buscarLinea(gid);
			lp.setNombre_compania(dcl.buscarCompania(lp.getId_compania()).getNombre());
			listLineas.add(lp);
		}
		return listLineas;
	}
	
}
