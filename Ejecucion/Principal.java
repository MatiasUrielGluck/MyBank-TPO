package Ejecucion;

import apis_tp.AdministradorColas;
import apis_tp.Cola;
import apis_tp.Turno;
import impl_tp.AdministradorColasTP;

public class Principal {

	public static void debugTests(AdministradorColas adminColas) {
		Turno turno = adminColas.crearTurno("SPF");
		
	}
	
	public static void main(String[] args) {
		System.out.println("*-*-*-* MyBank *-*-*-*");
		AdministradorColas adminColas = new AdministradorColasTP();
		adminColas.inicializar(6);
		
		// DEBUG TESTS
		debugTests(adminColas);
	}

}
