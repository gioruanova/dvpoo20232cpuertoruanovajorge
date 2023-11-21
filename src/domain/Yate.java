package domain;

public class Yate extends Barco {

	// -----------------------------------------------
	// ATRIBUTOS
	// -----------------------------------------------
	private static final int PRECIO = 250;
	private int precioAlquilerPorDia;

	// -----------------------------------------------
	// CONSTRUCTOR
	// -----------------------------------------------
	public Yate(String matricula, Double eslora, int anioFabricacion) {
		super(matricula, eslora, anioFabricacion);
		this.precioAlquilerPorDia = PRECIO;
	}

	// -----------------------------------------------
	// GETTERS & SETTERS
	// -----------------------------------------------
	public void setPrecio(int precioAlquilerPorDia) {
		this.precioAlquilerPorDia = precioAlquilerPorDia;
	}

	// -----------------------------------------------
	// METODO SOBREESCRITO PARA PASAR PRECIO A CLASE PADRE BARCO
	// -----------------------------------------------
	@Override
	public int getPrecioAlquilerPorDia() {
		return precioAlquilerPorDia;
	}

	// -----------------------------------------------
	// METODO TO STRING
	// -----------------------------------------------
	@Override
	public String toString() {
		return "Yate [Precio x Dia =" + precioAlquilerPorDia + ", Matricula=" + getMatricula() + ", Eslora=" + getEslora()
				+ ", Año Fabricacion=" + getAnioFabricacion();
	}

}
