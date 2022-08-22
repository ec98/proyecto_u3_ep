package com.uce.edu.demo.service.supermaxi;

import com.uce.edu.demo.repository.supermaxi.modelo.Producto;

public interface ISupermaxiProductoService {
	public void insertar(Producto producto);

	public void actualizar(Producto producto);

	public Producto buscarPorCodigo(String codigo);
}
