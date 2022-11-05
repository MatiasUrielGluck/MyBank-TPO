package impl_tp;

import apis_tp.Cola;
import apis_tp.Turno;
import impl.ColaPrioridadAO;

public class ColaTP implements Cola {

	private int tiempoTotal;
	private ColaPrioridadAO colaPrioridad;
	private String tipoPuesto;
	
	@Override
	public void inicializar(String tipoPuesto) {
		this.tiempoTotal = 0;
		this.colaPrioridad = new ColaPrioridadAO();
		this.tipoPuesto = tipoPuesto;
	}

	@Override
	public void acolarPrioridad(Turno turno) {
		
	}

	@Override
	public void desacolar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Turno primero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int devolverTiempoTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Boolean colaVacia() {
		// TODO Auto-generated method stub
		return null;
	}

}
