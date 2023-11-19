package domain;

public class Alquiler {

	private Long idAlquiler;
	private Cliente cliente;
	private Amarre amarre;
	private Barco barco;
	private Integer alquilerDiaInicial;
	private Integer alquilerDiaFinal;
	private Integer totalAPagar;

	public Alquiler(Long idAlquiler, Cliente cliente, Amarre amarre, Barco barco, Integer alquilerDiaFinal) {

		this.idAlquiler = idAlquiler;
		this.cliente = cliente;
		this.amarre = amarre;
		this.barco = barco;
		this.alquilerDiaInicial = 1;
		this.alquilerDiaFinal = null;

	}

	public Integer getTotalAPagar() {
		return totalAPagar;
	}

	public void setTotalAPagar(Integer totalAPagar) {
		this.totalAPagar = totalAPagar;
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

	public void setAlquilerDiaInicial(Integer alquilerDiaInicial) {
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
		return "Alquiler= " + idAlquiler + ", Dia Inicial=" + alquilerDiaInicial + ", Dia Final=" + alquilerDiaFinal
				+ " - "
				+ ((alquilerDiaFinal == null) ? "Alquiler Activo"
						: ("Alquiler Finalizado : ") + "Total a abonar: " + totalAPagar + "]")
				+ " - " + cliente + " - " + amarre + barco.mostrarBarco();
	}

}
