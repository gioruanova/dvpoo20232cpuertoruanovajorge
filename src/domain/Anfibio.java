package domain;

public class Anfibio extends Barco implements InterfaceAnfibio {

	private static final int PRECIO = 175;
	private int precio;

	private int cantidadRuedas;
	private Double velocidadTierra;

	public Anfibio(String matricula, Double eslora, int anioFabricacion, int cantidadRuedas, Double velocidadTierra) {
		super(matricula, eslora, anioFabricacion);
		this.precio = PRECIO;
		this.cantidadRuedas = cantidadRuedas;
		this.velocidadTierra = velocidadTierra;
	}

	public int getPrecio() {
		return precio;
	}

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

	@Override
	public String mostrarRuedas(int ruedas) {
		return ", [ Cantidad Ruedas: " + ruedas;
	}

	@Override
	public String mostrarVelocidadTierra(Double velocidadTierra) {
		return " | Velocidad tierra: " + velocidadTierra + " ] ";
	}

	@Override
	public String toString() {
		return "Anfibio [Precio x Dia =" + precio + ", Matricula=" + getMatricula() + ", Eslora="
				+ getEslora() + ", Año Fabricacion=" + getAnioFabricacion() + mostrarRuedas(getCantidadRuedas())
				+ mostrarVelocidadTierra(getVelocidadTierra());
	}

}
