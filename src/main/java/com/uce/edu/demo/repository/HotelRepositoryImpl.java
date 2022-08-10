package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.modelo.Hotel;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	private static final Logger Logger = LoggerFactory.getLogger(HotelRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		// TypedQuery<Hotel> miQuery = this.entityManager.createQuery("SELECT h FROM
		// Hotel h full JOIN h.habitaciones ha WHERE ha.tipo =: tipoHabitacion",
		// Hotel.class);
		TypedQuery<Hotel> miQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo =: tipoHabitacion", Hotel.class);
		miQuery.setParameter("tipoHabitacion", tipoHabitacion);
		List<Hotel> hoteles = miQuery.getResultList();
		//bajo demanda with lazy
		for (Hotel h : hoteles) {
			h.getHabitaciones().size();
		}
		return hoteles;
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		// TypedQuery<Hotel> miQuery = this.entityManager.createQuery("SELECT h FROM
		// Hotel h full JOIN h.habitaciones ha", Hotel.class);
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
	//REQUIRED
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
		// SELECT * FROM public.hotel ho, habitacion ha WHERE ho.hote_id =
		// ha.habi_id_hotel AND ha.habi_tipo='Familiar'
		TypedQuery<Hotel> miQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h, Habitacion ha WHERE h.id = ha.hotel AND ha.tipo =: tipoHabitacion",
				Hotel.class); // espera un retorno de hotel.
		miQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return miQuery.getResultList();
	}

	@Override
	//todos los demas son REQUIRED
//	@Transactional(value = TxType.MANDATORY)
	public List<Hotel> buscarHotelFetchJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		Logger.info("Transaccion activa repository -> "+TransactionSynchronizationManager.isActualTransactionActive());
		TypedQuery<Hotel> miQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha WHERE ha.tipo =: tipoHabitacion", Hotel.class);
		//realiza una seleccion de toda la busqueda de la tabla principal con sus hijos secundarios.
		miQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return miQuery.getResultList();
	}

}
