package domain;

public class Anfibio extends Barco implements InterfaceAnfibio {

	// -----------------------------------------------
	// ATRIBUTOS
	// -----------------------------------------------
	private static final int PRECIO = 175;
	private int precioAlquilerPorDia;
	private int cantidadRuedas;
	private Double velocidadTierra;

	// -----------------------------------------------
	// CONSTRUCTOR
	// -----------------------------------------------
	public Anfibio(String matricula, Double eslora, int anioFabricacion, int cantidadRuedas, Double velocidadTierra) {
		super(matricula, eslora, anioFabricacion);
		this.precioAlquilerPorDia = PRECIO;
		this.cantidadRuedas = cantidadRuedas;
		this.velocidadTierra = velocidadTierra;
	}

	// -----------------------------------------------
	// GETTERS & SETTERS
	// -----------------------------------------------
	public void setPrecio(int precioAlquilerPorDia) {
		this.precioAlquilerPorDia = precioAlquilerPorDia;
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
	public int getPrecioAlquilerPorDia() {
		return precioAlquilerPorDia;
	}

	// -----------------------------------------------
	// METODO PARA MOSTRAR ANFIBIO POR INTERFACE
	// -----------------------------------------------
	public String mostrarAnfibio() {
		return "\nEmbarcacion === Tipo: " + tipoDeBarco() + " - Matricula: " + this.getMatricula()
				+ " - Eslora: " + this.getEslora() + "mts - Año: " + this.getAnioFabricacion()
				+ "\n            > |Tipo Anfibio > Ruedas: " + mostrarRuedas(cantidadRuedas) + " - Velocidad x tierra: "
				+ mostrarVelocidadTierra(velocidadTierra) + "Km/h|";
	}

	// -----------------------------------------------
	// METODO TO STRING
	// -----------------------------------------------
	@Override
	public String toString() {
		return "Anfibio [precio=" + precioAlquilerPorDia + ", cantidadRuedas=" + cantidadRuedas + ", velocidadTierra="
				+ velocidadTierra + "]";
	}
}
