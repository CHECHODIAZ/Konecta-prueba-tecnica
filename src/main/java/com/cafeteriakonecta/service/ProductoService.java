package com.cafeteriakonecta.service;

import java.util.List;

import com.cafeteriakonecta.entity.Producto;

public interface ProductoService {
     
	public List<Producto> getAll();
	public Producto getOne(Integer id);
	public void create(Producto producto);
	public void Delete(Integer id);
	public Producto maxStock();
	public Producto seller();
	
}
