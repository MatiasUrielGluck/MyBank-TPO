package apis_tp;

public interface Turno {
	public void inicializar(String nomenclatura, int id, int idCola, int tiempoAtencion);
	
	public String getNomenclatura();
	public int getId();
	public int getColaId();
	public int getTiempoAtencion();
	
	public void setTiempoAtencion(int nuevoTiempo);
}
