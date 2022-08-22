package com.uce.edu.demo.service.supermaxi;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.supermaxi.ISupermaxiClienteRepository;
import com.uce.edu.demo.repository.supermaxi.modelo.Cliente;

@Service
public class SupermaxiClienteServiceImpl implements ISupermaxiClienteService {

	@Autowired
	private ISupermaxiClienteRepository iClienteRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.iClienteRepository.insertar(cliente);
	}

}
