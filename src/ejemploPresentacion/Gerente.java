package ejemploPresentacion;

public class Gerente extends Empleado{

	private double porcentExtra;

	public Gerente(String dni, String nombre, int edad, double horasTrabajadas, double porcentExtra) {
		super(dni, nombre, edad, horasTrabajadas);
		this.porcentExtra = porcentExtra;
	}

	public double getPorcentExtra() {
		return porcentExtra;
	}

	public void setPorcentExtra(double porcentExtra) {
		this.porcentExtra = porcentExtra;
	}

	@Override
	public String toString() {
		return super.toString()+"Gerente [porcentExtra=" + porcentExtra + "]";
	}

	@Override
	public double calcularSueldo(double precioHora) {
		return super.calcularSueldo(precioHora)+super.calcularSueldo(precioHora)*porcentExtra/100;
	}
	
	
	
}
