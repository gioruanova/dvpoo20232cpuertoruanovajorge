package domain;

public class Alquiler {

	private Long idAlquiler;
	private Cliente cliente;
	private Amarre amarre;
	private Barco barco;
	private int alquilerDiaInicial;
	private Integer alquilerDiaFinal;

	public Alquiler(Long idAlquiler, Cliente cliente, Amarre amarre, Barco barco, Integer alquilerDiaFinal) {

		this.idAlquiler = idAlquiler;
		this.cliente = cliente;
		this.amarre = amarre;
		this.barco = barco;
		this.alquilerDiaInicial = 1;
		this.alquilerDiaFinal = null;
	}

	public Long getIdAlquiler() {
		return idAlquiler;
	}

	public void setIdAlquiler(Long idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Amarre getAmarre() {
		return amarre;
	}

	public void setAmarre(Amarre amarre) {
		this.amarre = amarre;
	}

	public Barco getBarco() {
		return barco;
	}

	public void setBarco(Barco barco) {
		this.barco = barco;
	}

	public int getAlquilerDiaInicial() {
		return alquilerDiaInicial;
	}

	public void setAlquilerDiaInicial(int alquilerDiaInicial) {
		this.alquilerDiaInicial = alquilerDiaInicial;
	}

	public Integer getAlquilerDiaFinal() {
		return alquilerDiaFinal;
	}

	public void setAlquilerDiaFinal(Integer alquilerDiaFinal) {
		this.alquilerDiaFinal = alquilerDiaFinal;
	}

	@Override
	public String toString() {
		return "Alquiler= " + idAlquiler + ", alquilerDiaInicial=" + alquilerDiaInicial + ", alquilerDiaFinal="
				+ alquilerDiaFinal + "]" + " - " + cliente + " - " + amarre + " - " + barco;
	}

}
