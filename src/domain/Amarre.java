package domain;

public class Amarre {
	// -----------------------------------------------
	// ATRIBUTOS
	// -----------------------------------------------
	private Long id = 001L;
	private int posicion = 0;
	private Boolean estaLibre;

	// -----------------------------------------------
	// AUXILIAR
	// -----------------------------------------------
	private static Long nextValueId = 100L;
	private static int nextValuePosicion = 1;

	// -----------------------------------------------
	// CONSTRUCTOR
	// -----------------------------------------------
	public Amarre() {
		id = nextValueId++;
		posicion = nextValuePosicion++;
		this.estaLibre = true;
	}

	// -----------------------------------------------
	// GETTERS & SETTERS
	// -----------------------------------------------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public Boolean getEstaLibre() {
		return estaLibre;
	}

	public void setEstaLibre(Boolean estaLibre) {
		this.estaLibre = estaLibre;
	}

	// -----------------------------------------------
	// METODOS PARA CAMBIAR ESTADO AMARRES
	// -----------------------------------------------
	public void ocuparAmarre() {
		this.estaLibre = false;
	}

	public void liberarAmarre() {
		this.estaLibre = true;
	}

	// -----------------------------------------------
	// METODO TO STRING
	// -----------------------------------------------
	@Override
	public String toString() {
		return "Amarre: [id= " + id + ", posicion= " + posicion + ", Disponibilidad= " + estaLibre + "]";
	}

}
