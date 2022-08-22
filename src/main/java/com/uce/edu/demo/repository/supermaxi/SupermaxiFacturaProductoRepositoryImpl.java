package com.uce.edu.demo.repository.supermaxi;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.supermaxi.modelo.Factura;

@Repository
@Transactional
public class SupermaxiFacturaProductoRepositoryImpl implements ISupermaxiFacturaProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void crear(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}

	

}
