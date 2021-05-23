package entities;

import java.io.Serializable;

public class LineaParadaID implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int parada;
	private int linea;
	
	public LineaParadaID() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getParada() {
		return parada;
	}
	
	public void setParada(int parada) {
		this.parada = parada;
	}
	
	public int getLinea() {
		return linea;
	}
	
	public void setLinea(int linea) {
		this.linea = linea;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + linea;
		result = prime * result + parada;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineaParadaID other = (LineaParadaID) obj;
		if (linea != other.linea)
			return false;
		if (parada != other.parada)
			return false;
		return true;
	}
	
	
}
