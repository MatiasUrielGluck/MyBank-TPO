package Ejecucion;

import apis_tp.AdministradorColas;
import apis_tp.Cola;
import apis_tp.Turno;
import helpers.Debug;
import impl_tp.AdministradorColasTP;

public class Principal {

	public static void debugTests(AdministradorColas adminColas) {
		Turno turnoC = adminColas.crearTurno("C");
		Turno turnoP = adminColas.crearTurno("P");
		Turno turnoJ = adminColas.crearTurno("J");
		Turno turnoSPF = adminColas.crearTurno("SPF");
		Turno turnoSCH = adminColas.crearTurno("SCH");
		Turno turnoSCG = adminColas.crearTurno("SCG");
		
		adminColas.agregarCola(turnoC);
		Turno turnoC2 = adminColas.crearTurno("C");
		adminColas.agregarCola(turnoC2);
		
		Cola colaDeC = adminColas.puestoDelElemento(turnoC);

		adminColas.desacolarColar("C");
		
		Debug.imprimir(colaDeC.devolverTiempoTotal());
	}
	
	public static void main(String[] args) {
		System.out.println("*-*-*-* MyBank *-*-*-*");
		AdministradorColas adminColas = new AdministradorColasTP();
		adminColas.inicializar(6);
		
		// DEBUG TESTS
		debugTests(adminColas);
	}

}
