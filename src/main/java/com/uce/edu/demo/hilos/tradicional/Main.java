package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial = System.currentTimeMillis();
		
		Cajero cajero1 = new Cajero("Banco Pichincha", Arrays.asList("Domenica","Carla","Ninett","Maria","Ana"));
		Cajero cajero2 = new Cajero("Banco de Guayaquil", Arrays.asList("Belen","Karen","Layla","Luna","Mishell"));
		Cajero cajero3 = new Cajero("Banco del Austro", Arrays.asList("Monica","Dianela","Laura","Victoria","Gabriela"));
		
		PCCajero gestorAtencion = new PCCajero();
		gestorAtencion.procesar(cajero1);
		gestorAtencion.procesar(cajero2);
		gestorAtencion.procesar(cajero3);
		
		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000;
		
		System.out.println(tiempoTranscurrido+" segundos");
		
	}

}
