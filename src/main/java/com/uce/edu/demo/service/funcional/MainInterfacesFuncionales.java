package com.uce.edu.demo.service.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {
	private static final Logger Logger = LoggerFactory.getLogger(MainInterfacesFuncionales.class);

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
		 * JAVA tiene la herramienta necesaria para trabajar con LAMBDAS
		 */

		// CONSUMER
		// Clases
		IPersonaConsumer<String> consumer = new PersonaConsumerImpl();
		consumer.accept("Prueba Consumer");

		// Lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");

		// Metodos High Order
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 2);

		// PREDICATE
		// Clases
		// Lambdas
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("z");
		Logger.info("Predicate Lambda -> " + predicateLambda.evaluar("Edwinz"));

		// Metodos High Order
		boolean resultado = metodosHO.consumirPredicate(cadena -> cadena.contains("z"), "Edwzin"); // compara el dato
		Logger.info("High Order Predicate  -> " + resultado);

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
