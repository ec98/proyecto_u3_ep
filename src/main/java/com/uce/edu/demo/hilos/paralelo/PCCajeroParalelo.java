package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class PCCajeroParalelo extends Thread {

	// declarar un atributo/atributos
	private CajeroParalelo cajero;

	// Constructor para enviar el objeto
	public PCCajeroParalelo(CajeroParalelo cajeroParalelo) {
		this.cajero = cajeroParalelo;
	}

	// Disparar el metodo a paralelizar
	@Override
	public void run() {
		this.procesar(this.cajero);
	}

	public void procesar(CajeroParalelo cajero) {
		long tiempoInicial = System.currentTimeMillis();

		System.out.println("Nombre Hilo Procesar: " + Thread.currentThread().getName());
		System.out.println("Procesando Cajero: " + cajero.getNombre());
		for (String cliente : cajero.getClientes()) {
			this.atenderCliente(cliente);
		}
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println("Finalizo: " + cajero.getNombre() + " en: " + tiempoTranscurrido + "segundos");

	}

	private void atenderCliente(String cliente) {
		System.out.println("Atendiendo a: " + cliente);
		// Demorar el metodo 10 seconds
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
