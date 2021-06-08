package datos;

import java.util.List;

import javax.ejb.Local;

import entities.Linea;

@Local
public interface DatosLineaLocal {
	
	public void altaLinea(Linea linea);
	
	public void modificarLinea(Linea linea);
	
	public void eliminarLinea(Linea linea);
	
	public Linea buscarLinea(int gid);
	
	public List<Linea> listarLineas();
	
	List<Linea> listarLineaCompania(int id);
}
