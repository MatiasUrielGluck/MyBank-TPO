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
		// BUG --> Al ingresar letra minuscula, se rompe el programa
		// TODO
		System.out.println("Por favor ingrese turnos.");
		System.out.println("Para ingresar un turno, escriba el codigo del tipo de turno y presione ENTER.");
		System.out.println("Los codigos disponibles son:\n");
		System.out.println("-1 = Finalizar carga");
		System.out.println("C = Cliente");
		System.out.println("P = No cliente");
		System.out.println("J = Jubilado");
		System.out.println("SPF = Servicio - plazos fijos");
		System.out.println("SCH = Servicio - créditos hipotecarios");
		System.out.println("SCG = Servicio - créditos generales\n");

		Scanner sc = new Scanner(System.in);
		String entrada;
		int turnosCargados = 0;
		
		for (int i = 0; i < 42; i++) {
			System.out.print("Ingrese un codigo de turno: ");
		 	 entrada = sc.nextLine();
		 	 System.out.println();
		 	 
		 	 if (
		 			entrada.toUpperCase().equals("C") || // BUG
		 			entrada.toUpperCase().equals("P") ||
		 			entrada.toUpperCase().equals("J") ||
		 			entrada.toUpperCase().equals("SPF") ||
		 			entrada.toUpperCase().equals("SCH") ||
		 			entrada.toUpperCase().equals("SCG")
 			 ) {
		 		Turno turno = adminColas.crearTurno(entrada);
				adminColas.agregarCola(turno);
				turnosCargados++;
		 	 } else if (entrada.equals("-1")) break;
		}
		
		System.out.println("Carga finalizada con exito.");
		System.out.println("Turnos cargados: " + turnosCargados + "\n");
	}
	
	public static void atenderTurnos() {
		// Atender en base a la entrada del usuario
		// US:
		// El usuario ingresa la nomenclatura de un puesto.
		// El sistema debe desacolar el turno de la cola correspondiente a la nomenclatura ingresada por el usuario.
		// El usuario puede continuar ingresando nomenclaturas o -1 para finalizar.
		// El sistema debe mostrar:
		// TODO
		System.out.println("Por favor ingrese el puesto que atendera a continuacian.");
		System.out.println("Los codigos disponibles son:\n");
		System.out.println("-1 = Finalizar atención");
		System.out.println("C = Cliente");
		System.out.println("P = No cliente");
		System.out.println("J = Jubilado");
		System.out.println("S = Servicios");
		System.out.println("X = General");
		
		Scanner sc = new Scanner(System.in);
		String entrada;
		
		while (true) {
			System.out.print("Ingrese un codigo de puesto: ");
			entrada = sc.nextLine();
			System.out.println();
			if (
				entrada.toUpperCase().equals("C") || // BUG
				entrada.toUpperCase().equals("P") ||
				entrada.toUpperCase().equals("J") ||
				entrada.toUpperCase().equals("S") ||
				entrada.toUpperCase().equals("X")
			) {
				try {
					adminColas.desacolarColar(entrada);
				} catch (Exception e) {
					System.out.println("El puesto se encuentra vacio.");
				}
				
			} else if (entrada.equals("-1")) break;
		 	 
		}
	}
	
	public static void informacion() {
		
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
		System.out.println("* 3- Informacion      *");
		System.out.println("* 4- Salir            *");
		System.out.println("*                     *");
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*");
		
		while (true) {
			System.out.print("[Comando]: ");
			entrada = sc.nextLine();
			System.out.println();
			
			switch (entrada) {
				case "1":
					cargarTurnos();
					continue;
					
				case "2":
					atenderTurnos();
					continue;
					
				case "3":
					informacion();
					continue;
					
				case "4":
					return;
	
				default: continue;
			}
		}
	}
	
	public static void programa() {
		System.out.println("Bienvenid@\n");
		cargarTurnos();
		atenderTurnos();
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
