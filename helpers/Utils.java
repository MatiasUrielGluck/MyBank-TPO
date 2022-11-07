// https://github.com/MatiasUrielGluck

package helpers;

public class Utils {
	public static void clearConsole() {
		try {  
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
		}  
		catch (final Exception e) { 
			
		}
	}
}
