package com.uce.edu.demo.repository.supermaxi;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.supermaxi.modelo.Cliente;

@Repository
@Transactional
public class SupermaxiClienteRepositoryImpl implements ISupermaxiClienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cliente);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Cliente buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> miQuery = this.entityManager.createQuery("SELECT c FROM Cliente c WHERE c.numeroCedula =:cedula",
				Cliente.class);
		miQuery.setParameter("cedula", cedula);
		return miQuery.getSingleResult();
	}

}
