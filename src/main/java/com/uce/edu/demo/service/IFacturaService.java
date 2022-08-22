package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.supermaxi.modelo.Factura;

public interface IFacturaService {

	public void insertar(Factura factura);

	// Inner Join
	public List<Factura> buscarDescripcionInnerJoin(String descripcionDetalle);

	// Inner Join with Lazy/Eager
	public List<Factura> buscarDescripcionInnerJoinWithLazyEager(String descripcionDetalle);

	// Left Join
	public List<Factura> buscarDescripcionLeftOuterJoin(String descripcionDetalle);

	// Right Join
	public List<Factura> buscarDescripcionRightOuterJoin(String descripcionDetalle);

	// Where Join
	public List<Factura> buscarDescripcionWhereJoin(String descripcionDetalle);

	// Fecth Join
	public List<Factura> buscarDescripcionJoinFetch(String descripcionDetalle);

}
