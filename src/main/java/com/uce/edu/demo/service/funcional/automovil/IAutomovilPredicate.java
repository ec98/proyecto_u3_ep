package com.uce.edu.demo.service.funcional.automovil;

@FunctionalInterface
public interface IAutomovilPredicate<T> {

	public boolean evaluar(T arg1);
}
