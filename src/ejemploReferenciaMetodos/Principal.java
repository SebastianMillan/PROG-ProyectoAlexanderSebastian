package ejemploReferenciaMetodos;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Principal {

	public static void main(String[] args) {
	
		//Métodos estáticos
		Consumer <String> imprime = s -> imprimirMensaje(s);
		
		Consumer <String> imprime2 = Principal::imprimirMensaje;
		
		imprime.accept("Alex");
		imprime2.accept("Pepe");
		
		BinaryOperator <String> imprimeNombre = (s1, s2) -> s1.concat(s2);
		BinaryOperator <String> imprimeNombre2 = String::concat;
		
		System.out.println(imprimeNombre.apply("Pepe", "Pérez"));
		System.out.println(imprimeNombre2.apply("Pablo", "Pérez"));
		
		//Instancia de un Objeto
		Function <Persona, String> sacaNombre = p -> p.getNombre();
		
		Persona p1 = new Persona ("Javier");
		//Supplier <String> sacaNombre2 = () -> p1.getNombre();
		Supplier <String> sacaNombre2 = p1::getNombre;
		
		System.out.println(sacaNombre2.get());
		
		//Métodos de un objeto
		Function <Persona, Integer> contador = (p) -> p.contarLetras();
		
		Function <Persona, Integer> contador2 = Persona::contarLetras;
		
		System.out.println(contador2.apply(p1));
		
		//Constructores 
		Supplier<Persona> nuevaPersona = () -> new Persona();
		Supplier<Persona> nuevaPersona2 = Persona::new; 
		
		Function <String, Persona> nuevaPersonaConNombre = Persona::new;
		
		Persona p2=nuevaPersonaConNombre.apply("Joaquín");
		System.out.println(p2);
 	}
		
	public static void imprimirMensaje(String nombre) {
		System.out.println("Hola "+nombre);
	}
}
