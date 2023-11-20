package test;

import domain.Anfibio;
import domain.Barco;
import domain.Catamaran;
import domain.Cliente;
import domain.Lancha;
import domain.Puerto;
import domain.Velero;
import domain.Yate;
import domain.MotoActuatica;

public class TestPuerto {

	public static void main(String[] args) {

		// ---------------------
		// Creando puerto y amarres
		// ---------------------
		System.out.println("Puerto creado\nAmarres:");
		Puerto puertitoPrueba = new Puerto();
		
		// ---------------------
		// Resumen Puerto
		// ---------------------
		puertitoPrueba.mostrarInfoPuerto();

		// ---------------------
		// Creando clientes
		// ---------------------
		Cliente cliente1 = new Cliente("Jorge", "Ruanova", "32952245");
		Cliente cliente2 = new Cliente("Luis", "Gomes", "44123456");

		// ---------------------
		// Creando barcos
		// ---------------------
		Barco velero1 = new Velero("VALER--OAA", 400.5, 1998);
		Barco anfibio1 = new Anfibio("ANFIBIO PRUEBA", 200.5, 2000, 6, 240.20);
		Barco lancha1 = new Lancha("Lancha 1", 250.10, 2022);

		// ---------------------
		// Agregando alquileres
		// ---------------------
		System.out.println("\nAgregando alquiler en amarre posicion 1");
		puertitoPrueba.iniciarAlquiler(cliente1, 1, velero1);

		System.out.println("Agregando alquiler en amarre posicion 1 (VA A DAR ERROR PORQUE YA ESTA OCUPADO)");
		puertitoPrueba.iniciarAlquiler(cliente1, 1, velero1);

		System.out.println("Agregando alquiler en amarre posicion 2");
		puertitoPrueba.iniciarAlquiler(cliente1, 2, anfibio1);

		System.out.println("Agregando alquiler en amarre posicion 25 (inexistente - VA A DAR ERROR)");
		puertitoPrueba.iniciarAlquiler(cliente2, 25, lancha1);

		System.out.println("Agregando alquiler en amarre posicion 3");
		puertitoPrueba.iniciarAlquiler(cliente2, 3, lancha1);

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
		System.out.println("---Agregando alquiler 5 a amarre posicion 4---");
		Cliente cliente4 = new Cliente("Carlos", "Perez", "12333456");
		Barco catamaran1 = new Catamaran("Cata-102", 800.5, 2016);

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

		// ---------------------
		// Resumen Puerto
		// ---------------------
		puertitoPrueba.mostrarInfoPuerto();

	}

}
