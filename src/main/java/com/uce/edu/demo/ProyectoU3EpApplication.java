package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

		Factura factura = new Factura();
		factura.setNombre("Edwin");
		factura.setApellido("Jaramillo");
		factura.setCedula("12928282811");
		factura.setFecha(LocalDateTime.now());

		Detalle detalle = new Detalle();
		detalle.setCosto(new BigDecimal("100"));
		detalle.setDescripcion("Comida rapida");

		Detalle detalle1 = new Detalle();
		detalle1.setCosto(new BigDecimal("492"));
		detalle1.setDescripcion("Comida elegante");

		List<Detalle> listDetalles = new ArrayList<>();
		listDetalles.add(detalle);
		listDetalles.add(detalle1);

		factura.setDetalles(listDetalles);
		detalle.setFactura(factura);
		detalle1.setFactura(factura);
		
//		this.iFacturaService.insertar(factura);

		// 1
		Logger.info("INNER JOIN");
		List<Factura> listfacturaCInner = this.iFacturaService.buscarDescripcionInnerJoin(detalle.getDescripcion());

		for (Factura h : listfacturaCInner) {
			Logger.info("Descripcion -> " + h.getApellido()+" "+h.getCedula());
		}

		// 2
		Logger.info("LEFT JOIN");
		List<Factura> facturaCLeft = this.iFacturaService.buscarDescripcionLeftOuterJoin(detalle1.getDescripcion());
		for (Factura h : facturaCLeft) {
			Logger.info("Descripcion -> " + h.getApellido()+" "+h.getCedula());
		}

		// 3
		Logger.info("RIGHT JOIN");
		List<Factura> facturaCRight = this.iFacturaService.buscarDescripcionRightOuterJoin(detalle.getDescripcion());
		for (Factura h : facturaCRight) {
			Logger.info("Descripcion -> " + h.getApellido()+" "+h.getCedula());
		}
	}

}
