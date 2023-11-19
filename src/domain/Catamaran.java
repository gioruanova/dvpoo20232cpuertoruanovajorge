package domain;

public class Catamaran extends Barco {

	private static final int PRECIO = 150;
	private int precio;

	public Catamaran(String matricula, Double eslora, int anioFabricacion) {
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
		return "Catamaran [Precio x Dia =" + precio + ", Matricula=" + getMatricula() + ", Eslora=" + getEslora()
				+ ", Año Fabricacion=" + getAnioFabricacion();
	}

}
