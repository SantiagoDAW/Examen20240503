package jcolonia.daw2023.quiniela;

import java.util.Scanner;

/**
 * Clase que da de alta las quinielas insertadas por el usuario.
 * 
 * @author <a>Santiago Santamaría Martín</a>
 */
public class VistaDiálogoAltaPartido1X2 {
	
	/**
	 * Titulo de la lista.
	 */
	private String titulo;
	
	/**
	 * Para leer la opción escojida por el usuario.
	 */
	private Scanner sc;
	
	/**
	 * Inicializa los datos.
	 * @param titulo titulo de la lista.
	 */
	public VistaDiálogoAltaPartido1X2(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * Opciones escojidas/introducidas por el usuario.
	 * @return Lista con todos los datos que ha metido el usuario. 
	 */
	public ElementoPartido1X2 entradaQuiniela1X2() {
		System.out.print(titulo);
		System.out.print("Equipo Local");
		sc.nextLine();
		System.out.print("Equipo Visitante");
		sc.nextLine();
		System.out.print("Empate");
		sc.nextLine();
		System.out.print("Victoria Local");
		sc.nextLine();
		System.out.print("Victoria Visitante");
		sc.nextLine();
		return new ElementoPartido1X2();
	}
	
	/**
	 * Pregunta al usuario si si esta seguro de querer dar de alta al equipo o no.
	 * @param respuesta la respuesta del usuario.
	 * @return respuesta la respuesta del usuario si al final si lo da de alta.
	 */
	public boolean confirmarAlta(String respuesta) {
		System.out.print("Seguro que quiere dar de alta al equipo (S/N): ");
		respuesta = sc.nextLine();
		return respuesta.equalsIgnoreCase("S");
	}
}
