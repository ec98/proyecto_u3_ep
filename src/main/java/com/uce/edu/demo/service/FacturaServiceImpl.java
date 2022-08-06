package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository iFacturaRepository;

	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.iFacturaRepository.insertar(factura);
	}

	@Override
	public List<Factura> buscarDescripcionInnerJoin(String descripcionDetalle) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarDescripcionInnerJoin(descripcionDetalle);
	}

	@Override
	public List<Factura> buscarDescripcionLeftOuterJoin(String descripcionDetalle) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarDescripcionLeftOuterJoin(descripcionDetalle);
	}

	@Override
	public List<Factura> buscarDescripcionRightOuterJoin(String descripcionDetalle) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarDescripcionRightOuterJoin(descripcionDetalle);
	}

}
