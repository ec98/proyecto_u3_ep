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
	public List<Factura> buscarDescripcionInnerJoinWithLazyEager(String descripcionDetalle) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> miQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f JOIN f.detalles fd WHERE fd.descripcion =: descripcionDetalle", Factura.class);
		miQuery.setParameter("descripcionDetalle", descripcionDetalle);
		List<Factura> facturas = miQuery.getResultList();
		for (Factura f : facturas) {
			f.getDetallefactura().size();
		}
		return facturas;
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

	@Override
	public List<Factura> buscarDescripcionWhereJoin(String descripcionDetalle) {
		// TODO Auto-generated method stub
		// SELECT * FROM public.factura fa, detalle de WHERE fa.fact_id =
		// de.deta_id_factura AND de.deta_descripcion = 'Comida elegante'
		TypedQuery<Factura> miQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f, Detalle de WHERE f.id = de.factura AND de.descripcion =: descripcionDetalle",
				Factura.class);
		miQuery.setParameter("descripcionDetalle", descripcionDetalle);
		return miQuery.getResultList();
	}

	@Override
	public List<Factura> buscarDescripcionJoinFetch(String descripcionDetalle) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> miQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f JOIN FETCH f.detalles de WHERE de.descripcion =: descripcionDetalle",
				Factura.class);
		miQuery.setParameter("descripcionDetalle", descripcionDetalle);
		return miQuery.getResultList();

	}

}
