package com.uce.edu.demo.service.funcional;

/**
 * 
 * @author Carlos
 * Recomendar usar la anotacion @FunctionalInterface
 */
@FunctionalInterface
public interface IPersonaSupplier<T> {
	
	public T getNombre(); //obtiene el tipo de dato respecto a que va a obtener.
}
