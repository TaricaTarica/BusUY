package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import datatypes.DTLineaParada;

@Entity
@IdClass(LineaParadaID.class)
public class LineaParada {

	@Id
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
	private Parada parada;
	@Id
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
	private Linea linea;

	@Id
	private int hora;
	
	@Id
	private int minuto;
	
	private boolean habilitada;
	
	public LineaParada() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LineaParada(Parada parada, Linea linea, int hora, int minuto, boolean habilitada) {
		super();
		this.parada = parada;
		this.linea = linea;
		this.hora = hora;
		this.minuto = minuto;
		this.habilitada = habilitada;
	}
	
	public LineaParada (DTLineaParada dtLineaParada){
		this.parada = new Parada(dtLineaParada.getParada());
		this.linea = new Linea(dtLineaParada.getLinea());
		this.hora = dtLineaParada.getHora();
		this.minuto = dtLineaParada.getMinuto();
		this.habilitada = dtLineaParada.isHabilitada();
	}

	public Parada getParada() {
		return parada;
	}

	public void setParada(Parada parada) {
		this.parada = parada;
	}

	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
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
