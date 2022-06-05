package com.cafeteriakonecta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeteriakonecta.entity.Producto;
import com.cafeteriakonecta.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRepository repository;

	@Override
	public List<Producto> getAll() {
		
		return repository.findAll();
	}

	@Override
	public Producto getOne(Integer id) {
	
		return repository.getById(id);
	}

	@Override
	public void create(Producto producto) {
	
		repository.save(producto);
	}

	@Override
	public void Delete(Integer id) {
		
	   repository.deleteById(id);
	}

	@Override
	public Producto maxStock() {
		
		return repository.maxStock();
	}

	@Override
	public Producto seller() {
		
		return repository.maxSold();
	}	

}
