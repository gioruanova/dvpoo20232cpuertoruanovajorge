package domain;

public abstract class Barco {

	// -----------------------------------------------
	// ATRIBUTOS
	// -----------------------------------------------
	private String matricula;
	private Double eslora;
	private int anioFabricacion;

	// -----------------------------------------------
	// CONSTRUCTOR
	// -----------------------------------------------
	public Barco(String matricula, Double eslora, int anioFabricacion) {
		this.matricula = matricula;
		this.eslora = eslora;
		this.anioFabricacion = anioFabricacion;
		System.out.println(
				"|OK|: Barco " + this.getClass().getSimpleName() + " (Matricula: " + matricula + ")" + " creado.");

	}

	// -----------------------------------------------
	// GETTERS Y SETTERS
	// -----------------------------------------------
	public String getMatricula() {
		return matricula;
	}

	public String tipoDeBarco() {
		return this.getClass().getSimpleName();
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Double getEslora() {
		return eslora;
	}

	public void setEslora(Double eslora) {
		this.eslora = eslora;
	}

	public int getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(int anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	// -----------------------------------------------
	// METODO PARA OBTENER PRECIO DE CLASES HIJAS
	// -----------------------------------------------
	public abstract int getPrecioAlquilerPorDia();

	// -----------------------------------------------
	// METODO PARA MOSTRAR DETALLE BARCO O ANFIBIO SEGUN INSTANCE
	// -----------------------------------------------
	public String mostrarBarco() {
		String result;
		if (this instanceof Anfibio) {
			result = ((Anfibio) this).mostrarAnfibio();

		} else {
			result = mostrarBarcoComun();
		}
		return result;
	}

	public String mostrarBarcoComun() {
		return "\nEmbarcacion === Tipo: " + tipoDeBarco() + " - Matricula: " + matricula + " - Eslora: " + eslora
				+ "mts - Año: " + anioFabricacion;
	}

	// -----------------------------------------------
	// METODO TO STRING
	// -----------------------------------------------
	@Override
	public String toString() {
		return "Barco [matricula=" + matricula + ", eslora=" + eslora + "mts, anioFabricacion=" + anioFabricacion + "]";
	}

}
