package datos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.google.gson.Gson;

/**
 * Session Bean implementation class DatosCalle
 */
@Stateless
@LocalBean
public class DatosCalle implements DatosCalleLocal {

	@PersistenceContext(name = "bubePersistenceUnit")
    private EntityManager em;
    
    public DatosCalle() {
        // TODO Auto-generated constructor stub
    }
    
    public String buscarCruceCalles(String calleA, String calleB) {
    	Query q = em.createNativeQuery("select ST_AsGeoJSON (ST_Intersection("
    			+ "(select st_union(geom) "
    			+ "from ejes e "
    			+ "where e.nom_calle LIKE :calleA) "
    			+ ", "
    			+ "(select st_union(geom) "
    			+ "from ejes e1 "
    			+ "where e1.nom_calle LIKE :calleB) "
    			+ "));");
    	
    	q.setParameter("calleA", "%" + calleA + "%").setParameter("calleB", "%" + calleB + "%");
    	
    	System.out.println(q);
    	String retorno = (String)  q.getSingleResult();
    	System.out.println(retorno);
    	String json = new Gson().toJson(retorno);
    	return json;
    }

}
