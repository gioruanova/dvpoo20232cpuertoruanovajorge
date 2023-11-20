package domain;

public class Anfibio extends Barco implements InterfaceAnfibio {

	// -----------------------------------------------
	// ATRIBUTOS
	// -----------------------------------------------
	private static final int PRECIO = 175;
	private int precio;
	private int cantidadRuedas;
	private Double velocidadTierra;

	// -----------------------------------------------
	// CONSTRUCTOR
	// -----------------------------------------------
	public Anfibio(String matricula, Double eslora, int anioFabricacion, int cantidadRuedas, Double velocidadTierra) {
		super(matricula, eslora, anioFabricacion);
		this.precio = PRECIO;
		this.cantidadRuedas = cantidadRuedas;
		this.velocidadTierra = velocidadTierra;
	}

	// -----------------------------------------------
	// GETTERS & SETTERS
	// -----------------------------------------------
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getCantidadRuedas() {
		return cantidadRuedas;
	}

	public void setCantidadRuedas(int cantidadRuedas) {
		this.cantidadRuedas = cantidadRuedas;
	}

	public Double getVelocidadTierra() {
		return velocidadTierra;
	}

	public void setVelocidadTierra(Double velocidadTierra) {
		this.velocidadTierra = velocidadTierra;
	}

	// -----------------------------------------------
	// METODO DESDE INTERFACE ANFIBIO
	// -----------------------------------------------
	public int mostrarRuedas(int ruedas) {
		return ruedas;
	}

	public Double mostrarVelocidadTierra(Double velocidadTierra) {
		return velocidadTierra;
	}

	// -----------------------------------------------
	// METODO SOBREESCRITO PARA PASAR PRECIO A CLASE PADRE BARCO
	// -----------------------------------------------
	@Override
	public int getPrecio() {
		return precio;
	}

	// -----------------------------------------------
	// METODO PARA MOSTRAR ANFIBIO POR INTERFACE
	// -----------------------------------------------
	public String mostrarAnfibio() {
		return "\nBarco Anfibio: Ruedas: " + mostrarRuedas(cantidadRuedas) + " - Velocidad x tierra: " + mostrarVelocidadTierra(velocidadTierra)
				+ " - Matricula: " + this.getMatricula() + " - Eslora: " + this.getEslora() + " - Año: "
				+ this.getAnioFabricacion();
	}

	// -----------------------------------------------
	// METODO TO STRING
	// -----------------------------------------------
	@Override
	public String toString() {
		return "Anfibio [precio=" + precio + ", cantidadRuedas=" + cantidadRuedas + ", velocidadTierra="
				+ velocidadTierra + "]";
	}
}
