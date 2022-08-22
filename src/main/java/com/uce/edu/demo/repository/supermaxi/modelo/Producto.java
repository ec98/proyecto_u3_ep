package com.uce.edu.demo.repository.supermaxi.modelo;

import java.math.BigDecimal;
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
@Table(name = "producto")
public class Producto {

	@Id
	@Column(name = "prod_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_id_seq")
	@SequenceGenerator(name = "prod_id_seq", sequenceName = "prod_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "prod_nombre")
	private String nombre;

	@Column(name = "prod_precio")
	private BigDecimal precio;

	@Column(name = "prod_codigo")
	private String codigo;

	@Column(name = "prod_inventario")
	private Integer inventario;

	@OneToMany(mappedBy = "producto")
	private List<DetalleFactura> detallefactura;

	// GET Y SET
	public Integer getId() {
		return id;
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

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<DetalleFactura> getDetallefactura() {
		return detallefactura;
	}

	public void setDetallefactura(List<DetalleFactura> detallefactura) {
		this.detallefactura = detallefactura;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getInventario() {
		return inventario;
	}

	public void setInventario(Integer inventario) {
		this.inventario = inventario;
	}

}
