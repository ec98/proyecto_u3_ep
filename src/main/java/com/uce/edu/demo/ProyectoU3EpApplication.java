package com.uce.edu.demo;

import java.math.BigDecimal;
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
import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootApplication
public class ProyectoU3EpApplication implements CommandLineRunner {

	private static final Logger Logger = LoggerFactory.getLogger(ProyectoU3EpApplication.class);

	@Autowired
	private ITransferenciaService iTransferenciaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3EpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub		
		
		//no MANDATORY
//		Logger.info("FECTH JOIN");
//		// Usare la funcion LAZY para tener una busqueda mas eficiente que la funcion
//		// EAGER
//		List<Factura> listFactura2 = this.iFacturaService.buscarDescripcionJoinFetch("Comida elegante");
//		for (Factura f : listFactura2) {
//			Logger.info("Descripcion -> " + f.getCedula() + " " + f.getApellido());
//			for (Detalle de : f.getDetalles()) {
//				Logger.info("Detalles 2 -> " + de);
//			}
//		}
		
		this.iTransferenciaService.realizarTransferencia("18392", "124141", new BigDecimal("20"));

	}

}
