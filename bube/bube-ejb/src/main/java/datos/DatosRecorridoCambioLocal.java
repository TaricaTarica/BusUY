package datos;

import java.util.List;

import javax.ejb.Local;

@Local
public interface DatosRecorridoCambioLocal {

	public List<String>  buscarRecorridoCambio();
	
}
