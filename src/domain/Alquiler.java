package domain;

public class Alquiler {

	// -----------------------------------------------
	// ATRIBUTOS
	// -----------------------------------------------
	private Long idAlquiler;
	private Cliente cliente;
	private Amarre amarre;
	private Barco barco;
	private Integer alquilerDiaInicial;
	private Integer alquilerDiaFinal;
	private Integer totalAPagar;

	// -----------------------------------------------
	// AUXILIAR
	// -----------------------------------------------
	private static Long nextValueAlquiler = 010L;

	// -----------------------------------------------
	// CONSTRUCTOR
	// -----------------------------------------------
	public Alquiler(Cliente cliente, Amarre amarre, Barco barco) {
		idAlquiler = nextValueAlquiler++;
		this.cliente = cliente;
		this.amarre = amarre;
		this.barco = barco;
		this.alquilerDiaInicial = 1;
		this.alquilerDiaFinal = null;

	}

	// -----------------------------------------------
	// GETTERS & SETTERS
	// -----------------------------------------------
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

	public Long getIdAmarre() {
		return amarre.getId();
	}

	public int getPosicionAmarre() {
		return amarre.getPosicion();
	}

	public int getPrecioBarco() {
		return barco.getPrecio();
	}

	// -----------------------------------------------
	// METODO PARA ALQUILER FINALIZADO
	// -----------------------------------------------
	public Boolean estaFinalizado() {
		boolean estado;
		if (this.alquilerDiaFinal != null) {
			estado = true;
		} else {
			estado = false;
		}
		return estado;
	}

	// -----------------------------------------------
	// MOSTRAR ALQUILERES
	// -----------------------------------------------
	public String mostrarAlquileres() {
		return "Alquiler= " + idAlquiler + ", Dia Inicial=" + alquilerDiaInicial
				+ (estaFinalizado() ? ", Dia Final=" + alquilerDiaFinal : "") + " -_-[ "
				+ (!estaFinalizado() ? "Alquiler Activo ]"
						: ("Alquiler Finalizado : ") + "Total a abonar: $" + totalAPagar + " ]-_-")
				+ "\n" + cliente + "\n" + "ID Amarre: " + amarre.getId() + " - Amarre Posicion: " + amarre.getPosicion()
				+ barco.mostrarBarco() + "\n";
	}

	// -----------------------------------------------
	// METODO TO STRING
	// -----------------------------------------------
	@Override
	public String toString() {
		return "Alquiler [idAlquiler=" + idAlquiler + ", cliente=" + cliente + ", amarre=" + amarre + ", barco=" + barco
				+ ", alquilerDiaInicial=" + alquilerDiaInicial + ", alquilerDiaFinal=" + alquilerDiaFinal
				+ ", totalAPagar=" + totalAPagar + "]";
	}

}
