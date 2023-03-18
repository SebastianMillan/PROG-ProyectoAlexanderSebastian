package ejemploPresentacion;

import java.util.ArrayList;

import utilidades.Leer;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Oficina of = new Oficina(new ArrayList<Empleado>());
		String dniSelec;
		int opcion=0, mayorA=60, mayorEdadSelec=0, edad, opcion2;
		double horasTrabNuevas=0.0, precioHora=0.0, porcExtra;
		String nombre, dni;
		double horasTrabajadas;
		
		
		System.out.println("----------------------------------------------");
		System.out.println("BIENVENIDO AL PROGRAMA DE GESTIÓN DE EMPLEADOS");
		System.out.println("----------------------------------------------");
		
		System.out.println("Introduzca el porcentaje extra que cobra un gerente");
		porcExtra=Leer.datoDouble();
		
		of.cargarLista(porcExtra);
		do {
			System.out.println("1 - Mostrar empleados");
			System.out.println("2 - Añadir empleado");
			System.out.println("3 - Eliminar empleado");
			System.out.println("4 - Editar horas trabajadas de un empleado");
			System.out.println("5 - Calcular sueldo un empleado");
			System.out.println("6 - Comprobar si empleado es mayor de 60");
			System.out.println("7 - Imprimir empleado con mayor edad");
			System.out.println("8 - Imprimir todos los empleados mayores a una edad seleccionada");
			System.out.println("9 - Ordenar por nombre la lista");
			System.out.println("10 - Calcular gasto en sueldos de la oficina");
			System.out.println("11 - Calcular media de sueldos");
			System.out.println("0 - Salir");
			opcion=Leer.datoInt();
			switch(opcion) {
				case 1:
					of.imprimirLista();
					break;
				case 2:
					System.out.println("Introduzca el dni del empleado");
					dni=Leer.dato();
					System.out.println("Introduzca el nombre");
					nombre=Leer.dato();
					System.out.println("Indique la edad");
					edad=Leer.datoInt();
					System.out.println("Introduzca las horas trabajadas este mes");
					horasTrabajadas=Leer.datoDouble();
					System.out.println("Pulse 1 si es un Gerente o pulse otro número si es un empleado");
					opcion2=Leer.datoInt();
					if(opcion2==1) {
						of.crear(new Empleado(dni, nombre, edad, horasTrabajadas));
					}else {
						of.crear(new Gerente(dni, nombre, edad, horasTrabajadas, porcExtra));
					}
					break;
				case 3:
					of.imprimirLista();
					System.out.println("Indique el dni del empleado que desea eliminar");
					dniSelec=Leer.dato();
					of.borrar(of.findByDNIV2(dniSelec));
					break;
				case 4:
					of.imprimirLista();
					System.out.println("Indique el dni del empleado que desea editar sus horas trabajadas");
					dniSelec=Leer.dato();
					System.out.println("Indique las nuevas horas trabajadas para incluirselas a dicho trabajador");
					horasTrabNuevas=Leer.datoDouble();
					of.editHoras(of.findByDNIV1(dniSelec), horasTrabNuevas);
					break;
				case 5:
					of.imprimirLista();
					System.out.println("Indique el dni del empleado para mostrar su sueldo");
					dniSelec=Leer.dato();
					System.out.println("Indique a cuánto se paga en euros la hora:");
					precioHora=Leer.datoDouble();
					System.out.printf("Sueldo: %.2f€\n", of.calcularSueldoUnEmpleadoV2(of.findByDNIV2(dniSelec), precioHora));
					break;
				case 6:
					of.imprimirLista();
					System.out.println("Indique el dni del empleado para comprobar si es mayor a"+mayorA+" años");
					dniSelec=Leer.dato();
					of.imprimirFelicitacionEdad(of.comprobarMayoriaEdad(of.findByDNIV2(dniSelec), mayorA));
					break;
				case 7:
					of.imprimirUnEmpleado(of.comprobarMayor());
					break;
				case 8:
					System.out.println("Indique la edad mínima que deben de tener los empleados a imprimir:");
					mayorEdadSelec=Leer.datoInt();
					of.listarMayores(mayorEdadSelec).forEach(e -> System.out.println(e));
					break;
				case 9:
					of.ordenarPorNombre();
					of.imprimirLista();
					break;
				case 10:
					System.out.println("Indique a cuánto se paga en euros la hora:");
					precioHora=Leer.datoDouble();
					System.out.printf("La oficina gasta en sueldos %.2f€\n", of.calcularGastosSueldos(precioHora));					
					break;
				case 11:
					System.out.println("Indique a cuánto se paga en euros la hora:");
					precioHora=Leer.datoDouble();
					System.out.printf("La media de sueldos de la oficina es de %.2f€\n", of.calcularMediaSueldo(precioHora));
					break;
				case 0:
					System.out.println("Saliendo del programa");
					break;
				default:
					System.out.println("Opción del menú no encontrada");
					break;
			}
		}while(opcion!=0);
		
		System.out.println("--------------------------------");
		System.out.println("Gracias por utilizar el programa");
	}
}
