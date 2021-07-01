package datos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import datatypes.DTLineaSimple;
import entities.Linea;
import java.sql.Date;

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
    	em.refresh(toUpdate);
    }
    
    public void eliminarLinea(Linea linea) {
    	em.remove(linea);
    }
    
    public DTLineaSimple buscarLinea(int gid) {
    	Query q= em.createNativeQuery("SELECT l.gid, l.codigo, l.origen, l.destino, l.desvio, l.fechamod, l.compania_id"
    			+ " FROM Linea l WHERE l.gid = :gid").setParameter("gid", gid);
    	Object[] o =  (Object[]) q.getSingleResult();
    	int id = (int) o[0];
		String codigo = (String) o[1];
		String origen = (String) o[2];
		String destino = (String) o[3];
		boolean desvio = (boolean) o[4];
		LocalDate fechamod = ((Date) o[5]).toLocalDate();
		int id_compania = (int) o[6];
    	return new DTLineaSimple(id,codigo, origen, destino, desvio, fechamod,id_compania);
    }
    
    public List<DTLineaSimple> listarLineas(){
    	List <DTLineaSimple> lista = new ArrayList <DTLineaSimple>();
    	Query q = em.createNativeQuery("SELECT l.gid, l.codigo, l.origen, l.destino, l.desvio, l.fechamod, l.compania_id"
    			+ " FROM Linea l");
    	List<Object[]> lineas =  q.getResultList();
		for (Object[] o: lineas) {
			int gid = (int) o[0];
			String codigo = (String) o[1];
			String origen = (String) o[2];
			String destino = (String) o[3];
			boolean desvio = (boolean) o[4];
			LocalDate fechamod = ((Date) o[5]).toLocalDate();
			int id_compania = (int) o[6];
			lista.add(new DTLineaSimple(gid,codigo, origen, destino, desvio, fechamod,id_compania));
			System.out.println(o[2]);
		}
    	return lista;
    }
    
    public List<DTLineaSimple> listarLineaCompania(int id){
    	List<DTLineaSimple> lineas = listarLineas();
    	List<DTLineaSimple> retorno = new ArrayList<>();
    	if(!lineas.isEmpty()) {
    		for(DTLineaSimple l: lineas) {
        		if(l.getId_compania() == id) {
        			retorno.add(l);
        		}
        	}
    	}
    	return retorno;
    }
    
    @Override
    public void modificarRecorridoLinea(String geomCoordenadas, int gidLinea) {
    	    	
    	String value = "LINESTRING(" + geomCoordenadas  +")";
    	
    	String fechamod = LocalDate.now().toString();
    	
    	System.out.println(fechamod);
    	
    	Query q = em.createNativeQuery("UPDATE linea SET geom = ST_GeomFromText(:value , 32721), fechamod = CAST ( :fechamod AS DATE ), desvio = true WHERE gid = :gid");
    	
    	q.setParameter("value", value).setParameter("gid", gidLinea).setParameter("fechamod", fechamod).executeUpdate();
 
    	
    }
    
    @Override
    public void modificarParada(String geomCoordenadas, int gidParada) {
    	    	
    	String value = "POINT(" + geomCoordenadas  +")";
    	
    	String fechamod = LocalDate.now().toString();
    	
    	System.out.println(fechamod);
    	
    	Query q = em.createNativeQuery("UPDATE parada SET geom = ST_GeomFromText(:value , 32721), fechamod = CAST ( :fechamod AS DATE ) WHERE gid = :gid");
    	
    	q.setParameter("value", value).setParameter("gid", gidParada).setParameter("fechamod", fechamod).executeUpdate();
 
    	
    }


}
