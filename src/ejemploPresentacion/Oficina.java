package ejemploPresentacion;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Oficina {

	List<Empleado> lista= new ArrayList<Empleado>();

	public Oficina(List<Empleado> lista) {
		super();
		this.lista = lista;
	}

	public List<Empleado> getLista() {
		return lista;
	}
	public void setLista(List<Empleado> lista) {
		this.lista = lista;
	}
	
	@Override
	public String toString() {
		return "Oficina [lista=" + lista + "]";
	}
	//Crear un empleado
	public void crear(Empleado e) {
		lista.add(e);
	}
	//Borrar un empleado
	public void borrar(Empleado e) {
		lista.remove(e);
	}
	//Editar horas trabajadas de un empleado
	public void editHoras(Empleado e, double nuevasHorasTrab) {
		e.setHorasTrabajadas(nuevasHorasTrab);
	}
	//Método findV1 con el dni como criterio de busqueda
	public Empleado findByDNIV1(String dniBusq) {
		for(Empleado e : lista) {
			if(e.getDni().equalsIgnoreCase(dniBusq)) {
				return e;
			}
		}
		return null;
	}
	//Método findV2 con el dni como criterio de busqueda (usando stream y lambda)
	public Empleado findByDNIV2(String dniBusq) {
		Predicate<Empleado> filtrar = e -> e.getDni().equalsIgnoreCase(dniBusq);
		return lista.stream()
			//.filter(e -> e.getDni().equalsIgnoreCase(dniBusq))
			.filter(filtrar)
			.findFirst()
			.get();
	}
	//Imprimir toda la lista
	public void imprimirLista() {
		//lista.forEach(e -> System.out.println(e));
		lista.forEach(System.out::println);
	}
	//Imprimir un empleado
	public void imprimirUnEmpleado(Empleado e) {
		if(e!=null){
			System.out.println(e);
		}else {
			System.out.println("No se ha encontrado");
		}
	}
	//Carga unos empleados predeterminados al iniciar el programa
	public void cargarLista(double porcentjeGerenteExtr) {
		lista.add(new Empleado("123A", "Alexander", 21, 152));
		lista.add(new Empleado("456B", "Sebastián", 22, 96));
		lista.add(new Empleado("789C", "Angel", 46, 123));
		lista.add(new Empleado("321D", "Rafa", 69, 75));
		lista.add(new Gerente("654E","Luismi",120,200,porcentjeGerenteExtr));
	}
	//Introduciendole un Empleado nos devuelve true o false si es mayor de X años o no
	public boolean comprobarMayoriaEdad(Empleado e, int mayorQue) {
		Predicate<Integer> mayoria = edad -> edad > mayorQue;
		return mayoria.test(e.getEdad());
	}
	//Método de imprimir el resultado "en bonito" de la comprobación anterior de la edad
	public void imprimirFelicitacionEdad(boolean comprobarEdad) {
		if(comprobarEdad) {
			System.out.println("¡FELICIDADES, TE QUEDAN POCOS AÑOS PARA LA JUBILACIÓN!");
		}else{
			System.out.println("Todavía es demasiado pronto, ya llegará tu hora");
		}
	}
	//Ordenar la lista por nombre
	public void ordenarPorNombre() {
		lista.sort((e1,e2) -> e1.getNombre().toLowerCase().compareTo(e2.getNombre().toLowerCase()));
	}
	//Calcular sueldo de un empleado de la oficina V1
	public double calcularSueldoUnTrabajadorV1(Empleado e, double precioHora) {
		return e.calcularSueldo(precioHora);
	}
	//Calcular sueldo de un empleado de la oficina V2 usando la interfaz funcional BiFunction y referencias a métodos
	public double calcularSueldoUnEmpleadoV2(Empleado e, double sueldoHora) {
		BiFunction<Empleado, Double, Double> calculo = Empleado::calcularSueldo;
		return calculo.apply(e, sueldoHora);
	}
	//Nos devuelve el empleado cuya edad sea la mayor
	public Empleado comprobarMayor() {
		Empleado e= new Empleado();
		Function<Empleado, Empleado> trabajadorMayor= (mayor) -> {
			int i=0;
			mayor=lista.get(0);
			while(i<lista.size()) {
				if(lista.get(i).getEdad()>mayor.getEdad()) {
					mayor=lista.get(i);
				}
				i++;
			}
			return mayor;
		};
		return trabajadorMayor.apply(e);
	}
	//Nos devuelve una lista con los empleados mayores a X años
	public List<Empleado> listarMayores (int mayorQue){
		Supplier <List<Empleado>> listaMayores = () -> {
				List <Empleado> encontrado = new ArrayList <Empleado>();
				for (Empleado e : lista) {
					if(e.getEdad()>mayorQue) {
						encontrado.add(e);
					}
				}
				return encontrado;
		};
		return listaMayores.get();
	}
	//Calcula la media de los sueldos de los empleados
	public double calcularMediaSueldo(double sueldoHora) {
		double suma=0;
		BiFunction <Double, Double, Double> op = (n1, n2) -> {
			for (Empleado e : lista) {
				n1+=calcularSueldoUnEmpleadoV2(e, n2);
			}
			return n1/lista.size();
		};
		return op.apply(suma, sueldoHora);
	}
	//Calcula cuánto dinero se ha gastado la empresa en sueldos
	public Double calcularGastosSueldos(double precioHora) {
		double gastoTotal=0.0;
		Function<Double, Double> gastoSueldo= gasto -> {
			for(Empleado e : lista) {
				gasto+=calcularSueldoUnTrabajadorV1(e, precioHora);
			}
			return gasto;
		};
		return gastoSueldo.apply(gastoTotal);
	}
}
