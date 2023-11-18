package domain;

public interface InterfaceAnfibio {

	public default String mostrarRuedas(int ruedas) {
		return "Cantidad Ruedas: " + ruedas;
	}

	public default  String mostrarVelocidadTierra(Double velocidadTierra) {
		return"Cantidad Ruedas: " + velocidadTierra;
	}

}
