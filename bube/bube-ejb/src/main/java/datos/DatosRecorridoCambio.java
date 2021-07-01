package datos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    public List<String> buscarRecorridoCambio() {
    	Query q = em.createNativeQuery("select codigo "
    			+ "from linea "
    			+ "where desvio = true "
    			+ "and fechamod >= CURRENT_DATE + INTERVAL '-1 day' "
    			+ ";");
    	
    	System.out.println(q);
    	
    	List<Object> ParadaCambio = q.getResultList();
    	List<String> listaRecorridoCambio = new ArrayList<String>();
    	
    	for (Object o: ParadaCambio){
			String codigo = (String) o;
			listaRecorridoCambio.add(codigo);
		}
    	
    	return listaRecorridoCambio;
    }
    
}
