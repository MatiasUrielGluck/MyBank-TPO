package apis_tp;

public interface Cola {
	public void inicializar(int id, String nomenclatura);
	
	public int getId();
	
	public void acolarPrioridad(Turno turno);
	
	public void desacolar();
	
	public Turno primero();
	
	public int devolverTiempoTotal();
	
	public Boolean colaVacia();
	
	public String getNomenclatura();
	public void setNomenclatura(String nomenclatura);
	
	public int getCantidad();
}
