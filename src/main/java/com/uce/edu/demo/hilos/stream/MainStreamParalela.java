package com.uce.edu.demo.hilos.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainStreamParalela {
	public static void main(String[] args) {

		long tiempoInicial = System.currentTimeMillis();

		List<Integer> listaNumerosAlumnos = new ArrayList<>();

		for (int i = 0; i < 5000; i++) {
			listaNumerosAlumnos.add(i);
		}
		// .collect(Collectors.toList()); convertir lista de Strings
//		listaNumerosAlumnos.stream().map(numero -> convertirIdAlumno(numero)).collect(Collectors.toList());
		/**
		 * Stream a parallelStream
		 */
		List<String> listaProcess = listaNumerosAlumnos.parallelStream().map(numero -> convertirIdAlumno(numero))
				.collect(Collectors.toList());
		listaProcess.forEach(cadena -> System.out.println(cadena));

		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println(tiempoTranscurrido + " segundos");

	}

	private static String convertirIdAlumno(Integer id) {
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ID -> " + id.toString();
	}
}
