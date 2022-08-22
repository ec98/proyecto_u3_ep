package com.uce.edu.demo.repository.supermaxi.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "factura_electronica")
public class FacturaElectronica {

	@Id
	@Column(name = "fael_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fael_id_seq")
	@SequenceGenerator(name = "fael_id_seq", sequenceName = "fael_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "fael_numero_factura")
	private String numeroFactura;

	@Column(name = "fael_fecha")
	private LocalDateTime fecha;

	@Column(name = "fael_monto")
	private BigDecimal monto;

	@Column(name = "fael_numero_items")
	private Integer numeroItems;

	@Override
	public String toString() {
		return "FacturaElectronica [id=" + id + ", numeroFactura=" + numeroFactura + ", fecha=" + fecha + ", monto="
				+ monto + ", numeroItems=" + numeroItems + "]";
	}

	// GET Y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Integer getNumeroItems() {
		return numeroItems;
	}

	public void setNumeroItems(Integer numeroItems) {
		this.numeroItems = numeroItems;
	}

}
