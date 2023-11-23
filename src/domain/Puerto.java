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
		System.out.println("|OK|: Puerto creado\nAmarres:");
		alquileres = new ArrayList<>();
		amarres = new ArrayList<>();

		// Creo listado de amarres al crear el puerto
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
	// MOSTRAR DETALLE AMARRES
	// -----------------------------------------------
	public void mostrarAmarres() {
		System.out.println("\nDetalle amarres actualizados:");
		for (Amarre amr : amarres) {
			System.out.println(amr.mostrarAmarres());
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
		return amarresLibres() + amarresOcupados();
	}

	// -----------------------------------------------
	// INICIAR ALQUILER
	// -----------------------------------------------

	// Este metodo fue creado con el objetivo de permitir al usuario seleccionar el
	// tipo de amarre
	// teniendo en cuenta que se puede preferir un amarre sobre otro, dependiendo el
	// tamaño de la embarcacion

	public void iniciarAlquiler(Cliente cte, int amr, Barco bco) {
		// creo una variable testigo para definir acciones
		boolean addAlq = true;
		int e = 0;
		// Itero los alquileres para ver si tengo algun alquiler activo
		// (getAlquilerDiaFinal=null) y mismo barco y cliente)
		// De ser asi, saco el error por print, y cierro el programa seteando la
		// variable testigo en false para no
		// continuar con la ejecucion
		while (e < alquileres.size()) {
			Alquiler alqs = alquileres.get(e);
			if (alqs.getDniCliente() == cte.getDni() && alqs.getMatricula() == bco.getMatricula()
					&& alqs.getAlquilerDiaFinal() == null) {
				System.out.println("---------------|ERROR|: El alquiler para el cliente " + cte.getApellido() + ", "
						+ cte.getNombre() + " (DNI: " + cte.getDni() + ") con el barco matricula N° "
						+ bco.getMatricula() + " ya se encuentra alojado y su alquiler esta activo en amarre id: "
						+ alqs.getIdAmarre() + ", posicion: " + alqs.getPosicionAmarre() + ".\n");
				addAlq = false;
			}
			e++;
		}

		// En caso de que no haga coincidencia entre matricula barco, cliente y alquiler
		// activo, la variable testigo permanece en true,
		// dando lugar al resto del proceso y sus validaciones
		if (addAlq) {
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
								System.out.println("|OK|: Alquiler creado para cliente '" + cte.getApellido() + ", "
										+ cte.getNombre() + "' y asignado a amarre ID " + amarreLista.getId()
										+ " (posicion: " + amarreLista.getPosicion() + ")." + "\n");
							}

							else {
								System.out.println("|ERROR|: El Amarre con posicion " + amarreLista.getPosicion()
										+ "(id: " + amarreLista.getId() + ") " + " se encuentra ocupado." + "\n");
							}
						}
					}
					return;
				}
				i++;
			}
			System.out.println("|ERROR|: No se encontró ningún Amarre con el ID: " + amr + ".\n");
		}
	}

	// -----------------------------------------------
	// MOSTRAR ALQUILERES
	// -----------------------------------------------
	public void mostrarAlquileres() {
		System.out.println("\nHistorial Alquileres:");
		for (Alquiler alq : alquileres) {
			System.out.println(alq.mostrarAlquileres());
		}
	}

	// -----------------------------------------------
	// MOSTRAR ALQUILERES NO FINALIZADOS
	// -----------------------------------------------
	public void mostrarAlquileresNoFinalizados() {
		System.out.println("\n-------------------------");
		System.out.println("Alquileres NO finalizados");
		System.out.println("-------------------------");
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
//		for (Alquiler alq : alquileres) {
		int i = 0;
		while (i < alquileres.size()) {
			Alquiler alquilerLista = alquileres.get(i);
			if (alquilerLista.getPosicionAmarre() == amarreFinalizar) {
				if (!alquilerLista.estaFinalizado()) {
					alquilerLista.setAlquilerDiaFinal(diaFinal);
					// El calculo que se esta realizando es contemplando el cobro para dia inicial y
					// dia final por "politicas de la empresa"
					// o sea: Dia inicial y dia final, SE COBRAN
					// En caso de que no fuese asi, y el dia final no se cobrara seria:
					// (alq.getPrecioBarco() * (diaFinal - 1))
					// En caso de que el dia final y dia inicial no se cobraran seria:
					// (alq.getPrecioBarco() * (diaFinal - 2))
					alquilerLista.setTotalAPagar(alquilerLista.getPrecioBarco() * diaFinal);
					for (Amarre amarre : amarres) {
						if (amarre.getPosicion() == amarreFinalizar) {
							amarre.liberarAmarre();
							restarAlquiler();
							System.out.println("|OK|: Alquiler id " + amarreFinalizar + " a nombre de '"
									+ alquilerLista.getClienteApellido() + ", " + alquilerLista.getClienteNombre()
									+ "' (dias totales: " + diaFinal + " - Total: $" + alquilerLista.getTotalAPagar()
									+ ")  ha sido cancelado." + "\n");
						}
					}
				} else {
					System.out.println("|ERROR|: El alquiler ID " + amarreFinalizar + " ya estaba cancelado" + ".\n");
				}
				return;
			}
			i++;
		}
		System.out.println("|ERROR|: No se encontró ningún Amarre con el ID: " + amarreFinalizar + ".\n");
	}

	// -----------------------------------------------
	// CANTIDAD DE ALQUILERES
	// -----------------------------------------------
	public void alquileresActivos() {
		System.out.println("Alquileres ACTIVOS: " + alquileresActivos);
	}

	public void alquileresFinalizados() {
		System.out.println("Alquileres FINALIZADOS: " + alquileresFinalizados);
	}

	public void totalAlquileres() {
		System.out.println("Alquileres TOTAL: " + (alquileresFinalizados + alquileresActivos));
	}

	// -----------------------------------------------
	// METODO AGRUPADOR
	// -----------------------------------------------

	public void mostrarInfoPuerto() {
		this.mostrarAmarres();
		System.out.println("\n......................................");

		System.out.println("\nDetalle Amarres actualizado:");
		System.out.println("Amarres LIBRES: " + this.amarresLibres());
		System.out.println("Amarres OCUPADOS: " + this.amarresOcupados());
		System.out.println("Amarres TOTAL: " + this.totalAmarres());
		System.out.println("\n......................................");

		System.out.println("\nDetalle Alquileres actualizado:");
		this.alquileresActivos();
		this.alquileresFinalizados();
		this.totalAlquileres();
		System.out.println("\n......................................");

		this.mostrarAlquileres();
		System.out.println("......................................");

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
