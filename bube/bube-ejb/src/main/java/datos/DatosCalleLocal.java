package datos;

import javax.ejb.Local;

@Local
public interface DatosCalleLocal {

	public String buscarCruceCalles(String calleA, String calleB);
	
}
