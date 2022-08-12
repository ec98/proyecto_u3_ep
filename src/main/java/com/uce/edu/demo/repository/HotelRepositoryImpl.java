package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

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
		// bajo demanda with lazy
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
	// REQUIRED
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
	// todos los demas son REQUIRED
//	@Transactional(value = TxType.MANDATORY)
	public List<Hotel> buscarHotelFetchJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		Logger.info(
				"Transaccion activa repository -> " + TransactionSynchronizationManager.isActualTransactionActive());
		TypedQuery<Hotel> miQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha WHERE ha.tipo =: tipoHabitacion", Hotel.class);
		// realiza una seleccion de toda la busqueda de la tabla principal con sus hijos
		// secundarios.
		miQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return miQuery.getResultList();
	}

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
	}

	@Override
	public Hotel buscarHotel(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public int actualizarHotel(String nombre, String direccion) {
		// TODO Auto-generated method stub
		// UPDATE Hotel SET hote_nombre='Hotel Atacames' WHERE hote_direccion='Amanta'
		Query myQueryv4 = this.entityManager
				.createQuery("UPDATE Hotel h SET h.nombre=:datoNombre WHERE h.direccion =:datoDireccion");
		myQueryv4.setParameter("datoNombre", nombre);
		myQueryv4.setParameter("datoDireccion", direccion);
		return myQueryv4.executeUpdate();
	}

	@Override
	public int eliminarHotel(String direccion) {
		// TODO Auto-generated method stub
		// DELETE FROM Hotel WHERE hote_direccion='Shirys'
		Query myQueryV5 = this.entityManager.createQuery("DELETE FROM Hotel h WHERE h.direccion =: direccion");
		myQueryV5.setParameter("direccion", direccion);
		return myQueryV5.executeUpdate();
	}

	

}
