package com.uce.edu.demo.service.funcional.automovil;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuInterfazFuncional {
	private static final Logger Logger = LoggerFactory.getLogger(MenuInterfazFuncional.class);

	public static boolean retornar(String value) {
		return value.endsWith("i");
	}

	public static void imprimir(String name) {
		Logger.info("Mi auto -> " + name);
	}

	public static void main(String[] args) {

//		ConsumirMetodosHighOrder metodosHO = new ConsumirMetodosHighOrder();
//
//		// SUPPLIER
//		// Clase
//		IAutomovilSupplier<BigDecimal> supplierClass = new AutomovilSupplierImpl();
//		Logger.info("Supplier Class (costo) -> " + supplierClass.getCosto());
//
//		// Lambda
//		IAutomovilSupplier<BigDecimal> supplierLambda = () -> new BigDecimal("15000");
//		Logger.info("Supplier Lambda (costo) -> " + supplierLambda.getCosto());
//
//		// Metodo High Order
//		BigDecimal costo = metodosHO.consumirSupplier(() -> {
//			BigDecimal valorReal = new BigDecimal("350000");
//			return valorReal;
//		});
//		Logger.info("HO Supplier (costo) -> " + costo);

		/**
		 * JAVA SUPPLIER
		 */
		Logger.info("JAVA Supplier");
		Stream<Integer> miStream = Stream.generate(() -> 2400).limit(2); // debe contener un limite para que no sea
																			// infinito.
		miStream.forEach(cadena -> System.out.println(cadena));

//		// CONSUMER
//		// Clase
//		IAutomovilConsumer<String> consumerClass = new AutomovilConsumerImpl();
//		consumerClass.accept("Consumer Class lamborghini");
//
//		// Lambda
//		IAutomovilConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
//		consumerLambda.accept("Consumer Lambda lamborghini");
//
//		// Metodo High Order
//		metodosHO.consumirConsumer(valor -> System.out.println("HO Consumer " + valor + " <- valor real"), 450000);

		/**
		 * JAVA CONSUMER
		 */
		Logger.info("JAVA Consumer");
		List<String> milistAutos = Arrays.asList("Lamborghini", "Ferrari", "BMW Generacion X", "Porsche", "MClaren");
		milistAutos.forEach(autos -> System.out.println(autos));

//		// PREDICATE
//		// Clase
//		IAutomovilPredicate<Boolean> predicateClass = new AutomovilPredicateImpl();
//		Logger.info("Predicate Class valor -> " + predicateClass.evaluar(true));
//
//		// Lambda
//		IAutomovilPredicate<String> predicateLambda = cadena -> cadena.contains("2");
//		Logger.info("Predicate Lambda valor -> " + predicateLambda.evaluar("PDG-9412"));
//
//		// Metodo High Order
//		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("2"), "PDG-9411");
//		Logger.info("HO Predicate valor -> " + respuesta);

		/**
		 * JAVA PREDICATE
		 */
		Logger.info("JAVA Predicate");
		Stream<String> streamAuto = milistAutos.stream().filter(auto -> retornar(auto));
		streamAuto.forEach(verifica -> System.out.println(verifica));

//		// FUNCTION
//		// Clase
//		IAutomovilFunction<String, Integer> functionClass = new AutomovilFunctionImpl();
//		Logger.info("Function Class precio -> " + functionClass.aplicar("250000"));
//
//		// Lambda
//		IAutomovilFunction<String, Integer> functionLambda = cadena -> {
//			Integer precio = Integer.parseInt(cadena);
//			Integer precioFinal = precio * 15;
//			return precioFinal;
//		};
//		Logger.info("Function Lambda precio final -> " + functionLambda.aplicar("10000"));
//
//		// Metodo High Order
//		String prestamoFinalHO = metodosHO.consumirFunction(valor -> {
//			String uso = valor.toString() + " valor in 2023";
//			return uso;
//		}, 230000);
//		Logger.info("HO Function new value -> " + prestamoFinalHO);

		/**
		 * JAVA FUNCTION
		 */
		Logger.info("JAVA Function");
		Stream<String> miSAuto = milistAutos.stream().map(autosString -> {
			Integer costoAuto = 10000;
			String result = null;
			for (int i = 0; i <= 5; i++) {
				if (costoAuto >= 10000) {
					result = autosString + " $ " + costoAuto.toString(); // explicitar.
					costoAuto++;
					// retorna igual como un string.
				}
			}
			return result;
		});
		miSAuto.forEach(automovil -> imprimir(automovil));

//		// UNARY OPERATOR
//		// Clase
//		IAutomovilUnaryOperator<String> unaryOperatorClass = new AutomovilUnaryOperatorImpl();
//		Logger.info("Unary Operator Class -> " + unaryOperatorClass.apply("Nuevo Modelo Lamborghini"));
//
//		// Lambda
//		IAutomovilUnaryOperator<String> unaryOperatorLambda = cadena -> {
//			String modeloNuevo = cadena.concat(" SWX");
//			return modeloNuevo;
//		};
//		Logger.info("Unary Operator Lambda -> " + unaryOperatorLambda.apply("Lamborghini"));
//
//		// Modelo High Order
//		String modeloFinal = metodosHO.consumirUnaryOperator(cadena -> {
//			String auto = cadena.toString() + " Lamborghini X";
//			return auto;
//		}, "$540000");
//		Logger.info("HO Unary Operator -> " + modeloFinal);

	}
}
