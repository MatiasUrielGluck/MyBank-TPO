package impl_tp;

import apis_tp.Turno;

public class TurnoTP implements Turno {

	private String nomenclatura;
	private int id;
	private int idCola;
	private int tiempoAtencion;
	
	@Override
	public void inicializar(String nomenclatura, int id, int idCola, int tiempoAtencion) {
		this.nomenclatura = nomenclatura;
		this.id = id;
		this.idCola = idCola;
		this.tiempoAtencion = tiempoAtencion;
	}

	@Override
	public String getNomenclatura() {
		return this.nomenclatura;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public int getColaId() {
		return this.idCola;
	}

	@Override
	public int getTiempoAtencion() {
		return this.tiempoAtencion;
	}

	@Override
	public void setTiempoAtencion(int nuevoTiempo) {
		this.tiempoAtencion = nuevoTiempo;		
	}

}
