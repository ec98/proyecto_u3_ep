package com.uce.edu.demo.repository.supermaxi;

import com.uce.edu.demo.repository.supermaxi.modelo.Cliente;

public interface ISupermaxiClienteRepository {

	public void insertar(Cliente cliente);
	
	public Cliente buscarPorCedula(String cedula);
}
