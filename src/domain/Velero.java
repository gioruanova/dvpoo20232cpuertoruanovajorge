package domain;

public class Velero extends Barco {

	private static final int PRECIO = 100;
	private int precio;
	
	
	public Velero(String matricula, Double eslora, int anioFabricacion) {
		super(matricula, eslora, anioFabricacion);
		this.precio = PRECIO;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

    @Override
    public int getPrecio() {
        return precio;
    }
	
	@Override
	public String toString() {
		return "Velero [Precio x Dia =" + precio + ", Matricula=" + getMatricula() + ", Eslora=" + getEslora()
				+ ", Año Fabricacion=" + getAnioFabricacion();
	}

}
