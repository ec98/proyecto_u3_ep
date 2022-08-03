package com.uce.edu.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		Logger.info("INNER JOIN");
//		List<Hotel> listHotels = this.iHotelService.buscarHotelInnerJoin("Matrimonial");
		List<Hotel> listHotels = this.iHotelService.buscarHotelInnerJoin("Familiar");

		for (Hotel h : listHotels) {
			Logger.info("Hotel -> " + h.getNombre() + " " + h.getDireccion());
		}

		List<Hotel> listHotels2 = this.iHotelService.buscarHotelInnerJoin();

		for (Hotel h : listHotels2) {
			Logger.info("Hotel v2 -> " + h.getNombre() + " " + h.getDireccion());
		}

		// LEFT JOIN
		Logger.info("LEFT JOIN");

		List<Hotel> listHotelsleft = this.iHotelService.buscarHotelLeftOuterJoin("Familiar");

		for (Hotel h : listHotelsleft) {
			Logger.info("Hotel -> " + h.getNombre() + " " + h.getDireccion());
		}

		List<Hotel> listHotelsleft2 = this.iHotelService.buscarHotelLeftOuterJoin();

		for (Hotel h : listHotelsleft2) {
			Logger.info("Hotel v2-> " + h.getNombre() + " " + h.getDireccion());
		}

		// RIGHT JOIN
		Logger.info("RIGHT JOIN");

		List<Hotel> listHotelsright = this.iHotelService.buscarHotelRightOuterJoin("Familiar");

		for (Hotel h : listHotelsright) {
			Logger.info("Hotel -> " + h.getNombre() + " " + h.getDireccion());
		}
	}

}
