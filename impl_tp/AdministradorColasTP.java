package impl_tp;

import apis_tp.AdministradorColas;
import apis_tp.Cola;
import apis_tp.Turno;

public class AdministradorColasTP implements AdministradorColas {

	private Cola[] colas;
	private int cantidadPuestos;
	private int idCount;
	
	@Override
	public void inicializar(int cantidadPuestos) {
		this.cantidadPuestos = cantidadPuestos;
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
		if (turno.getIdCola() != -1) return; // El turno ya se encuentra en alguna cola
		
		String nomenclatura = turno.getNomenclatura();
		
		// Buscar la cola correspondiente a la nomenclatura
		// Si la cola no tiene espacio buscar una cola general
		
		int indiceCola = nomenclatura2indice(nomenclatura);
		int contador = indiceCola; // Posición de arranque de las colas generales
		
		if (this.colas[indiceCola].getCantidad() >= 7) {
			// La cola está llena, buscar lugar en alguna cola general
			if (this.colas.length == 4) return; // No se pudo agregar
			contador = 4;
			while (contador < this.colas.length) {
				if (this.colas[contador].getCantidad() < 7) {
					//  Se encontró lugar
					break;
				}
				
				if (contador == this.colas.length - 1) {
					// No se pudo agregar
					return;
				}
				contador++;
			}
		}
		
		this.colas[contador].acolarPrioridad(turno);
		// Asignar idCola al turno
		turno.setIdCola(contador);
		// agregar el id a la cola
		this.idCount++;
	}

	@Override
	public void desacolarCola(String nomenclatura) {
		this.colas[nomenclatura2indice(nomenclatura)].desacolar();
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
	
	@Override
	public int getTiempoTotal() {
		int tiempoTotal = 0;
		
		for (int i = 0; i < this.cantidadPuestos; i++) {
			tiempoTotal += this.tiempoEstimadoCola(i);
		}
		
		return tiempoTotal;
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
			case "C":
				return 0;
				
			case "P":
				return 1;
				
			case "J":
				return 2;
				
			case "SPF":
				return 3;
				
			case "SCH":
				return 3;
				
			case "SCG":
				return 3;
				
			case "S":
				return 3;
				
			default: return -1;
		}
	}
	
}
