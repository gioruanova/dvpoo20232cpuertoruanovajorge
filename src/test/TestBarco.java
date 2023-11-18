package test;

import domain.Alquiler;
import domain.Amarre;
import domain.Anfibio;
import domain.Barco;
import domain.Catamaran;
import domain.Cliente;
import domain.Lancha;
import domain.MotoActuatica;
import domain.Velero;
import domain.Yate;

public class TestBarco {

	public static void main(String[] args) {

		Cliente cliente1 = new Cliente("Jorge", "Ruanova", "32952245");
		Cliente cliente2 = new Cliente("Luis", "Perez", "25456789");
		Cliente cliente3 = new Cliente("Pablo", "Gomez", "34455321");
		System.out.println(cliente1);
		System.out.println(cliente2);
		System.out.println(cliente3);

		System.out.println("--------");

		Amarre amarre1 = new Amarre(123L);
		Amarre amarre2 = new Amarre(321L);
		Amarre amarre3 = new Amarre(456L);
		System.out.println(amarre1);
		System.out.println(amarre2);
		System.out.println(amarre3);

		System.out.println("--------");

		Barco velero1 = new Velero("VALER--OAA", 400.5, 1998);
		Barco yate1 = new Yate("YATE-AAA", 200.5, 2005);
		Barco catamaran1 = new Catamaran("Catamaran-AAA", 1200.5, 2009);
		Barco lancha1 = new Lancha("Lancha-AAA", 345.5, 2017);
		Barco moto1 = new MotoActuatica("Moto Actuatica-AAA", 45.5, 2022);
		Barco anfibio1 = new Anfibio("Anfibio-AAA", 45.5, 2022, 6, 200.40);

		System.out.println(velero1);
		System.out.println(yate1);
		System.out.println(catamaran1);
		System.out.println(lancha1);
		System.out.println(moto1);
		System.out.println("-----------");
		System.out.println(anfibio1);

		
		System.out.println("-----------");
		System.out.println("-----------");
		Alquiler alquiler1 = new Alquiler(001L, cliente1, amarre1, velero1, null);
		Alquiler alquiler2 = new Alquiler(001L, cliente1, amarre1, anfibio1, null);
		System.out.println(alquiler1);
		System.out.println(alquiler2);

	}

}
