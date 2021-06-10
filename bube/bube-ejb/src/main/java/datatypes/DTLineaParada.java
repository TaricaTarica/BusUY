package datatypes;

import java.io.Serializable;
import entities.LineaParada;


public class DTLineaParada implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private DTParada parada;
	private DTLinea linea;
	private int hora;
	private int minuto;
	private boolean habilitada;
	
	public DTLineaParada(DTParada dtParada, DTLinea dtLinea, int hora, int minuto, boolean habilitada) {
		super();
		this.parada = dtParada;
		this.linea = dtLinea;
		this.hora = hora;
		this.minuto = minuto;
		this.habilitada = habilitada;
	}
	
	public DTLineaParada(LineaParada lineaParada) {
		this.parada = new DTParada (lineaParada.getParada());
		this.linea = new DTLinea (lineaParada.getLinea());
		this.hora = lineaParada.getHora();
		this.minuto = lineaParada.getMinuto();
		this.habilitada = lineaParada.isHabilitada();
	}

	public DTParada getParada() {
		return parada;
	}

	public void setParada(DTParada dtParada) {
		this.parada = dtParada;
	}

	public DTLinea getLinea() {
		return linea;
	}

	public void setLinea(DTLinea dtLinea) {
		this.linea = dtLinea;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public boolean isHabilitada() {
		return habilitada;
	}

	public void setHabilitada(boolean habilitada) {
		this.habilitada = habilitada;
	}
	
}
