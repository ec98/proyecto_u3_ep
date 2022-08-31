package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {
		long tiempoInicial = System.currentTimeMillis();

		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		//demora dependiendo cuantos clientes y con el tiempo asignado.
		CajeroParalelo cajero1 = new CajeroParalelo("Banco Pichincha", Arrays.asList("Domenica"));
		CajeroParalelo cajero2 = new CajeroParalelo("Banco de Guayaquil", Arrays.asList("Domenica2"));
		CajeroParalelo cajero3 = new CajeroParalelo("Banco del Austro", Arrays.asList("Domenica3"));

		CajeroParalelo cajero4 = new CajeroParalelo("Banco Pichincha", Arrays.asList("Carla"));
		CajeroParalelo cajero5 = new CajeroParalelo("Banco de Guayaquil", Arrays.asList("Carla2"));
		CajeroParalelo cajero6 = new CajeroParalelo("Banco del Austro", Arrays.asList("Carla3"));

		// asincrona en cada hilo de procesamiento

		// Banco Pichincha
		PCCajeroParalelo gestorAtencion = new PCCajeroParalelo(cajero1);
		gestorAtencion.start();// procesar

		// Banco de Guayaquil
		PCCajeroParalelo gestorAtencion2 = new PCCajeroParalelo(cajero2);
		gestorAtencion2.start(); // procesar

		// Banco del Austro
		PCCajeroParalelo gestorAtencion3 = new PCCajeroParalelo(cajero3);
		gestorAtencion3.start(); // procesar

		// Banco Pichincha
		PCCajeroParalelo gestorAtencion4 = new PCCajeroParalelo(cajero4);
		gestorAtencion4.start(); // procesar

		// Banco de Guayaquil
		PCCajeroParalelo gestorAtencion5 = new PCCajeroParalelo(cajero5);
		gestorAtencion5.start(); // procesar

		// Banco del Austro
		PCCajeroParalelo gestorAtencion6 = new PCCajeroParalelo(cajero6);
		gestorAtencion6.start(); // procesar

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println(tiempoTranscurrido + " segundos");
	}
}
