package com.uce.edu.demo.service.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {
	private static final Logger Logger = LoggerFactory.getLogger(MainInterfacesFuncionales.class);

	public static boolean prueba(Integer numero) {
		return numero >= 3;
	}

	// siempre usar el static, porque el main trabaja con static.
	public static void imprimir(String cadena) {
		Logger.info("Impresion ->" + cadena);

	}

	public static void guardar(String elementoAInsertar) {
		// Consumero del repository para guardar.
	}

	public static void main(String[] args) {

		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();

		// SUPPLIER
		// Podemos realizar implementaciones de clases
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		Logger.info("I.F Supplier Class ->" + supplier.getNombre());

		IPersonaSupplier<String> supplierTE = new PersonaSupplierTEImpl();
		Logger.info("I.F Supplier TE ->" + supplierTE.getNombre());

		// Lambdas
		IPersonaSupplier<String> supplierLambda = () -> "Edwin 2";
		Logger.info("I.F Supplier Lambda ->" + supplierLambda.getNombre());

		IPersonaSupplier<String> supplierLambdaTE = () -> "Daniela TE 2";
		Logger.info("I.F Supplier Lambda TE ->" + supplierLambdaTE.getNombre());

		// Metodos High Order
		String valorHO = metodosHO.consumirSupplier(() -> "Hola mundo ");
		Logger.info("High Order Supplier -> " + valorHO);

		String valorH1 = metodosHO.consumirSupplier(() -> {
			String valorEncontrado = "1218282811 ";
			return valorEncontrado;
		});
		Logger.info("HO Supplier -> " + valorH1);

		/**
		 * JAVA: tiene la herramienta necesaria para trabajar con LAMBDAS //Supplier
		 */
		Logger.info("JAVA Supplier");
		Stream<String> test = Stream.generate(() -> "Edwin v1").limit(7);// supplier
		test.forEach(cadena -> System.out.println(cadena)); // consumer

		// CONSUMER
		// Clases
		IPersonaConsumer<String> consumer = new PersonaConsumerImpl();
		consumer.accept("Prueba Consumer");

		// Lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");

		// Metodos High Order
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 2);

		/**
		 * JAVA Consumer
		 */
		Logger.info("JAVA Consumer");
		List<Integer> listNumeros = Arrays.asList(1, 2, 3, 4, 5);
		listNumeros.forEach(numero -> System.out.println(numero));

		// PREDICATE
		// Clases
		// Lambdas
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("z");
		Logger.info("Predicate Lambda -> " + predicateLambda.evaluar("Edwinz"));

		// Metodos High Order
		boolean resultado = metodosHO.consumirPredicate(cadena -> cadena.contains("z"), "Edwzin"); // compara el dato
		Logger.info("High Order Predicate  -> " + resultado);

		/**
		 * JAVA Predicate
		 */
		Logger.info("JAVA Predicate"); // se utiliza para condiciones.
		// filter recibe predicate.
		// listNumeros.stream().filter(numero -> numero >= 3);
		Stream<Integer> nuevalista = listNumeros.stream().filter(numero -> prueba(numero));
		nuevalista.forEach(numero -> System.out.println(numero));

		// FUNCTION
		// Clases
		// Lambdas
		IPersonaFunction<String, Integer> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorfinal = valor - 2;
			return valorfinal;
			// return Integer.parseInt(cadena) - 2;
		};
		Logger.info("Function Lambda -> " + functionLambda.aplicar("7"));

		// Metodos High Order
		String valorFinalHO = metodosHO.consumirFunction(valor -> {
			String retorn = valor.toString() + "A";
			// calculos de lambdas
			return retorn;
		}, 1);
		Logger.info("High Order Function Lambda -> " + valorFinalHO);

		/**
		 * JAVA FUNCTION
		 */
		Logger.info("JAVA Function");
		// Conversiones/cast Objeto -> ObjetoDTO (Ligero)
		// listNumeros.stream().map(numerosList -> {
		Stream<String> listaCambio = listNumeros.stream().map(numerosList -> {
			Integer valor = numerosList + 1;
			String cadena = "num: " + valor.toString();
			return cadena;
		});
		/**
		 *  Declarativa: ideas/intenciones
		 */
//		listaCambio.forEach(valor -> System.out.println(valor));
		listaCambio.forEach(valor -> imprimir(valor));
//		listaCambio.forEach(valor -> guardar(valor));

		/**
		 *  Imperativa: paso a paso
		 */
//		for(String valor:) {
//			imprimir(valor);
//		}

		/**
		 * Eficiente y mejor rendimiento.
		 */
//		List<String> lista1= new ArrayList<String>();
//		Map<String, String> map1 = new HashMap<String, String>();

		// UNARY OPERATOR (FUNCTION)
		// Clases
		// Lambdas
		IPersonaUnaryOperator<String> unaryOperatorLambda = cadena -> {
			String valorFinal = cadena.concat("safari");
			return valorFinal;
		};
		Logger.info("Unary Operator Lambda -> " + unaryOperatorLambda.apply("Carlos "));
	}
}
