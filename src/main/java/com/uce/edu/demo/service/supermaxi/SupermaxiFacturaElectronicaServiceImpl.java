package com.uce.edu.demo.service.supermaxi;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.supermaxi.ISupermaxiFacturaElectronicaRepository;
import com.uce.edu.demo.repository.supermaxi.modelo.FacturaElectronica;

@Service
public class SupermaxiFacturaElectronicaServiceImpl implements ISupermaxiFacturaElectronicaService {
	
	@Autowired
	private ISupermaxiFacturaElectronicaRepository iFacturaElectronicaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void procesarElectronica(String numero, Integer cantidadItems, BigDecimal monto) {
		// TODO Auto-generated method stub
		FacturaElectronica fe = new FacturaElectronica();
		fe.setMonto(monto);
		fe.setFecha(LocalDateTime.now());
		fe.setNumeroFactura(numero);
		fe.setNumeroItems(cantidadItems);

		this.iFacturaElectronicaRepository.insertarFacturaSRI(fe);
		throw new RuntimeException();
		
	}

}
