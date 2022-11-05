package impl_tp;

import apis_tp.Turno;

public class TurnoTP implements Turno {

	private String nomenclatura;
	private int id;
	private int idCola;
	private int tiempoAtencion;
	
	@Override
	public void inicializar(String nomenclatura, int id, int tiempoAtencion) {
		this.nomenclatura = nomenclatura;
		this.id = id;
		this.tiempoAtencion = tiempoAtencion;
		
	}

}
