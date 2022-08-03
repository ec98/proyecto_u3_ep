package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Hotel;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> miQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo =: tipoHabitacion", Hotel.class);
		miQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return miQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> miQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha",
				Hotel.class);
		return miQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelLeftOuterJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> miQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE ha.tipo =: tipoHabitacion", Hotel.class);
		miQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return miQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelLeftOuterJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> miQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha",
				Hotel.class);
		return miQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelRightOuterJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> miQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha WHERE ha.tipo =: tipoHabitacion", Hotel.class);
		miQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return miQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> buscarHotelWhereJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> buscarHotelFetchJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return null;
	}

}
