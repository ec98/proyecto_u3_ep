package com.uce.edu.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Detalle;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.service.IFacturaService;

@SpringBootApplication
public class ProyectoU3EpApplication implements CommandLineRunner {

	private static final Logger Logger = LoggerFactory.getLogger(ProyectoU3EpApplication.class);

	@Autowired
	private IFacturaService iFacturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3EpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// Exercise aditional
		Logger.info("INNER JOIN EAGER/LAZY");
		List<Factura> listHoteles2 = this.iFacturaService.buscarDescripcionInnerJoinWithLazyEager("Comida elegante");
		for (Factura f : listHoteles2) {
			// EAGER WITH SONS
			Logger.info("Descripcion v2 -> " + f.getCedula() + " " + f.getApellido());
			// LAZY
			for (Detalle de : f.getDetalles()) {
				Logger.info("Detalles v2 -> " + de);
			}
		}

		Logger.info("WHERE JOIN");
		List<Factura> listFactura = this.iFacturaService.buscarDescripcionWhereJoin("Comida rapida");
		for (Factura f : listFactura) {
			Logger.info("Descripcion -> " + f.getCedula() + " " + f.getApellido());
		}

		Logger.info("FECTH JOIN");
		// Usare la funcion LAZY para tener una busqueda mas eficiente que la funcion
		// EAGER
		List<Factura> listFactura2 = this.iFacturaService.buscarDescripcionJoinFetch("Comida elegante");
		for (Factura f : listFactura2) {
			Logger.info("Descripcion -> " + f.getCedula() + " " + f.getApellido());
			for (Detalle de : f.getDetalles()) {
				Logger.info("Detalles 2 -> " + de);
			}
		}

	}

}
