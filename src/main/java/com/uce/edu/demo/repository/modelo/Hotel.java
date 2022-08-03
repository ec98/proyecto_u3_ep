package com.uce.edu.demo.repository.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Hotel")
public class Hotel {

	@Id
	@Column(name = "hote_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hote_id_seq")
	@SequenceGenerator(name = "hote_id_seq", sequenceName = "hote_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "hote_nombre")
	private String nombre;

	@Column(name = "hote_direccion")
	private String direccion;

	//TABLA PRINCIPAL
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL) // mapea el "nombre" a la tabla secundaria
	private List<Habitacion> habitaciones; //cuando tengo varios

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}

	// GETTERS AND SETTERS
	public Integer getId() {
		return id;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
