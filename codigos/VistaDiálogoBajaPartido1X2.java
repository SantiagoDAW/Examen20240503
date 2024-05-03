package jcolonia.daw2023.quiniela;

import java.util.List;
import java.util.Scanner;

/**
 * Clase que se utiliza para dar de baja equipos.
 * @author <a>Santiago Santamaría Martín</a>
 */
public class VistaDiálogoBajaPartido1X2 {
	
	/**
	 * Para leer la opción escojida por el usuario.
	 */
	private Scanner sc;

	/**
	 * Inicializa los datos.
	 * @param titulo titulo de la lista.
	 */
	public VistaDiálogoBajaPartido1X2(String titulo) {
	}
	
	/**
	 * Opciones escojidas/introducidas por el usuario.
	 * @param listas lista de datos introducidos por el usuario.
	 * @return Lista con todos los datos que ha metido el usuario. 
	 */
	public int bajaQuiniela1X2(List<String> listas) {
		for(String lista : listas) {
			System.out.print("Que equipo quieres dar de baja:");
			lista = sc.nextLine();
			Integer.parseInt(lista);
		}
		return -1;
	}

	/**
	 * Pregunta al usuario si esta seguro de querer dar de baja al equipo o no.
	 * @param respuesta la respuesta del usuario.
	 * @return respuesta la respuesta del usuario si al final si lo da de baja.
	 */
	public boolean confirmarBaja(String respuesta) {
		System.out.print("Seguro que quiere dar de baja al equipo (S/N): ");
		respuesta = sc.nextLine();
		return respuesta.equalsIgnoreCase("S");
	}

}
