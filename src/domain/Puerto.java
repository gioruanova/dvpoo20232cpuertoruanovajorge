package domain;

import java.util.ArrayList;
import java.util.List;

public class Puerto {

	// Atributos
	private List<Alquiler> alquileres;
	private List<Amarre> amarres;
	private int alquileresActivos = 0;
	private int alquileresFinalizados = 0;


	// Constructor
	public Puerto() {
		alquileres = new ArrayList<Alquiler>();
		amarres = new ArrayList<Amarre>();
	}

	public void sumarAlquiler() {
		alquileresActivos = alquileresActivos +1;

	}

	public void restarAlquiler() {
		alquileresFinalizados = alquileresFinalizados +1;

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

	public void addAmarre(Amarre amarre) {
		if (amarres == null) {
			amarres = new ArrayList<Amarre>();
		}

		this.amarres.add(amarre);
	}

	public void mostrarAmarres() {
		for (Amarre amr : amarres) {
			System.out.println(amr);

		}
	}

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

	public void iniciarAlquiler(Alquiler alq) {
		for (Amarre amarre : amarres) {
			if (amarre.getId() == alq.getAmarre().getId()) {
				if (amarre.getEstaLibre()) {
					if (alquileres == null) {
						alquileres = new ArrayList<Alquiler>();
					}

					this.alquileres.add(alq);
					amarre.setEstaLibre(false);
					sumarAlquiler();
				} else {
					System.out.println("El Amarre con posicion " + alq.getAmarre().getPosicion() + "(id: "
							+ alq.getAmarre().getId() + ") " + " se encuentra ocupado");
				}

			}
		}

	}

	public void mostrarAlquileres() {
		for (Alquiler alq : alquileres) {
			System.out.println(alq);

		}
	}

	public void finalizarAlquiler(Alquiler alqFinalizar, Integer diaFinal) {
		for (Alquiler alq : alquileres) {
			if (alq.getIdAlquiler() == alqFinalizar.getIdAlquiler()) {
				if (alq.getAlquilerDiaFinal() == null) {
					alq.setAlquilerDiaFinal(diaFinal);
					alq.setTotalAPagar(alq.getBarco().getPrecio() * diaFinal);
					for (Amarre amarre : amarres) {
						if (amarre.getId() == alqFinalizar.getAmarre().getId()) {
							amarre.setEstaLibre(true);
							restarAlquiler();
						}
					}
				} else {
					System.out.println("El alquiler ya estaba cancelado");
				}
			}
		}

	}

//Mostrar alquileres-----------------
	public void alquileresActivos() {
		System.out.println("Alquileres Activos: " + alquileresActivos);

	}

	public void alquileresFinalizados() {
		System.out.println("Alquileres Finalizados: " + alquileresFinalizados);

	}

	public void totalAlquileres() {
		System.out.println("Alquileres TOTAL: " + (alquileresFinalizados + alquileresActivos));

	}
}
