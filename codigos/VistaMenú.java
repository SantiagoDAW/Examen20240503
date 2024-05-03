package jcolonia.daw2023.quiniela;

import java.util.Scanner;

/** 
 * Crea el menú. 
 * @author <a>Santiago Santamaría Martín</a>
 */
public class VistaMenú {
	
	/** La lista de opciones que tiene el menú. */
	private String[] listaOpciones;
	
	/** Pregunta que se realiza al usuario. */
	private String pregunta;
	
	/** La opcion escojida por el usuario. */
	private int opcion;
	
	/** Nombre del menú. */
	private String nombre;
	
	/** Para leer la opción escojida por el usuario. */
	private Scanner scEntrada;
	
	/**
	 * Pasa las diversas opciones.
	 * @param nombre Nombre del menú.
	 * @param listaOpciones Lista de opciones del menú.
	 * @param in Recoje la opcion escojida por el usuario.
	 */
	public VistaMenú(String nombre, String[] listaOpciones, Scanner in) {
		this.nombre = nombre;
        this.listaOpciones = listaOpciones;
        this.scEntrada = in;
        this.pregunta = "Selecciona una opción:";
	}
	
	/**
	 * Solicita al usuario que escoja una de las opciones.
	 * @return la opcion escojida.
	 */
	public int pedirOpción() {
		String linea;
		Boolean salir;
		
		salir = false;
		
		do {
			try {	
				System.out.print(pregunta + " ");
				
				linea = scEntrada.nextLine();
				opcion = Integer.parseInt(linea);
				
				if (opcion >= 0 && opcion <= listaOpciones.length) { 
						salir = true; 
					} else {
						System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
					}
			} catch (Exception e) {
				System.out.printf("ERROR ¡El sistema solo admite números!%n");
			}		
		} while(!salir);
		
		return opcion;
	}
	
	/** Muestra el título del menú. */
	public void mostrarTítuloPrincipal() {
		System.out.println(nombre);
		for (int i = 0; i < nombre.length(); i++) {
	        System.out.print("=");
	    }
		System.out.println();
	}
	
	/** Muestra el menú y las opciones disponibles.*/
	public void mostrarMenú() {
		for (int i = 0; i < listaOpciones.length; i++) {
			System.out.printf("%d. %s\n",(i + 1),listaOpciones[i]);
		}
	}
	
	/** Muestra el mensaje de salida del menú. */
	public void salirMenú() {
		System.out.printf("Salistes de las Series");
	}
}
