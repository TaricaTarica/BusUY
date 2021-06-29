package datos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.google.gson.Gson;

import datatypes.DTLineaSimple;

/**
 * Session Bean implementation class DatosCalle
 */
@Stateless
@LocalBean
public class DatosRecorridoCambio implements DatosRecorridoCambioLocal {

	@PersistenceContext(name = "bubePersistenceUnit")
    private EntityManager em;
    
    public DatosRecorridoCambio() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Integer> buscarRecorridoCambio() {
    	Query q = em.createNativeQuery("select codigo"
    			+ "from linea"
    			+ "where desvio = true"
    			+ "and fechamod >= CURRENT_DATE + INTERVAL '-1 day' "
    			+ ";");
    	
    	System.out.println(q);
    	
    	List<Object> ParadaCambio = q.getResultList();
    	List<Integer> listaRecorridoCambio = new ArrayList<Integer>();
    	
    	for (Object o: ParadaCambio){
			int gid = (int) o;
			listaRecorridoCambio.add(gid);
		}
    	
    	return listaRecorridoCambio;
    }
    
}
