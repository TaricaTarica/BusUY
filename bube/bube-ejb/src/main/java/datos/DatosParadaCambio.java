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
public class DatosParadaCambio implements DatosParadaCambioLocal {

	@PersistenceContext(name = "bubePersistenceUnit")
    private EntityManager em;
    
    public DatosParadaCambio() {
        // TODO Auto-generated constructor stub
    }
    
    public List<String> buscarParadaCambio() {
    	Query q = em.createNativeQuery("select p.nombre"
    			+ "from parada p"
    			+ "inner join lineaparada lp on lp.parada_gid = p.gid"
    			+ "inner join linea l on lp.linea_gid = l.gid"
    			+ "where estado = 'habilitada'"
    			+ "and l.desvio = true"
    			+ "and p.fechamod >= CURRENT_DATE + INTERVAL '-1 day' "
    			+ ";");
    	   	
    	List<Object> ParadaCambio = q.getResultList();
    	List<String> listaParadaCambio = new ArrayList<String>();
    	
    	for (Object o: ParadaCambio){
			String  nombre = (String) o;
			
	    	System.out.println(nombre);
	    	
			listaParadaCambio.add(nombre);
		}
    	
    	return listaParadaCambio;
    }
    
}
