package impl_tp;

import apis_tp.Turno;

public class TurnoTP implements Turno {

	private String nomenclatura;
	private int id;
	private int tiempoAtencion;
	private int idCola; // Cola a la que el turno está asociado
	
	@Override
	public void inicializar(String nomenclatura, int id) {
		this.nomenclatura = nomenclatura;
		this.id = id;	
		setTiempoAtencion(nomenclatura);
		this.idCola = -1;
	}

	@Override
	public void setIdCola(int id) {
		this.idCola = id;
	}
	
	@Override
	public int getIdCola() {
		return this.idCola;
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
	public int getId() {
		return this.id;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int getTiempoAtencion() {
		return this.tiempoAtencion;
	}

	@Override
	public void setTiempoAtencion(int nuevoTiempo) {
		this.tiempoAtencion = nuevoTiempo;		
	}
	
	@Override
	public void setTiempoAtencion(String nomenclatura) {
		switch (nomenclatura) {
			case "C":
				setTiempoAtencion(40);
				break;
				
			case "P":
				setTiempoAtencion(10);
				break;
				
			case "J":
				setTiempoAtencion(30);
				break;
				
			case "SPF":
				setTiempoAtencion(10);
				break;
				
			case "SCH":
				setTiempoAtencion(40);
				break;
				
			case "SCG":
				setTiempoAtencion(15);
				break;
				
			default: break;
		}
	}

	@Override
	public int nomenclatura2prioridad() {
		// Si es servicio
		if (this.nomenclatura.length() > 1) {
			// Prioridad por servicio
			if (this.nomenclatura.substring(1, 3).equals("PF")) {
				return 3;
			} else if (this.nomenclatura.substring(1, 3).equals("CH")) {
				return 2;
			} else {
				return 1;
			}
		// Si no es servicio la prioridad es siempre 1
		} else {
			return 1;
		}
	}
}
