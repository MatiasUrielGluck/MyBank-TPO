package impl_tp;

import apis_tp.Cola;
import apis_tp.Turno;
import apis_tp.ColaPrioridadTurnos;
import impl_tp.ColaPrioridadTurnosTP;

public class ColaTP implements Cola {

	private int tiempoTotal;
	private ColaPrioridadTurnos colaPrioridad;
	private String tipoPuesto;
	
	@Override
	public void inicializar(String tipoPuesto) {
		this.tiempoTotal = 0;
		
		this.colaPrioridad = new ColaPrioridadTurnosTP();
		this.colaPrioridad.inicializarCola();
		
		this.tipoPuesto = tipoPuesto;
	}

	@Override
	public void acolarPrioridad(Turno turno) {
		this.colaPrioridad.acolarPrioridad(turno, turno.nomenclatura2prioridad());
		this.tiempoTotal += turno.getTiempoAtencion();
	}

	@Override
	public void desacolar() {
		Turno turno = this.colaPrioridad.primero();
		this.colaPrioridad.desacolar();
		this.tiempoTotal -= turno.getTiempoAtencion();
	}

	@Override
	public Turno primero() {
		return this.colaPrioridad.primero();
	}

	@Override
	public int devolverTiempoTotal() {
		return this.tiempoTotal;
	}

	@Override
	public Boolean colaVacia() {
		return this.colaPrioridad.colaVacia();
	}

	@Override
	public String getTipoPuesto() {
		return this.tipoPuesto;
	}

	@Override
	public void setTipoPuesto(String tipoPuesto) {
		this.tipoPuesto = tipoPuesto;
	}

}
