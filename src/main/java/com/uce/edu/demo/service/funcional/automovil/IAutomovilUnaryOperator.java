package com.uce.edu.demo.service.funcional.automovil;

@FunctionalInterface
public interface IAutomovilUnaryOperator<T> {

	T apply(T arg1);
}
