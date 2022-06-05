package com.cafeteriakonecta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cafeteriakonecta.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {
     
	
	@Query(value = "SELECT * FROM producto WHERE stock = (SELECT MAX(stock) FROM producto);",
			nativeQuery = true)
	Producto maxStock();
	
	@Query(value = "SELECT * FROM producto WHERE cantidad_vendida = (SELECT MAX(cantidad_vendida) FROM producto);",
			nativeQuery = true)
	Producto maxSold();
}
