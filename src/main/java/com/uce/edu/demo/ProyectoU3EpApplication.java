package com.uce.edu.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3EpApplication implements CommandLineRunner {

	private static final Logger Logger = LoggerFactory.getLogger(ProyectoU3EpApplication.class);

	@Autowired
	private IHotelService iHotelService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3EpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Logger.info("RELACIONAMIENTO WHERE");
		List<Hotel> listHoteles = this.iHotelService.buscarHotelWhereJoin("Familiar");
		for (Hotel h : listHoteles) {
			Logger.info("Hotel -> " + h.getNombre() + " " + h.getDireccion());
		}

		Logger.info("INNER JOIN EAGER/LAZY");
		List<Hotel> listHoteles2 = this.iHotelService.buscarHotelInnerJoin("Matrimonial");
		for (Hotel h : listHoteles2) {
			// EAGER WITH SONS
			Logger.info("Hotel 2 -> " + h.getNombre() + " " + h.getDireccion());
			// LAZY
			for (Habitacion ha : h.getHabitaciones()) {
				Logger.info("Habitaciones 2 -> " + ha);
			}
		}

		Logger.info("JOIN FETCH");
		// esta configuracion es con LAZY, la mas eficiente en una sola busqueda.
		List<Hotel> listHoteles3 = this.iHotelService.buscarHotelFetchJoin("Matrimonial");
		for (Hotel h : listHoteles3) {
			Logger.info("Hotel 3 -> " + h.getNombre() + " " + h.getDireccion());
			for (Habitacion ha : h.getHabitaciones()) {
				Logger.info("Habitaciones3 -> " + ha);
			}
		}

	}

}
