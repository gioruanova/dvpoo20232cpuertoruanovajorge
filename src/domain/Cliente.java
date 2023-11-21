package domain;

public class Cliente {

	// -----------------------------------------------
	// ATRIBUTOS
	// -----------------------------------------------
	private String nombre;
	private String apellido;
	private String dni;

	// -----------------------------------------------
	// CONSTRUCTOR
	// -----------------------------------------------
	public Cliente(String nombre, String apellido, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		System.out.println("\n-----OP OK: Cliente '" + apellido + ", " + nombre + "' creado.");
	}

	// -----------------------------------------------
	// GETTERS & SETTERS
	// -----------------------------------------------
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	// -----------------------------------------------
	// METODO MOSTRAR CLIENTE
	// -----------------------------------------------
	public String mostrarCliente() {
		return "Cliente === " + "Nombre completo: " + apellido + ", " + nombre + " - DNI: " + dni;
	}

	// -----------------------------------------------
	// METODO TO STRING
	// -----------------------------------------------
	@Override
	public String toString() {
		return "Cliente [Nombre=" + nombre + ", Apellido=" + apellido + ", DNI=" + dni + "]";
	}

}
