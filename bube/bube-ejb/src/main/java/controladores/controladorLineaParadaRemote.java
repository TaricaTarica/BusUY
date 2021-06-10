package controladores;

import javax.ejb.Remote;
import datatypes.DTLineaParada;

@Remote
public interface controladorLineaParadaRemote {
	
	public void altaLineaParada(DTLineaParada dtLineaParada);
	
	public void modificarLinea(DTLineaParada dtLineaParada, int hora, int minuto);
	
	public void eliminarLineaParada(DTLineaParada dtLineaParada);

}
