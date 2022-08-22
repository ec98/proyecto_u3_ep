package com.uce.edu.demo.repository.supermaxi;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.supermaxi.modelo.Producto;

@Repository
@Transactional
public class SupermaxiProductoRepositoryImpl implements ISupermaxiProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> miQuery = this.entityManager
				.createQuery("SELECT p FROM Producto p WHERE p.codigo =:codigo", Producto.class);
		miQuery.setParameter("codigo", codigo);
		return miQuery.getSingleResult();
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

}
