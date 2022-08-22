package com.uce.edu.demo.repository.supermaxi.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "detalle")
public class DetalleFactura {

	@Id
	@Column(name = "deta_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deta_id_seq")
	@SequenceGenerator(name = "deta_id_seq", sequenceName = "deta_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "deta_cantidad")
	private Integer cantidad;

	@Column(name = "deta_subtotal")
	private BigDecimal subtotal;

	@ManyToOne
	@JoinColumn(name = "deta_id_factura")
	private Factura factura;

	@ManyToOne
	@JoinColumn(name = "deta_id_producto")
	private Producto producto;

	@Override
	public String toString() {
		return "DetalleFactura [id=" + id + ", cantidad=" + cantidad + ", subtotal=" + subtotal + "]";
	}

	// GET Y SET
	public Integer getId() {
		return id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

}