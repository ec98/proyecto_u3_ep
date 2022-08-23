package com.uce.edu.demo.service.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {
	private static final Logger Logger = LoggerFactory.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {

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

		// PREDICATE
		// Clases
		// Lambdas

		// FUNCTION
		// Clases
		// Lambdas

		// UNARY OPERATOR (FUNCTION)
		// Clases
		// Lambdas
	}
}
