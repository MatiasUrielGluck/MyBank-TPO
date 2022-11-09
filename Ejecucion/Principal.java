package Ejecucion;

import java.util.Scanner;
import apis_tp.AdministradorColas;
import apis_tp.Cola;
import apis_tp.Turno;
import helpers.Debug;
import helpers.Utils;
import impl_tp.AdministradorColasTP;

public class Principal {
	
	static int cantidadPuestos = 6;
	static AdministradorColas adminColas;
	
	public static void testCarga() {
		// Llenar cola de clientes
		for (int i = 0; i < 7; i++) {
			Turno turno = adminColas.crearTurno("C");
			adminColas.agregarCola(turno);
		}
		
		// Llenar cola de no clientes
		for (int i = 0; i < 7; i++) {
			Turno turno = adminColas.crearTurno("P");
			adminColas.agregarCola(turno);
		}
		
		// Llenar cola de jubilados
		for (int i = 0; i < 7; i++) {
			Turno turno = adminColas.crearTurno("J");
			adminColas.agregarCola(turno);
		}
		
		// Llenar cola de servicios
		for (int i = 0; i < 2; i++) {
			Turno turno = adminColas.crearTurno("SPF");
			adminColas.agregarCola(turno);
		}
		
		// Llenar cola de servicios
		for (int i = 0; i < 3; i++) {
			Turno turno = adminColas.crearTurno("SCH");
			adminColas.agregarCola(turno);
		}
		
		// Llenar cola de servicios
		for (int i = 0; i < 2; i++) {
			Turno turno = adminColas.crearTurno("SCG");
			adminColas.agregarCola(turno);
		}
		
		// Llenar colas generales
		for (int i = 0; i < 7; i++) {
			Turno turno = adminColas.crearTurno("P");
			adminColas.agregarCola(turno);
		}
		
		// Llenar colas generales
		Turno turno1 = adminColas.crearTurno("P");
		Turno turno2 = adminColas.crearTurno("C");
		Turno turno3 = adminColas.crearTurno("SPF");
		Turno turno4 = adminColas.crearTurno("J");
		Turno turno5 = adminColas.crearTurno("SCH");
		Turno turno6 = adminColas.crearTurno("J");
		Turno turno7 = adminColas.crearTurno("SCG");
		
		adminColas.agregarCola(turno1);
		adminColas.agregarCola(turno2);
		adminColas.agregarCola(turno3);
		adminColas.agregarCola(turno4);
		adminColas.agregarCola(turno5);
		adminColas.agregarCola(turno6);
		adminColas.agregarCola(turno7);
		
		
		Debug.imprimir("Tiempo de espera puesto clientes", adminColas.devolverCola(0).devolverTiempoTotal());
		Debug.imprimir("Tiempo de espera puesto no clientes", adminColas.devolverCola(1).devolverTiempoTotal());
		Debug.imprimir("Tiempo de espera puesto jubilados", adminColas.devolverCola(2).devolverTiempoTotal());
		Debug.imprimir("Tiempo de espera puesto servicios", adminColas.devolverCola(3).devolverTiempoTotal());
		Debug.imprimir("Tiempo de espera puesto general 1", adminColas.devolverCola(4).devolverTiempoTotal());
		Debug.imprimir("Tiempo de espera puesto general 2", adminColas.devolverCola(5).devolverTiempoTotal());
	}
	
	public static void cargarTurnos() {
		System.out.println("Por favor ingrese turnos.");
		System.out.println("Para ingresar un turno, escriba el codigo del tipo de turno y presione ENTER.");
		System.out.println("Los codigos disponibles son:\n");
		System.out.println("-1 = Finalizar carga");
		System.out.println("C = Cliente");
		System.out.println("P = No cliente");
		System.out.println("J = Jubilado");
		System.out.println("SPF = Servicio - plazos fijos");
		System.out.println("SCH = Servicio - creditos hipotecarios");
		System.out.println("SCG = Servicio - creditos generales\n");

		Scanner sc = new Scanner(System.in);
		String entrada;
		int turnosCargados = 0;
		
		while (turnosCargados < 42) {
			System.out.print("Ingrese un codigo de turno (-1, C, P, J, SPF, SCH, SCG): ");
		 	 entrada = sc.nextLine();
		 	 System.out.println();
		 	 
		 	 if (
		 			entrada.toUpperCase().equals("C") ||
		 			entrada.toUpperCase().equals("P") ||
		 			entrada.toUpperCase().equals("J") ||
		 			entrada.toUpperCase().equals("SPF") ||
		 			entrada.toUpperCase().equals("SCH") ||
		 			entrada.toUpperCase().equals("SCG")
 			 ) {
		 		Turno turno = adminColas.crearTurno(entrada.toUpperCase());
				adminColas.agregarCola(turno);
				turnosCargados++;
		 	 } else if (entrada.equals("-1")) break;
		}
		
		System.out.println("Carga finalizada con exito.");
		System.out.println("Turnos cargados: " + turnosCargados + "\n");
	}
	
	public static void simularAtencion() {
		// Por cada puesto,
		for (int i = 0; i < cantidadPuestos; i++) {
			// Desacolar turno del puesto
			Cola colaActual = adminColas.devolverCola(i);
			System.out.println("Puesto " + colaActual.getNomenclatura() + ":");
			while (!colaActual.colaVacia()) {
				Turno turnoActual = colaActual.primero();
				
				// Imprimir informacion del turno y del puesto
				System.out.println("Turno " + turnoActual.getNomenclatura() + turnoActual.getId() + ": Tiempo del turno: " + turnoActual.getTiempoAtencion() + " - Tiempo del puesto: " + colaActual.devolverTiempoTotal() + " - Tiempo total: " + adminColas.getTiempoTotal());
				
				colaActual.desacolar();
			}
			
			System.out.println();
		}
	}
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		String entrada;
		
		System.out.println("*-*-*-* My Bank *-*-*-*");
		System.out.println("*                     *");
		System.out.println("*     Bienvenido/a    *");
		System.out.println("*     ------------    *");
		System.out.println("*                     *");
		System.out.println("* Opciones:           *");
		System.out.println("* 1- Cargar turnos    *");
		System.out.println("* 2- Atender turnos   *");
		System.out.println("* 3- Salir            *");
		System.out.println("*                     *");
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*");
		
		while (true) {
			System.out.print("[Comando: 1, 2, 3]: ");
			entrada = sc.nextLine();
			System.out.println();
			
			switch (entrada) {
				case "1":
					cargarTurnos();
					continue;
					
				case "2":
					simularAtencion();
					continue;
					
				case "3":
					return;
	
				default: continue;
			}
		}
	}
	
	public static void main(String[] args) {
		adminColas = new AdministradorColasTP();
		adminColas.inicializar(cantidadPuestos);
		
		// Tests
		// testCarga(adminColas);

		// Menu
		menu();
	}

}
