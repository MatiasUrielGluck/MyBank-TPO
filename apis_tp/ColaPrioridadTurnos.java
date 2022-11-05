package apis_tp;

public interface ColaPrioridadTurnos {
	public void inicializarCola();
	public void acolarPrioridad(Turno turno, int prioridad);
	public void desacolar();
	public Turno primero();
	public Boolean colaVacia();
}
