package com.uce.edu.demo.hilos.paralelo.peaje;

import java.util.concurrent.TimeUnit;

public class PCPeajeParalelo extends Thread {

	public void procesarCompra(PeajeParalelo paralelo) {
		long tiempoInicial = System.currentTimeMillis();

		System.out.println("Nombre hilo a procesar-> " + Thread.currentThread().getName());
		System.out.println("Procesando peaje -> $" + paralelo.getCosto());
		for (String autos : paralelo.getAutos()) {
			this.tomandoAutos(autos);
		}
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		if (paralelo.getCosto() == 1.00) {
			paralelo.setCosto(3.00);
		} else if (paralelo.getCosto() == 0.60) {
			paralelo.setCosto(1.80);
		} else if (paralelo.getCosto() == 0.40) {
			paralelo.setCosto(1.20);
		} else if (paralelo.getCosto() == 1.50) {
			paralelo.setCosto(4.50);
		} else if (paralelo.getCosto() == 2.00) {
			paralelo.setCosto(6.00);
		}
		System.out.println("Finalizo peaje con costos de $" + paralelo.getCosto() + " con " + paralelo.getAutos()
				+ " en " + tiempoTranscurrido + " segundos");
	}

	private void tomandoAutos(String auto) {
		System.out.println("Atendiendo auto -> " + auto);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
