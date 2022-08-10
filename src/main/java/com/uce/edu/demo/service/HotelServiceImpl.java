package com.uce.edu.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.ProyectoU3EpApplication;
import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	private static final Logger Logger = LoggerFactory.getLogger(ProyectoU3EpApplication.class);

	@Autowired
	private IHotelRepository iHotelRepository;

	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelInnerJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelInnerJoin();
	}

	@Override
	public List<Hotel> buscarHotelLeftOuterJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelLeftOuterJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelLeftOuterJoin() {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelLeftOuterJoin();
	}

	@Override
	public List<Hotel> buscarHotelRightOuterJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelRightOuterJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelOuterJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> buscarHotelWhereJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelWhereJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelFetchJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		Logger.info("Transaccion activa service -> " + TransactionSynchronizationManager.isActualTransactionActive());
		return this.iHotelRepository.buscarHotelFetchJoin(tipoHabitacion);
	}

}
