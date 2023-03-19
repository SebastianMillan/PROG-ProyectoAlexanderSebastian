package ejemploInterfazFuncional;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Principal {

	public static void main(String[] args) {

		String nombre = "Alex", apellido = "Luque";
		double n1 = 8, n2 = 5;

		// Ejemplo 1

		IOperaciones suma = (x, y) -> x + y;
		IOperaciones resta = (x, y) -> x - y;
		IOperaciones multi = (x, y) -> x * y;
		IOperaciones division = (x, y) -> x / y;

		System.out.println(n1 + "+" + n2 + " = " + suma.operar(n1, n2));
		System.out.println(n1 + "-" + n2 + " = " + resta.operar(n1, n2));
		System.out.println(n1 + "x" + n2 + " = " + multi.operar(n1, n2));
		System.out.println(n1 + "/" + n2 + " = " + division.operar(n1, n2));

		BiFunction<Double, Double, Double> suma2 = (x, y) -> x + y;
		System.out.println(suma2.apply(n1, n2));
		BinaryOperator<Double> resta2 = (x, y) -> x - y;
		System.out.println(resta2.apply(n1, n2));

		// Ejemplo 2
		BiConsumer<String, String> imprime = (s1, s2) -> {
			System.out.println(nombre + " " + apellido);
		};

		imprime.accept(nombre, apellido);

		Supplier<String> palabraNueva = () -> "Alejandro";
		System.out.println(palabraNueva.get());

		BiPredicate<String, Integer> palabraIgual = (s, n) -> s.length() == n;
		System.out.println(palabraIgual.test(apellido, 5));
	}

}
