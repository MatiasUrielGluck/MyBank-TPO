package apis_tp;

public interface AdministradorColas {
	public void inicializar(int cantidadPuestos);
	
	public void agregarCola(String tipo, Turno turno);
	
	public int cantidadDeColas();
	
	public Cola devolverCola(int idCola);
	
	public int tiempoEstimadoCola(int idCola);
	
	public Cola puestoDelElemento(Turno turno);
}
