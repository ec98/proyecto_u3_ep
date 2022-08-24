package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.supermaxi.modelo.Cliente;
import com.uce.edu.demo.repository.supermaxi.modelo.Producto;
import com.uce.edu.demo.service.supermaxi.ISupermaxiClienteService;
import com.uce.edu.demo.service.supermaxi.ISupermaxiFacturaProductoService;
import com.uce.edu.demo.service.supermaxi.ISupermaxiProductoService;

@SpringBootApplication
public class ProyectoU3EpApplication implements CommandLineRunner {

	private static final Logger Logger = LoggerFactory.getLogger(ProyectoU3EpApplication.class);

	@Autowired
	private ISupermaxiProductoService iProductoService;

	@Autowired
	private ISupermaxiClienteService iSupermaxiClienteService;

	@Autowired
	private ISupermaxiFacturaProductoService iSupermaxiFacturaProductoService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3EpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Producto producto = new Producto();
		producto.setNombre("Yogurt");
		producto.setCodigo("0202");
		producto.setPrecio(new BigDecimal(12));
		producto.setInventario(150);

		//this.iProductoService.insertar(producto);

		Cliente cliente = new Cliente();
		cliente.setNumeroCedula("182821911");

		// this.iSupermaxiClienteService.insertar(cliente);

		List<String> listCod = new ArrayList<>();

		listCod.add(producto.getCodigo());

		this.iSupermaxiFacturaProductoService.compraProducto("182821911", "123", listCod);
	}
}
