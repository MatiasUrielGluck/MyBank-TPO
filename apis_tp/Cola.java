package apis_tp;

public interface Cola {
	public void inicializar(String tipoPuesto);
	
	public void acolarPrioridad(Turno turno);
	
	public void desacolar();
	
	public Turno primero();
	
	public int devolverTiempoTotal();
	
	public Boolean colaVacia();
	
	public String getTipoPuesto();
	public void setTipoPuesto(String tipoPuesto);
}
