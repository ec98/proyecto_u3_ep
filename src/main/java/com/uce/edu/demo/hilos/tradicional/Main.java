package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial = System.currentTimeMillis();
		
		System.out.println("Nombre Hilo: "+Thread.currentThread().getName());
		Cajero cajero1 = new Cajero("Banco Pichincha", Arrays.asList("Domenica","Carla"));
		Cajero cajero2 = new Cajero("Banco de Guayaquil", Arrays.asList("Domenica2","Carla3"));
		Cajero cajero3 = new Cajero("Banco del Austro", Arrays.asList("Domenica3","Carla2"));
		
		//Banco Pichincha
		PCCajero gestorAtencion = new PCCajero();
		gestorAtencion.procesar(cajero1); //termina de procesar el hilo
		
		//Banco de Guayaquil
		PCCajero gestorAtencion2 = new PCCajero();
		gestorAtencion2.procesar(cajero2);
		
		//Banco del Austro
		PCCajero gestorAtencion3 = new PCCajero();
		gestorAtencion3.procesar(cajero3);
		
		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000;
		
		System.out.println(tiempoTranscurrido+" segundos");
		
	}

}
