package com.uce.edu.demo.service.supermaxi;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.supermaxi.ISupermaxiProductoRepository;
import com.uce.edu.demo.repository.supermaxi.modelo.Producto;

@Service
public class SupermaxiProductoServiceImpl implements ISupermaxiProductoService {

	@Autowired
	private ISupermaxiProductoRepository iProductoRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.insertar(producto);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.actualizar(producto);
	}

	@Override
	public Producto buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.iProductoRepository.buscarPorCodigo(codigo);
	}

}
