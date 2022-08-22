package com.uce.edu.demo.repository.supermaxi.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@Column(name = "clie_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clie_id_seq")
	@SequenceGenerator(name = "clie_id_seq", sequenceName = "clie_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "clie_numero_cedula")
	private String numeroCedula;

	@OneToMany(mappedBy = "cliente")
	private List<Factura> facturas;

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", numeroCedula=" + numeroCedula + ", facturas=" + facturas + "]";
	}

	// GET Y SET
	public Integer getId() {
		return id;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroCedula() {
		return numeroCedula;
	}

	public void setNumeroCedula(String numeroCedula) {
		this.numeroCedula = numeroCedula;
	}

}
