package com.uce.edu.demo.service.supermaxi;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.supermaxi.ISupermaxiClienteRepository;
import com.uce.edu.demo.repository.supermaxi.ISupermaxiDetalleRepository;
import com.uce.edu.demo.repository.supermaxi.ISupermaxiFacturaElectronicaRepository;
import com.uce.edu.demo.repository.supermaxi.ISupermaxiProductoRepository;
import com.uce.edu.demo.repository.supermaxi.modelo.DetalleFactura;
import com.uce.edu.demo.repository.supermaxi.modelo.Factura;
import com.uce.edu.demo.repository.supermaxi.modelo.FacturaElectronica;
import com.uce.edu.demo.repository.supermaxi.modelo.Producto;

@Service
public class SupermaxiFacturaProductoServiceImpl implements ISupermaxiFacturaProductoService {

	private static final Logger Logger = LoggerFactory.getLogger(SupermaxiFacturaProductoServiceImpl.class);
	
	@Autowired
	private ISupermaxiProductoRepository iProductoRepository;

	@Autowired
	private ISupermaxiDetalleRepository iDetalleRepository;

	@Autowired
	private ISupermaxiClienteRepository iClienteRepository;

	@Autowired
	private ISupermaxiFacturaElectronicaRepository iFacturaElectronicaRepository;
	
	@Autowired
	private IFacturaRepository iFacturaRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void compraProducto(String cedula, String numero, List<String> codigo) {
		// TODO Auto-generated method stub
		Factura factura = new Factura();
		factura.setNumero(numero);
		factura.setFecha(LocalDateTime.now());

		factura.setCliente(this.iClienteRepository.buscarPorCedula(cedula));
		List<DetalleFactura> milist = new ArrayList<DetalleFactura>();

		BigDecimal valor = new BigDecimal(0);

		this.iFacturaRepository.insertar(factura);
		for (String item : codigo) {
			DetalleFactura detalle = new DetalleFactura();
			detalle.setCantidad(1);
			detalle.setProducto(this.iProductoRepository.buscarPorCodigo(item));
			detalle.setSubtotal(detalle.getProducto().getPrecio());
			detalle.setFactura(factura);
//			Logger.info(detalle.getSubtotal()+" <--------------------------");
			milist.add(detalle);
			this.iDetalleRepository.insertar(detalle);
			Producto producto = this.iProductoRepository.buscarPorCodigo(item);
			producto.setInventario(producto.getInventario() - 1);
			this.iProductoRepository.actualizar(producto);
			valor = valor.add(detalle.getSubtotal());
		}

		FacturaElectronica fe = new FacturaElectronica();
		fe.setMonto(valor);
		fe.setFecha(LocalDateTime.now());
		fe.setNumeroFactura(numero);
		fe.setNumeroItems(milist.size());
		this.iFacturaElectronicaRepository.insertarFacturaSRI(fe);
	}

}
