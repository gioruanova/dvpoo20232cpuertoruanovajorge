package domain;

public class Lancha extends Barco {

	private static final int PRECIO = 50;
	private int precio;

	public Lancha(String matricula, Double eslora, int anioFabricacion) {
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
		return "Lancha [Precio x Dia =" + precio + ", Matricula=" + getMatricula() + ", Eslora=" + getEslora()
				+ ", Año Fabricacion=" + getAnioFabricacion();
	}

}
