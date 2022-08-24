package com.uce.edu.demo.service.funcional;
/**
 * 
 * @author Carlos
 * Mandas el comportamiento a cada funcion lambda, respetando los parametros.
 */
public class ConsumoMetodosHighOrder {

	// Integer.
	public String consumirSupplier(IPersonaSupplier<String> funcion) {
		/**
		 * String valor = funcion.getNombre(); // calcular/sumar/consultar/etc Integer
		 * numero = Integer.parseInt(valor); return numero;
		 */
		return funcion.getNombre() + "Se proceso el dato";
	}

	public void consumirConsumer(IPersonaConsumer<Integer> funcion, Integer valor) {

		funcion.accept(valor);
	}

	public Boolean consumirPredicate(IPersonaPredicate<String> funcion, String valor) {

		return funcion.evaluar(valor);
	}

	public String consumirFunction(IPersonaFunction<Integer, String> funcion, Integer valor) {

		return funcion.aplicar(valor);
	}
}
