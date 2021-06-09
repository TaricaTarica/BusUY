package datatypes;

import java.io.Serializable;
import java.time.LocalDate;

public class DTLineaSimple implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int gid;
	private String codigo;
	private String origen;
	private String destino;

	private Boolean desvio;
	private LocalDate fechaMod;
	private int id_compania;
	public DTLineaSimple() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DTLineaSimple(int gid, String codigo, String origen, String destino, Boolean desvio, LocalDate fechaMod,
			int id_compania) {
		super();
		this.gid = gid;
		this.codigo = codigo;
		this.origen = origen;
		this.destino = destino;
		this.desvio = desvio;
		this.fechaMod = fechaMod;
		this.id_compania = id_compania;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Boolean getDesvio() {
		return desvio;
	}
	public void setDesvio(Boolean desvio) {
		this.desvio = desvio;
	}
	public LocalDate getFechaMod() {
		return fechaMod;
	}
	public void setFechaMod(LocalDate fechaMod) {
		this.fechaMod = fechaMod;
	}
	public int getId_compania() {
		return id_compania;
	}
	public void setId_compania(int id_compania) {
		this.id_compania = id_compania;
	}
	
}
