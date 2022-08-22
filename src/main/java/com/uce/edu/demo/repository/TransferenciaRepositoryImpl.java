package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Transferencia;

@Repository
@Transactional
public class TransferenciaRepositoryImpl implements ITransferenciaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.REQUIRED)
//	@Transactional(value = TxType.REQUIRES_NEW)
	public void insert(Transferencia Transferencia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(Transferencia);
//		throw new RuntimeException();
		throw new NullPointerException();
		
	}

}
