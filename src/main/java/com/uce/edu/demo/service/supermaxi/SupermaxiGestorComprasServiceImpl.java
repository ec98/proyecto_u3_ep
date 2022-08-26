package com.uce.edu.demo.service.supermaxi;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupermaxiGestorComprasServiceImpl implements ISupermaxiGestorComprasService {

	@Autowired
	private ISupermaxiFacturaProductoService iSupermaxiFacturaProductoService;
	
	@Autowired
	private ISupermaxiFacturaElectronicaService iSupermaxiFacturaElectronicaService;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void registrarCompraProducto(String cedula, String numeroFactura, List<String> codigo) {
		// TODO Auto-generated method stub
		
		BigDecimal valorPagar =  this.iSupermaxiFacturaProductoService.compraProducto(cedula, numeroFactura, codigo);
		
		this.iSupermaxiFacturaElectronicaService.procesarElectronica(numeroFactura, codigo.size(), valorPagar);
		
	}

}
