package com.uce.edu.demo.hilos.paralelo.peaje;

import java.util.Arrays;

public class MainPeajeParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long tiempoInicial = System.currentTimeMillis();

		PeajeParalelo pp1 = new PeajeParalelo(1.00, Arrays.asList("Auto1", "Auto2", "Auto3"));
		PeajeParalelo pp2 = new PeajeParalelo(0.60, Arrays.asList("Moto1", "Moto2", "Moto3"));
		PeajeParalelo pp3 = new PeajeParalelo(0.40, Arrays.asList("Camion1", "Camion2", "Camion3"));
		PeajeParalelo pp4 = new PeajeParalelo(1.50, Arrays.asList("Camioneta1", "Camioneta2", "Camioneta3"));
		PeajeParalelo pp5 = new PeajeParalelo(2.00, Arrays.asList("Trailer1", "Trailer2", "Trailer3"));

		// Procesando 5 hilos sincronos
		PCPeajeParalelo gestorAtencion = new PCPeajeParalelo();
		gestorAtencion.procesarCompra(pp1);

		PCPeajeParalelo gestorAtencion2 = new PCPeajeParalelo();
		gestorAtencion2.procesarCompra(pp2);

		PCPeajeParalelo gestorAtencion3 = new PCPeajeParalelo();
		gestorAtencion3.procesarCompra(pp3);

		PCPeajeParalelo gestorAtencion4 = new PCPeajeParalelo();
		gestorAtencion4.procesarCompra(pp4);

		PCPeajeParalelo gestorAtencion5 = new PCPeajeParalelo();
		gestorAtencion5.procesarCompra(pp5);

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println(tiempoTranscurrido + " segundos en procesar el peaje");

	}

}
