package datos;

import java.util.List;

import javax.ejb.Local;

@Local
public interface DatosParadaCambioLocal {

	public List<String>  buscarParadaCambio();
	
}
