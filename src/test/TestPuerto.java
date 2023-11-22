package test;

import domain.Anfibio;
import domain.Barco;
import domain.Catamaran;
import domain.Cliente;
import domain.Lancha;
import domain.Puerto;
import domain.Velero;
//import domain.Yate;
//import domain.MotoActuatica;

public class TestPuerto {

	/**
	 * @METODO El metodo mostrarInfoPuerto() contiene:<br>
	 *         <br>
	 *         this.mostrarAmarres() --> Muestra el total de amarres y su estado<br>
	 *         <br>
	 *         this.amarresLibres() --> Muestra el conteo de amarres libres<br>
	 *         <br>
	 *         this.amarresOcupados() --> Muestra el conteo de amarres ocupados<br>
	 *         <br>
	 *         this.totalAmarres() --> Muestra el conteo de amarres totales<br>
	 *         <br>
	 * 
	 *         this.alquileresActivos() --> Muestra el conteo de alquileres
	 *         activos<br>
	 *         <br>
	 *         this.alquileresFinalizados() --> Muestra el conteo de alquileres
	 *         finalizados<br>
	 *         <br>
	 *         this.totalAlquileres() --> Muestra el conteo total de alquileres<br>
	 *         <br>
	 * 
	 *         this.mostrarAlquileres() --> Muestra el detalle total de
	 *         alquileres<br>
	 *         <br>
	 *         this.mostrarAlquileresNoFinalizados() --> Muestra el detalle total de
	 *         alquileres NO finalizados<br>
	 *         <br>
	 */

	public static void main(String[] args) {

		// ---------------------
		// Creando puerto y amarres
		// ---------------------
		Puerto puertitoPrueba = new Puerto();

		// ---------------------
		// Resumen Puerto
		// ---------------------
		puertitoPrueba.mostrarInfoPuerto();

		// ---------------------
		// Creando clientes y Barcos
		// ---------------------
		Cliente cliente1 = new Cliente("Jorge", "Ruanova", "32952245");
		Cliente cliente3 = new Cliente("Jorge", "Ruanova", "32952245");
		Barco velero1 = new Velero("VEL-123", 400.5, 1998);
		Barco anfibio1 = new Anfibio("ANF-456", 200.5, 2000, 6, 240.20);

		Cliente cliente2 = new Cliente("Luis", "Gomes", "44123456");
		Barco lancha1 = new Lancha("LAN-878", 250.10, 2022);

		// ---------------------
		// Agregando alquileres
		// ---------------------
		System.out.println("\nAgregando alquiler en amarre posicion 1");
		puertitoPrueba.iniciarAlquiler(cliente1, 1, velero1);

		System.out
				.println("Tratando de agregar mismo cliente y misma matricula de barco (con alquiler activo)--------");
		puertitoPrueba.iniciarAlquiler(cliente1, 5, velero1);

		System.out.println("Agregando alquiler en amarre posicion 1 (VA A DAR ERROR PORQUE YA ESTA OCUPADO)");
		puertitoPrueba.iniciarAlquiler(cliente1, 1, lancha1);

		System.out.println("Agregando alquiler en amarre posicion 2");
		puertitoPrueba.iniciarAlquiler(cliente2, 2, anfibio1);

		System.out.println("Agregando alquiler en amarre posicion 25 (inexistente - VA A DAR ERROR)");
		puertitoPrueba.iniciarAlquiler(cliente1, 25, lancha1);

		System.out.println("Agregando alquiler en amarre posicion 3");
		puertitoPrueba.iniciarAlquiler(cliente1, 3, lancha1);

		// ---------------------
		// Resumen Puerto
		// ---------------------
		puertitoPrueba.mostrarInfoPuerto();

		// ---------------------
		// Prueba cancelacion alquiler a traves de posicion amarre y dia finalizacion
		// ---------------------
		System.out.println("\nCancelando alquiler amarre posicion 1 en dia 10");
		puertitoPrueba.finalizarAlquiler(1, 10);

		// ---------------------
		// Resumen Puerto
		// ---------------------
		puertitoPrueba.mostrarInfoPuerto();

		System.out.println("\n---Creando cliente 4 y Catamaran---");
		Cliente cliente4 = new Cliente("Carlos", "Perez", "12333456");
		Barco catamaran1 = new Catamaran("CAT-001", 800.5, 2016);

		// ---------------------
		// Creando nuevo alquiler
		// ---------------------
		System.out.println("\nAgregando alquiler a amarre posicion 4---");
		puertitoPrueba.iniciarAlquiler(cliente4, 4, catamaran1);

		// ---------------------
		// Resumen Puerto
		// ---------------------
		puertitoPrueba.mostrarInfoPuerto();

		// ---------------------
		// Prueba cancelacion alquiler a traves de posicion amarre y dia finalizacion
		// ---------------------
		System.out.println("\nCancelando alquiler amarre posicion 4 en dia 22");
		puertitoPrueba.finalizarAlquiler(4, 22);

		System.out.println("\nTratando de cancelar alquiler 40 (inexistente - VA A DAR ERROR)");
		puertitoPrueba.finalizarAlquiler(40, 22);

		// ---------------------
		// Resumen Puerto
		// ---------------------
		puertitoPrueba.mostrarInfoPuerto();

		System.out.println("\nDuplicando alquiler por error");
		puertitoPrueba.iniciarAlquiler(cliente1, 3, lancha1);

		System.out.println("Intentando agregar alquiler en posicion ocupada");
		puertitoPrueba.iniciarAlquiler(cliente2, 2, lancha1);

		System.out.println("Intentando agregar alquiler en posicion inexistente");
		puertitoPrueba.iniciarAlquiler(cliente2, 70, lancha1);

		System.out.println("Agregando alquiler existosamente");
		puertitoPrueba.iniciarAlquiler(cliente2, 4, lancha1);

	}

}
