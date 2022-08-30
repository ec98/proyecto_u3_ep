package com.uce.edu.demo.service.supermaxi;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.supermaxi.ISupermaxiClienteRepository;
import com.uce.edu.demo.repository.supermaxi.ISupermaxiFacturaRepository;
import com.uce.edu.demo.repository.supermaxi.ISupermaxiProductoRepository;
import com.uce.edu.demo.repository.supermaxi.modelo.DetalleFactura;
import com.uce.edu.demo.repository.supermaxi.modelo.Factura;
import com.uce.edu.demo.repository.supermaxi.modelo.Producto;

@Service
public class SupermaxiFacturaProductoServiceImpl implements ISupermaxiFacturaProductoService {

	@Autowired
	private ISupermaxiProductoRepository iProductoRepository;

	@Autowired
	private ISupermaxiClienteRepository iClienteRepository;

	@Autowired
	private ISupermaxiFacturaRepository iFacturaRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public BigDecimal compraProducto(String cedula, String numero, List<String> codigo) {
		// TODO Auto-generated method stub
		Factura factura = new Factura();
		factura.setNumero(numero);
		factura.setFecha(LocalDateTime.now());

		factura.setCliente(this.iClienteRepository.buscarPorCedula(cedula));
		List<DetalleFactura> milist = new ArrayList<DetalleFactura>();

		BigDecimal valor = new BigDecimal(0);

		//this.iFacturaRepository.insertar(factura);
		for (String item : codigo) {
			DetalleFactura detalle = new DetalleFactura();
			detalle.setCantidad(1);
			Producto producto = this.iProductoRepository.buscarPorCodigo(item);
			detalle.setProducto(producto);
			detalle.setSubtotal(detalle.getProducto().getPrecio());
			detalle.setFactura(factura);
			milist.add(detalle);
			producto.setInventario(producto.getInventario() - detalle.getCantidad());
			this.iProductoRepository.actualizar(producto);
			valor = valor.add(detalle.getSubtotal());
		}
		factura.setDetallefactura(milist);
		
		this.iFacturaRepository.insertar(factura);
		return valor;
	}

}
