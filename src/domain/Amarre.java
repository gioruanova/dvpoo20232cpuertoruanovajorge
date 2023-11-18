package domain;

public class Amarre {
	private Long id;
	private static int nextValue = 1;

	private int posicion = 1;
	private Boolean estaLibre;

	public Amarre(Long id) {
		this.id = id;
		posicion = nextValue++;
		this.estaLibre = true;
	}

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

	@Override
	public String toString() {
		return "Amarre [id=" + id + ", posicion=" + posicion + ", estaLibre=" + estaLibre + "]";
	}

}
