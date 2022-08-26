package com.uce.edu.demo.service.funcional.automovil;

import java.math.BigDecimal;

public class ConsumirMetodosHighOrder {

	public BigDecimal consumirSupplier(IAutomovilSupplier<BigDecimal> funcion) {
		BigDecimal valor = funcion.getCosto();
		return valor;
	}

	public void consumirConsumer(IAutomovilConsumer<Integer> funcion, Integer valor) {
		funcion.accept(valor);
	}

	public Boolean consumirPredicate(IAutomovilPredicate<String> funcion, String valor) {
		return funcion.evaluar(valor);
	}

	public String consumirFunction(IAutomovilFunction<Integer, String> funcion, Integer valor) {
		return funcion.aplicar(valor);
	}

	public String consumirUnaryOperator(IAutomovilUnaryOperator<String> funcion, String valor) {
		return funcion.apply(valor);
	}
}
