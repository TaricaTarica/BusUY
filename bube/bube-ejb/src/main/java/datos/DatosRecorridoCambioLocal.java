package datos;

import java.util.List;

import javax.ejb.Local;

@Local
public interface DatosRecorridoCambioLocal {

	public List<Integer>  buscarRecorridoCambio();
	
}
