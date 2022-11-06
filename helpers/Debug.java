package helpers;

public class Debug {
	public static void imprimir(Object elemento) {
		System.out.println("[DEBUG] -- { " + elemento + " }");
	}
	
	public static void imprimir(String mensaje, Object elemento) {
		System.out.println("[DEBUG] -- " + mensaje + " : { " + elemento + " }");
	}
}
