package com.uce.edu.demo.repository.supermaxi;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.supermaxi.modelo.FacturaElectronica;

@Repository
@Transactional
public class SupermaxiFacturaElectronicaRepositoryImpl implements ISupermaxiFacturaElectronicaRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void insertarFacturaSRI(FacturaElectronica facturaElectronica) {
		// TODO Auto-generated method stub
		this.entityManager.persist(facturaElectronica);
		throw new RuntimeException();
	}

}
