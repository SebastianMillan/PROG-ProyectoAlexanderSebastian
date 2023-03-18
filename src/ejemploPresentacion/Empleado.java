package ejemploPresentacion;

public class Empleado {

	private String dni;
	private String nombre;
	private int edad;
	private double horasTrabajadas;
	
	public Empleado(String dni, String nombre, int edad, double horasTrabajadas) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.horasTrabajadas = horasTrabajadas;
	}
	public Empleado() {
		
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getHorasTrabajadas() {
		return horasTrabajadas;
	}
	public void setHorasTrabajadas(double horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", horasTrabajadas=" + horasTrabajadas
				+ "]";
	}
	public double calcularSueldo(double precioHora) {
		return horasTrabajadas*precioHora;
	}
	
	
	
}
