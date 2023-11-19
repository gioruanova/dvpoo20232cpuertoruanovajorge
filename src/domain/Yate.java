package domain;

public class Yate extends Barco {

	private static final int PRECIO = 250;
	private int precio;

	public Yate(String matricula, Double eslora, int anioFabricacion) {
		super(matricula, eslora, anioFabricacion);
		this.precio = PRECIO;

	}

    @Override
    public int getPrecio() {
        return precio;
    }

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Yate [Precio x Dia =" + precio + ", Matricula=" + getMatricula() + ", Eslora=" + getEslora()
				+ ", Año Fabricacion=" + getAnioFabricacion();
	}

}
