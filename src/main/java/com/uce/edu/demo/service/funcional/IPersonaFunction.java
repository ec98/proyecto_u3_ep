package com.uce.edu.demo.service.funcional;
 

/**
 * 
 * @author Carlos
 *
 * @param <T>
 * @param <R>
 */
@FunctionalInterface
public interface IPersonaFunction<T,R> {

	R aplicar(T arg1);
}
