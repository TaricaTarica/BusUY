package datos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		List<LineaParada> findLineas = em.createQuery("SELECT lp FROM LineaPArada lp WHERE lp.parada.gid == :idparada", LineaParada.class)
				.setParameter("idparada", idParada).getResultList();
		List<DTLineaSimple> listLineas = new ArrayList<DTLineaSimple>();
		for (LineaParada lp: findLineas){
			DTLineaSimple dtLinea = new DTLineaSimple();
			dtLinea.setCodigo(lp.getLinea().getCodigo());
			dtLinea.setOrigen(lp.getLinea().getOrigen());
			dtLinea.setDestino(lp.getLinea().getDestino());
			dtLinea.setId_compania(lp.getLinea().getCompania().getId());
			listLineas.add(dtLinea);
		}
		return listLineas;
	}
	
}
