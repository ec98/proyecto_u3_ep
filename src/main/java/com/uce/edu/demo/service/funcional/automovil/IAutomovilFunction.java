package com.uce.edu.demo.service.funcional.automovil;

@FunctionalInterface
public interface IAutomovilFunction<T, R> {

	R aplicar(T arg1);
}
