package impl_tp;

import apis_tp.Cola;
import apis_tp.Turno;
import helpers.Debug;
import apis_tp.ColaPrioridadTurnos;
import impl_tp.ColaPrioridadTurnosTP;

public class ColaTP implements Cola {

	private int id;
	private int tiempoTotal;
	private ColaPrioridadTurnos colaPrioridad;
	private String nomenclatura;
	
	@Override
	public void inicializar(int id, String nomenclatura) {
		this.tiempoTotal = 0;
		
		this.colaPrioridad = new ColaPrioridadTurnosTP();
		this.colaPrioridad.inicializarCola();
		
		this.nomenclatura = nomenclatura;
	}

	@Override
	public int getId() {
		return this.id;
	}
	
	@Override
	public void acolarPrioridad(Turno turno) {
		// Tratamiento especial por ser cola general
		if (this.nomenclatura == "X") {
			this.colaPrioridad.acolarPrioridad(turno, colaXnomenclatura2prioridad(turno.getNomenclatura()));
			this.tiempoTotal += turno.getTiempoAtencion();
			return;
		}
		
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
	public String getNomenclatura() {
		return this.nomenclatura;
	}

	@Override
	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}

	@Override
	public int getCantidad() {
		return this.colaPrioridad.getCantidad();
	}

	public int colaXnomenclatura2prioridad(String nomenclatura) {
		if (nomenclatura.equals("J")) return 6;
		else if (nomenclatura.length() > 1) {
			// Prioridad por servicio
			if (nomenclatura.substring(1, 3).equals("PF")) {
				return 5;
			} else if (nomenclatura.substring(1, 3).equals("CH")) {
				return 4;
			} else {
				return 3;
			}
		} else if (nomenclatura.equals("C")) return 2;
		else return 1;
	}
}
