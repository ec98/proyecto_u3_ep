package com.uce.edu.demo.hilos.paralelo.peaje;

import java.util.List;

public class PeajeParalelo {

	private double costo = 0.60;
	private List<String> autos;

	public PeajeParalelo(double costo, List<String> autos) {
		super();
		this.costo = costo;
		this.autos = autos;
	}

	// GET Y SET
	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public List<String> getAutos() {
		return autos;
	}

	public void setAutos(List<String> autos) {
		this.autos = autos;
	}

}
