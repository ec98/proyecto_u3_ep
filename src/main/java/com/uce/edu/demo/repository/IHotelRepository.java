package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Hotel;

public interface IHotelRepository {
	
	public void insertar(Hotel hotel);
	
	public Hotel buscarHotel(Integer id);
	
	public int actualizarHotel(String nombre, String direccion);
	
	
	public int eliminarHotel(String direccion);

	// Inner Join
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion);

	public List<Hotel> buscarHotelInnerJoin(); // comprobar si INNER JOIN funciona correctamente

	// Left Join
	public List<Hotel> buscarHotelLeftOuterJoin(String tipoHabitacion);

	public List<Hotel> buscarHotelLeftOuterJoin();

	// Right Join
	public List<Hotel> buscarHotelRightOuterJoin(String tipoHabitacion);

	public List<Hotel> buscarHotelOuterJoin(String tipoHabitacion);

	// Where Join
	public List<Hotel> buscarHotelWhereJoin(String tipoHabitacion);

	// Join Fetch
	public List<Hotel> buscarHotelFetchJoin(String tipoHabitacion);

}
