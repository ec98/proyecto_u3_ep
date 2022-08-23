package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IPersonaConsumer<T> {
	
	//declarar la variable generica
	public void accept(T arg1);
}
