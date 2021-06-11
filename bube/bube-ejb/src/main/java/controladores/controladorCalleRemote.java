package controladores;

import javax.ejb.Remote;

@Remote
public interface controladorCalleRemote {

	public String buscarCruceCalles(String calleA, String calleB);
	
}
