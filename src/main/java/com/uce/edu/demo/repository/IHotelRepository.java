package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Hotel;

public interface IHotelRepository {

	// Inner Join
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion);

	public List<Hotel> buscarHotelInnerJoin(); // comprobar si INNER JOIN funciona correctamente

	// Left Join
	public List<Hotel> buscarHotelLeftOuterJoin(String tipoHabitacion);

	public List<Hotel> buscarHotelLeftOuterJoin();

	// Right Join
	public List<Hotel> buscarHotelRightOuterJoin(String tipoHabitacion);

	public List<Hotel> buscarHotelOuterJoin(String tipoHabitacion);

	public List<Hotel> buscarHotelWhereJoin(String tipoHabitacion);

	public List<Hotel> buscarHotelFetchJoin(String tipoHabitacion);

}
