package jcolonia.daw2023.quiniela;

import java.util.Scanner;

/**
 * Clase usada para asegurarnos de que el usario quiere borrar todos los datos sabiendo
 * el riesgo que conlleva.
 * 
 * @author <a>Santiago Santamaría Martín</a>
 */
public class BorrarLista {
	
	/**
	 * Para leer la opción escojida por el usuario.
	 */
	private Scanner sc;
	
	/**
	 * Borra la lista de datos.
	 * @param listaResultados lista con todos los datos de la quiniela.
	 */
	public void borrado(ConjuntoQuiniela1X2 listaResultados) {
		System.out.print("Seguro que quiere borrar los datos, luego no se pueden recuperar (S/N): ");
		String respuesta = sc.nextLine();
		if(respuesta.equalsIgnoreCase("S")) {
			System.out.print("Borrando datos...");
			listaResultados.limpiar();
		} else {
			System.out.print("No se borraran los datos.");
			System.out.println();
		}	
	}
}
