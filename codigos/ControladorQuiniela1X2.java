package jcolonia.daw2023.quiniela;

import static java.lang.System.out;

/**
 * Controlador: Aplicación de gestión de resultados deportivos de tipo 1X2.
 * Gestiona las distintas funciones del menú principal.
 * 
 * @see ElementoPartido1X2
 * 
 * @version 1.1 (20240502000)
 * @author <a>Santiago Santamaría Martín</a>
 */
public class ControladorQuiniela1X2 {
	/** Opciones del menú principal. */
	private static final String[] TXT_MENÚ_PRINCIPAL = { "Alta", "Baja", "Listado", "Exportación", "Importación",
			"Borrado" };
	/** Colección principal de resultados. */
	ConjuntoQuiniela1X2 listaResultados;

	/**
	 * Inicializa la lista/colección donde se irán guardando los partidos.
	 */
	public ControladorQuiniela1X2() {
		listaResultados = new ConjuntoQuiniela1X2();
	}

	/**
	 * Bucle principal ligado al menú de entrada.
	 */
	public void buclePrincipal() {
		VistaMenú menú;
		int opción;
		int n = 0;
		boolean salir = false;

		menú = new VistaMenú("Quiniela 1-X-2", TXT_MENÚ_PRINCIPAL,null);

		do {
			menú.mostrarTítuloPrincipal();
			menú.mostrarMenú();
			opción = menú.pedirOpción();
			n++;

			switch (opción) {
			case 1: // Alta
				alta();
				break;
			case 2: // Baja
				baja();
				break;
			case 3: // Listado
				listado();
				break;
			case 4: // Importación
				borrado();
				break;
			case 0:
				finalizar(); // Finalizar programa
				salir = true;
				break;
			default:
				stub(opción, n);
				break;
			}
		} while (!salir);
	}
	
	/** 
	 * Elimina todos los datos en la quiniela. 
	 */
	private void borrado() {
		BorrarLista borrar = new BorrarLista();
		borrar.borrado(listaResultados);
	}

	/**
	 * Crea un partido vacío para rellenarlo y eventualmente almacenarlo. El partido
	 * se envía al diálogo de altas, y si este responde positivamente se almacena.
	 */
	private void alta() {
		ElementoPartido1X2 nuevo;

		VistaDiálogoAltaPartido1X2 dlg;
		dlg = new VistaDiálogoAltaPartido1X2("Altas 1-X-2");

		nuevo = dlg.entradaQuiniela1X2();
		if (dlg.confirmarAlta(nuevo.toString())) {
			listaResultados.agregarElemento(nuevo);
		}
		listado();
	}

	/**
	 * Abre el diálogo de bajas y recibe de él un partido de la lista para su
	 * eliminación.
	 */
	private void baja() {
		ElementoPartido1X2 partidoBorrable;
		int posiciónBorrable;

		VistaDiálogoBajaPartido1X2 dlg;
		dlg = new VistaDiálogoBajaPartido1X2("Bajas 1-X-2");

		posiciónBorrable = dlg.bajaQuiniela1X2(listaResultados.generarListado());

		if (posiciónBorrable > -1) { // Pulsación de «Intro» sin seleccionar nada
			partidoBorrable = listaResultados.getElemento(posiciónBorrable);
			if (dlg.confirmarBaja(partidoBorrable.toString())) {
				listaResultados.eliminarElemento(partidoBorrable);
			}
			listado();
		}
	}

	/**
	 * Genera una pantalla con el listado completo de partidos almacenados.
	 */
	private void listado() {
		VistaListado dlg;
		dlg = new VistaListado("Lista de Resultados");

		dlg.mostrar(listaResultados.generarListado());
		VistaGeneral.preguntaSeguir();
	}

	/**
	 * Muestra un mensaje temporal, de relleno, para opciones pendientes de
	 * implementar.
	 * 
	 * @param entrada la opción elegida
	 * @param n       el número de secuencia en el historial de opciones cursadas
	 */
	private void stub(int entrada, int n) {
		out.printf("(%02d) → %d [Opción sin desarrollar]%n", n, entrada);
	}

	/**
	 * Finaliza el programa. Muestra un mensaje final y cierra la conexión con la
	 * entrada estándar.
	 */
	private void finalizar() {
		out.println("*** FIN ***");
		VistaGeneral.close();
	}
}
