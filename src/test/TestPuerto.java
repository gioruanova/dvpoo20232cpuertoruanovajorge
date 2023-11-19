package test;

import domain.Alquiler;
import domain.Amarre;
import domain.Anfibio;
import domain.Barco;
import domain.Catamaran;
import domain.Cliente;
import domain.Lancha;
import domain.MotoActuatica;
import domain.Puerto;
import domain.Velero;
import domain.Yate;

public class TestPuerto {

	public static void main(String[] args) {

		Puerto puertitoPrueba = new Puerto();
		Amarre amarre1 = new Amarre(120L);
		Amarre amarre2 = new Amarre(121L);
		Amarre amarre3 = new Amarre(122L);
		Amarre amarre4 = new Amarre(123L);
		Amarre amarre5 = new Amarre(124L);
		puertitoPrueba.addAmarre(amarre1);
		puertitoPrueba.addAmarre(amarre2);
		puertitoPrueba.addAmarre(amarre3);
		puertitoPrueba.addAmarre(amarre4);
		puertitoPrueba.addAmarre(amarre5);

		System.out.println("\n---Amarres creados---");
		puertitoPrueba.mostrarAmarres();
		
		System.out.println("\n---Detalle Amarres---");
		System.out.println("Total Amarres: " + puertitoPrueba.totalAmarres());
		System.out.println("Amarres libres: " + puertitoPrueba.amarresLibres());
		System.out.println("Amarres ocupados: " + puertitoPrueba.amarresOcupados());
		

		Cliente cliente1 = new Cliente("Jorge", "Ruanova", "32952245");
		Barco velero1 = new Velero("VALER--OAA", 400.5, 1998);
		Barco anfibio1 = new Anfibio("ANFIBIO PRUEBA", 200.5, 2000, 6, 240.20);

		Alquiler alquiler1 = new Alquiler(001L, cliente1, amarre1, velero1, null);
		Alquiler alquiler2 = new Alquiler(002L, cliente1, amarre1, velero1, null);
		Alquiler alquiler3 = new Alquiler(002L, cliente1, amarre3, anfibio1, null);

		System.out.println("\n");
		System.out.println("---Agregando alquiler 1 a amarre 1---");
		puertitoPrueba.iniciarAlquiler(alquiler1);
		System.out.println("---Agregando alquiler 2 a amarre 1--- (VA A DAR ERROR)");
		puertitoPrueba.iniciarAlquiler(alquiler2);
		System.out.println("---Agregando alquiler  a amarre 3---");
		puertitoPrueba.iniciarAlquiler(alquiler3);
		
		System.out.println("\n");
		System.out.println("---Alquileres creados---");
		puertitoPrueba.mostrarAlquileres();

		System.out.println("\n");
		puertitoPrueba.alquileresActivos();
		puertitoPrueba.alquileresFinalizados();
		puertitoPrueba.totalAlquileres();


		System.out.println("\n---Detalle Amarres---");
		puertitoPrueba.mostrarAmarres();
		System.out.println("\n---Detalle Amarres---");
		System.out.println("Total Amarres: " + puertitoPrueba.totalAmarres());
		System.out.println("Amarres libres: " + puertitoPrueba.amarresLibres());
		System.out.println("Amarres ocupados: " + puertitoPrueba.amarresOcupados());

		System.out.println("\n");
		System.out.println("---Cancelando alquiler 1 en dia 10---");
		puertitoPrueba.finalizarAlquiler(alquiler1, 10);
		puertitoPrueba.mostrarAlquileres();

		System.out.println("\n");
		puertitoPrueba.mostrarAmarres();
		System.out.println("\n");

		System.out.println("---Detalle Amarres---");
		System.out.println("Total Amarres: " + puertitoPrueba.totalAmarres());
		System.out.println("Amarres libres: " + puertitoPrueba.amarresLibres());
		System.out.println("Amarres ocupados: " + puertitoPrueba.amarresOcupados());
		
		System.out.println("\n");
		puertitoPrueba.alquileresActivos();
		puertitoPrueba.alquileresFinalizados();
		puertitoPrueba.totalAlquileres();

	}

}
