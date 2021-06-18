package datatypes;

import java.io.Serializable;

public class DTHorario implements Serializable{

	private static final long serialVersionUID = 1L;
	private int hora;
	private int min;
	
	//********* CONSTRUCTORS **************
	
	
	public DTHorario() {
		super();
	}

	public DTHorario(int hora, int min) {
		super();
		this.hora = hora;
		this.min = min;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	
}
