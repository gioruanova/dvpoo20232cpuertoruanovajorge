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
		puertitoPrueba.mostrarAmarres();

		System.out.println("\nConteo y detalle Amarres--");
		System.out.println("Amarres libres: " + puertitoPrueba.amarresLibres());
		System.out.println("Amarres ocupados: " + puertitoPrueba.amarresOcupados());
		System.out.println("Total Amarres: " + puertitoPrueba.totalAmarres());

		// ---------------------
		// Resumen Alquileres
		// ---------------------
		System.out.println("\nResumen Alquileres");
		puertitoPrueba.alquileresActivos();
		puertitoPrueba.alquileresFinalizados();
		puertitoPrueba.totalAlquileres();

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
		// Mostrando alquileres
		// ---------------------
		System.out.println("\nAlquileres creados:");
		puertitoPrueba.mostrarAlquileres();

		// ---------------------
		// Resumen Alquileres
		// ---------------------
		System.out.println("\nResumen Alquileres");
		puertitoPrueba.alquileresActivos();
		puertitoPrueba.alquileresFinalizados();
		puertitoPrueba.totalAlquileres();

		// ---------------------
		// Amarres actualizados
		// ---------------------
		System.out.println("\n---Detalle Amarres---");
		puertitoPrueba.mostrarAmarres();
		System.out.println("\n---Detalle Amarres---");
		System.out.println("Amarres libres: " + puertitoPrueba.amarresLibres());
		System.out.println("Amarres ocupados: " + puertitoPrueba.amarresOcupados());
		System.out.println("Total Amarres: " + puertitoPrueba.totalAmarres());

		// ---------------------
		// Prueba cancelacion alquiler a traves de id amarre y dia finalizacion
		// ---------------------
		System.out.println("\nCancelando alquiler amarre posicion 1 en dia 10");
		puertitoPrueba.finalizarAlquiler(1, 10);

		// ---------------------
		// Detalle alquileres
		// ---------------------
		System.out.println("\nDetalle alquileres actualizados:");
		puertitoPrueba.mostrarAlquileres();

		// ---------------------
		// Detalle amarres actualizado
		// ---------------------
		System.out.println("\nDetalle amarres actualizadossss:");
		puertitoPrueba.mostrarAmarres();

		// ---------------------
		// Resumen amarres actualizado
		// ---------------------
		System.out.println("\nDetalle Amarres actualizado:");
		System.out.println("Amarres libres: " + puertitoPrueba.amarresLibres());
		System.out.println("Amarres ocupados: " + puertitoPrueba.amarresOcupados());
		System.out.println("Total Amarres: " + puertitoPrueba.totalAmarres());

		// ---------------------
		// Resumen alquileres actualizado
		// ---------------------
		System.out.println("\nDetalle Alquileres actualizado:");
		puertitoPrueba.alquileresActivos();
		puertitoPrueba.alquileresFinalizados();
		puertitoPrueba.totalAlquileres();
		System.out.println("-------------------------------");
		System.out.println("---Alquileres NO finalizados---");
		puertitoPrueba.mostrarAlquileresNoFinalizados();
		System.out.println("-------------------------------");

		System.out.println("---Creando cliente 4 y Catamaran---");
		System.out.println("---Agregando alquiler 5 a amarre posicion 4---");
		Cliente cliente4 = new Cliente("Carlos", "Perez", "12333456");
		Barco catamaran1 = new Catamaran("Cata-102", 800.5, 2016);

		puertitoPrueba.iniciarAlquiler(cliente4, 4, catamaran1);

		System.out.println("\n");
		puertitoPrueba.mostrarAmarres();

		// ---------------------
		// Resumen Amarres
		// ---------------------
		System.out.println("\nResumen Amarres");
		System.out.println("Amarres libres: " + puertitoPrueba.amarresLibres());
		System.out.println("Amarres ocupados: " + puertitoPrueba.amarresOcupados());
		System.out.println("Total Amarres: " + puertitoPrueba.totalAmarres());

		// ---------------------
		// Resumen Alquileres
		// ---------------------
		System.out.println("\nResumen Alquileres");
		puertitoPrueba.alquileresActivos();
		puertitoPrueba.alquileresFinalizados();
		puertitoPrueba.totalAlquileres();
		System.out.println("-------------------------------");
		System.out.println("---Alquileres NO finalizados---");
		puertitoPrueba.mostrarAlquileresNoFinalizados();
		System.out.println("-------------------------------");

		// ---------------------
		// Prueba cancelacion alquiler a traves de id amarre y dia finalizacion
		// ---------------------
		System.out.println("\nCancelando alquiler amarre posicion 4 en dia 22");
		puertitoPrueba.finalizarAlquiler(4, 22);

		// ---------------------
		// Resumen Amarres
		// ---------------------
		System.out.println("\nResumen Amarres");
		System.out.println("Amarres libres: " + puertitoPrueba.amarresLibres());
		System.out.println("Amarres ocupados: " + puertitoPrueba.amarresOcupados());
		System.out.println("Total Amarres: " + puertitoPrueba.totalAmarres());

		// ---------------------
		// Resumen Alquileres
		// ---------------------
		System.out.println("\nResumen Alquileres");
		puertitoPrueba.alquileresActivos();
		puertitoPrueba.alquileresFinalizados();
		puertitoPrueba.totalAlquileres();
		System.out.println("-------------------------------");
		System.out.println("---Alquileres NO finalizados---");
		puertitoPrueba.mostrarAlquileresNoFinalizados();
		System.out.println("-------------------------------");

	}

}
