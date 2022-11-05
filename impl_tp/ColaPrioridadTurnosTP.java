package impl_tp;

import apis_tp.ColaPrioridadTurnos;
import apis_tp.Turno;

public class ColaPrioridadTurnosTP implements ColaPrioridadTurnos {
	
	class Elemento{
		Turno valor;
		int prioridad;
	}
	
	Elemento[] elementos;
	int indice;
	
	public void inicializarCola() {
		indice = 0;
		elementos = new Elemento[100];
	}
	public void acolarPrioridad(Turno turno, int prioridad) {
		int j = indice;
		
		for(;j>0 && elementos[j-1].prioridad>=prioridad;j--) {
			elementos[j] = elementos[j-1];
		}
		
		elementos[j] = new Elemento();
		elementos[j].valor = turno;
		elementos[j].prioridad = prioridad;
		indice++;
	}
	
	public void desacolar() {
		elementos[indice - 1] = null;
		indice--;
	}
	
	public Boolean colaVacia() {
		return(indice == 0);
	}
	
	public Turno primero() {
		return elementos[indice - 1].valor;
	}
	
	public int prioridad() {
		return elementos[indice - 1].prioridad;
	}
}
