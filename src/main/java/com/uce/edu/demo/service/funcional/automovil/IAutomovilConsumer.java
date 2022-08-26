package com.uce.edu.demo.service.funcional.automovil;

@FunctionalInterface
public interface IAutomovilConsumer<T> {

	public void accept(T arg1);
}
