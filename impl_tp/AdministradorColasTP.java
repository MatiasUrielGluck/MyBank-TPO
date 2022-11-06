package impl_tp;

import apis_tp.AdministradorColas;
import apis_tp.Cola;
import apis_tp.Turno;

public class AdministradorColasTP implements AdministradorColas {

	private Cola[] colas;
	private int idCount;
	
	@Override
	public void inicializar(int cantidadPuestos) {
		colas = new Cola[cantidadPuestos];
		
		for (int i = 0; i < cantidadPuestos; i++) {
			Cola nuevaCola = new ColaTP();
			String nomenclatura = "X";
			if (i < 4) nomenclatura = indice2nomenclatura(i);
			nuevaCola.inicializar(i, nomenclatura);
			colas[i] = nuevaCola;
		}
		
		this.idCount = 1; // El valor que tomará el id del primer turno
	}

	@Override
	public void agregarCola(Turno turno) {
		// TODO
		// buscar la cola correspondiente al tipo
		String nomenclatura = turno.getNomenclatura();

		switch (nomenclatura) {
		case "C":
			
			break;
			
		case "P":
			
			break;
			
		case "J":
			
			break;
			
		case "SPF":
			
			break;
			
		case "SCH":
			
			break;
			
		case "SCG":
			
			break;
			
		default: break;
	}
		
		// agregar el id a la cola
		this.idCount++;
	}

	@Override
	public int cantidadDeColas() {
		return this.colas.length;
	}

	@Override
	public Cola devolverCola(int idCola) {
		return this.colas[idCola];
	}

	@Override
	public int tiempoEstimadoCola(int idCola) {
		return this.colas[idCola].devolverTiempoTotal();
	}

	@Override
	public Cola puestoDelElemento(Turno turno) {
		return this.colas[turno.getIdCola()];
	}

	@Override
	public Turno crearTurno(String nomenclatura) {
		Turno nuevoTurno = new TurnoTP();
		
		nuevoTurno.inicializar(nomenclatura, idCount);
		
		return nuevoTurno;
	}

	public String indice2nomenclatura(int i) {
		switch (i) {
			case 0: return "C";
			case 1: return "P";
			case 2: return "J";
			case 3: return "S";
	
			default: return null;
		}
	}
	
	public int nomenclatura2indice(String nomenclatura) {
		switch (nomenclatura) {
			case "C": return 0;
			case "P": return 1;
			case "J": return 2;
			case "S": return 3;
	
			default: return -1;
		}
	}
}
