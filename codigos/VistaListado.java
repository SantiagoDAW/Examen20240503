package jcolonia.daw2023.quiniela;

import java.util.List;

/** 
 * Lista de los datos introducidos en la quiniela. 
 * @author <a>Santiago Santamaría Martín</a>
 */
public class VistaListado {
	
	/** Titulo de la lista. */
	private String titulo;
	
	/**
	 * Inicializa los datos.
	 * @param titulo titulo de la lista.
	 */
	public VistaListado(String titulo) {
		this.titulo = titulo;
	}
	
	/** 
	 * Muestra la lista.
	 * @param listaTexto lista de datos introducidos. 
	 */
	public void mostrar(List<String> listaTexto) {
		System.out.println(titulo);
		for (String texto : listaTexto) {
			System.out.println(texto);
		}
	}
}
