package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Factura;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public List<Factura> buscarDescripcionInnerJoin(String descripcionDetalle) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> miQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f JOIN f.detalles fd WHERE fd.descripcion =: descripcionDetalle", Factura.class);
		miQuery.setParameter("descripcionDetalle", descripcionDetalle);
		return miQuery.getResultList();
	}

	@Override
	public List<Factura> buscarDescripcionLeftOuterJoin(String descripcionDetalle) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> miQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f LEFT JOIN f.detalles fd WHERE fd.descripcion =: descripcionDetalle",
				Factura.class);
		miQuery.setParameter("descripcionDetalle", descripcionDetalle);
		return miQuery.getResultList();
	}

	@Override
	public List<Factura> buscarDescripcionRightOuterJoin(String descripcionDetalle) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> miQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f RIGHT JOIN f.detalles fd WHERE fd.descripcion =: descripcionDetalle",
				Factura.class);
		miQuery.setParameter("descripcionDetalle", descripcionDetalle);
		return miQuery.getResultList();
	}

}
