package com.cafeteriakonecta.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="producto")
public class Producto {
	
	@Id
	@NotNull(message = "campo requerido")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "campo requerido")
	@Column(name="nombre_producto", nullable=false)
	private String nombreProducto;
	
	@NotNull(message = "campo requerido")
	@Column(name="referencia", nullable=false)
	private String referencia;
	
	@NotNull(message = "campo requerido")
	@Column(name="precio", nullable=false)
	private Double precio;
	
	@NotNull(message = "campo requerido")
	@Column(name="peso", nullable=false)
	private Float peso;
	
	@NotNull(message = "campo requerido")
	@Column(name="categoria", nullable=false)
	private String categoria;
	
	@NotNull(message = "campo requerido")
	@Column(name="stock", nullable=false)
	private Integer stock;
	
	@NotNull(message = "campo requerido")
	@Column(name="cantidad_vendida", nullable=false)
	private Integer cantidadVendida;
	
	@NotNull(message = "campo requerido")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="fecha_creacion")
	private Date fechaCreacion;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public Integer getCantidadVendida() {
		return cantidadVendida;
	}
	public void setCantidadVendida(Integer cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombreProducto=" + nombreProducto + ", referencia=" + referencia + ", precio="
				+ precio + ", peso=" + peso + ", categoria=" + categoria + ", stock=" + stock + ", cantidadVendida="
				+ cantidadVendida + ", fechaCreacion=" + fechaCreacion + "]";
	}
	
	

}
