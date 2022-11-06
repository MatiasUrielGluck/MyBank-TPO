package apis_tp;

public interface Turno {
	public void inicializar(String nomenclatura, int id);
	
	public String getNomenclatura();
	public void setNomenclatura(String nomenclatura);
	
	public int getId();
	public void setId(int id);
	
	public int getTiempoAtencion();
	public void setTiempoAtencion(int nuevoTiempo);
	public void setTiempoAtencion(String nomenclatura);
	
	public int nomenclatura2prioridad();
}
