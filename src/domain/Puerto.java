package domain;

import java.util.ArrayList;
import java.util.List;

public class Puerto {

	private static final int CANTIDAD_AMARRES = 7;
	// -----------------------------------------------
	// ATRIBUTOS
	// -----------------------------------------------
	private List<Alquiler> alquileres;
	private List<Amarre> amarres;
	private int alquileresActivos = 0;
	private int alquileresFinalizados = 0;

	// -----------------------------------------------
	// CONSTRUCTOR
	// -----------------------------------------------
	public Puerto() {
		alquileres = new ArrayList<>();
		amarres = new ArrayList<>();

		// Crear e inicializar las instancias de Amarre
		for (int i = 0; i < CANTIDAD_AMARRES; i++) {
			Amarre amarre = new Amarre();
			amarres.add(amarre);
		}
	}

	// -----------------------------------------------
	// GETTERS & SETTERS
	// -----------------------------------------------
	public void sumarAlquiler() {
		alquileresActivos = alquileresActivos + 1;
	}

	public void restarAlquiler() {
		alquileresFinalizados = alquileresFinalizados + 1;
		alquileresActivos = alquileresActivos - 1;
	}

	public List<Alquiler> getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(List<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}

	public List<Amarre> getAmarres() {
		return amarres;
	}

	public void setAmarres(List<Amarre> amarres) {
		this.amarres = amarres;
	}

	// -----------------------------------------------
	// AGREGAR AMARRE
	// -----------------------------------------------
	public void addAmarre(Amarre amarre) {
		if (amarres == null) {
			amarres = new ArrayList<Amarre>();
		}
		this.amarres.add(amarre);
	}

	// -----------------------------------------------
	// MOSTRAR DETALLE AMARRES
	// -----------------------------------------------
	public void mostrarAmarres() {
		for (Amarre amr : amarres) {
			System.out.println(amr);
		}
	}

	// -----------------------------------------------
	// CANTIDAD AMARRES
	// -----------------------------------------------
	private Integer mostrarEstadoAmarre(Boolean estado) {
		int cantidad = 0;
		for (Amarre amarre : amarres) {
			if (amarre.getEstaLibre() == estado) {
				cantidad = cantidad + 1;
			}
		}
		return cantidad;
	}

	public Integer amarresLibres() {
		return mostrarEstadoAmarre(true);
	}

	public Integer amarresOcupados() {
		return mostrarEstadoAmarre(false);
	}

	public Integer totalAmarres() {
		int cantidad = 0;
		for (Amarre amarre : amarres) {
			cantidad = cantidad + 1;
		}
		return cantidad;
	}

	// -----------------------------------------------
	// INICIAR ALQUILER
	// -----------------------------------------------
	public void iniciarAlquiler(Cliente cte, int amr, Barco bco) {
		int i = 0;
		while (i < amarres.size()) {
			Amarre amarreLista = amarres.get(i);
			if (amarreLista.getPosicion() == amr) {
				Alquiler alquiler = new Alquiler(cte, amarreLista, bco);
				for (Amarre amarre : amarres) {
					if (amarre.getPosicion() == amarreLista.getPosicion()) {
						if (amarre.getEstaLibre()) {
							if (alquileres == null) {
								alquileres = new ArrayList<>();
							}
							this.alquileres.add(alquiler);
							amarre.ocuparAmarre();
							sumarAlquiler();
						} else {
							System.out.println("El Amarre con posicion " + amarreLista.getPosicion() + "(id: "
									+ amarreLista.getId() + ") " + " se encuentra ocupado");
						}
					}
				}
				return;
			}
			i++;
		}

		System.out.println("No se encontró ningún Amarre con el ID: " + amr);
	}

	// -----------------------------------------------
	// MOSTRAR ALQUILERES
	// -----------------------------------------------
	public void mostrarAlquileres() {
		for (Alquiler alq : alquileres) {
			System.out.println(alq.mostrarAlquileres());
		}
	}

	// -----------------------------------------------
	// MOSTRAR ALQUILERES NO FINALIZADOS
	// -----------------------------------------------
	public void mostrarAlquileresNoFinalizados() {
		for (Alquiler alq : alquileres) {
			if (alq.getAlquilerDiaFinal() == null) {
				System.out.println(alq.mostrarAlquileres());

			}
		}
	}

	// -----------------------------------------------
	// FINALIZAR ALQUILER
	// -----------------------------------------------
	public void finalizarAlquiler(int amarreFinalizar, Integer diaFinal) {
		for (Alquiler alq : alquileres) {
			if (alq.getPosicionAmarre() == amarreFinalizar) {
				if (!alq.estaFinalizado()) {
					alq.setAlquilerDiaFinal(diaFinal);
					alq.setTotalAPagar(alq.getPrecioBarco() * diaFinal);
					for (Amarre amarre : amarres) {
						if (amarre.getPosicion() == amarreFinalizar) {
							amarre.liberarAmarre();
							restarAlquiler();
						}
					}
				} else {
					System.out.println("El alquiler ya estaba cancelado");
				}
			}
		}
	}

	// -----------------------------------------------
	// CANTIDAD DE ALQUILERES
	// -----------------------------------------------
	public void alquileresActivos() {
		System.out.println("Alquileres Activos: " + alquileresActivos);
	}

	public void alquileresFinalizados() {
		System.out.println("Alquileres Finalizados: " + alquileresFinalizados);
	}

	public void totalAlquileres() {
		System.out.println("Alquileres TOTAL: " + (alquileresFinalizados + alquileresActivos));
	}

	// -----------------------------------------------
	// METODO AGRUPADOR
	// -----------------------------------------------

	public void mostrarInfoPuerto() {

		System.out.println("\nDetalle amarres actualizados:");
		this.mostrarAmarres();
		System.out.println("\n......................................");

		System.out.println("\nDetalle Amarres actualizado:");
		System.out.println("Amarres libres: " + this.amarresLibres());
		System.out.println("Amarres ocupados: " + this.amarresOcupados());
		System.out.println("Total Amarres: " + this.totalAmarres());
		System.out.println("\n......................................");

		System.out.println("\nDetalle Alquileres actualizado:");
		this.alquileresActivos();
		this.alquileresFinalizados();
		this.totalAlquileres();
		System.out.println("\n......................................");

		System.out.println("\nAlquileres creados:");
		this.mostrarAlquileres();
		System.out.println("......................................");

		System.out.println("\n-------------------------");
		System.out.println("Alquileres NO finalizados");
		System.out.println("-------------------------");
		this.mostrarAlquileresNoFinalizados();
		System.out.println("......................................");
	}

	// -----------------------------------------------
	// METODO TO STRING
	// -----------------------------------------------
	@Override
	public String toString() {
		return "Puerto [alquileres=" + alquileres + ", amarres=" + amarres + ", alquileresActivos=" + alquileresActivos
				+ ", alquileresFinalizados=" + alquileresFinalizados + "]";
	}

}
