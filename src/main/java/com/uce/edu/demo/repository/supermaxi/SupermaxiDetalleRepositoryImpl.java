package com.uce.edu.demo.repository.supermaxi;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.supermaxi.modelo.DetalleFactura;

@Repository
@Transactional
public class SupermaxiDetalleRepositoryImpl implements ISupermaxiDetalleRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(DetalleFactura detalleFactura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(detalleFactura);
	}

}
