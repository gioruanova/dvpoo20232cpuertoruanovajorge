package domain;

public class Velero extends Barco {

	public Velero(String matricula, Double eslora, int anioFabricacion) {
		super(matricula, eslora, anioFabricacion);

	}

	@Override
	public String toString() {
		return "Velero [getMatricula()=" + getMatricula() + ", getEslora()=" + getEslora() + ", getAnioFabricacion()="
				+ getAnioFabricacion();
	}
	
	

}
