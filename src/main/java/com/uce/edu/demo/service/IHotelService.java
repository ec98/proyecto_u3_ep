package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Hotel;

public interface IHotelService {

	public void insertar(Hotel hotel);

	public int actualizarHotel(String nombre, String direccion);

	public Hotel buscarHotel(Integer id);


	public int eliminarHotel(String direccion);

	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion);

	public List<Hotel> buscarHotelInnerJoin();

	public List<Hotel> buscarHotelLeftOuterJoin(String tipoHabitacion);

	public List<Hotel> buscarHotelLeftOuterJoin();

	public List<Hotel> buscarHotelRightOuterJoin(String tipoHabitacion);

	public List<Hotel> buscarHotelOuterJoin(String tipoHabitacion);

	public List<Hotel> buscarHotelWhereJoin(String tipoHabitacion);

	public List<Hotel> buscarHotelFetchJoin(String tipoHabitacion);
}
