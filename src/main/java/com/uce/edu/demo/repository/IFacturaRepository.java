package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturaRepository {

	public void insertar (Factura factura);
	
	// Inner Join
	public List<Factura> buscarDescripcionInnerJoin(String descripcionDetalle);

	// Left Join
	public List<Factura> buscarDescripcionLeftOuterJoin(String descripcionDetalle);

	// Right Join
	public List<Factura> buscarDescripcionRightOuterJoin(String descripcionDetalle);


}
