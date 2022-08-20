package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository {

	private static final Logger Logger = LoggerFactory.getLogger(CuentaBancariaRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
//	@Transactional(value = TxType.MANDATORY)
	@Transactional(value = TxType.REQUIRES_NEW)
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuentaBancaria);
//		throw new RuntimeException();
	}// commit

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED) // no necesita una transaccion.
	public CuentaBancaria buscarPorNumero(String numeroCta) {
		// TODO Auto-generated method stub
		Logger.info(
				"Transaccion activa (buscarPorNumero) repository -> " + TransactionSynchronizationManager.isActualTransactionActive());
		TypedQuery<CuentaBancaria> miQuery = this.entityManager
				.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numero =: numeroCta", CuentaBancaria.class);
		miQuery.setParameter("numeroCta", numeroCta);
		return miQuery.getSingleResult();
	}

}
