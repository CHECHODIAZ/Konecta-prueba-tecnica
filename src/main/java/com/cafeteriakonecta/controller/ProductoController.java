package com.cafeteriakonecta.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafeteriakonecta.entity.Producto;
import com.cafeteriakonecta.service.ProductoService;


@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService service;
	
     /**
      * Crea un nuevo producto
      * @param producto
      * @return
      * list.html (vista con todos los productos incluyendo nuevos producto creados)
      */
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String create(
			@ModelAttribute("PRODUCTO")
			Producto producto
			) {
		
		this.service.create(producto);
		
		return "redirect:/producto/list";
	}
	
	/**
	 * Guarda producto editado con el metodo: "edit".
	 * Recalcula valor del Stock dado un descuento del mismo.
	 * @param producto
	 * @return
	 * list.html (vista actualizada de todos los productos incluyendo actualizaciones)
	 * Campo stock recalculado (resultado de restar ultima salida de un producto)
	 */
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(
			@ModelAttribute("PRODUCTO")
			Producto producto
			) {
		  producto.setStock(producto.getStock() - producto.getCantidadVendida());
		this.service.create(producto);
		
		return "redirect:/producto/list";
	}
	
	
	/**
	 * edita un producto
	 * carga el objeto producto por su id usando funcion javascript
	 * @param id
	 * @param model
	 * @return
	 * edit.html (vista con formulario donde se pueden modificar los campos. no se pueden modificar los campos: "id","stock".)
	 */
	@RequestMapping("/edit/{id}")
	public String edit(
			@PathVariable(name="id")
			Integer id,
			Model model) {
		
		Producto producto = this.service.getOne(id);
		
		model.addAttribute("PRODUCTO",producto);
		
		return "producto/edit";
	}
	/**
	 * Busca un producto segun id especificado
	 * @param id
	 * @param model
	 * @return
	 * list.html (vista con el producto indicado)
	 * lanza org.thymeleaf.exceptions y status 500. si el id indicado no esta en la base de datos.
	 * 
	 */
	@RequestMapping("/product")
	public String getOneProduct(
			@RequestParam(value="id", required=true)
			Integer id,
			Model model) {
		
			
		Producto producto = this.service.getOne(id);
		
		model.addAttribute("PRODUCTOS", producto);
		
		return "producto/list";
		
	}
	
	/**
	 * Busca todos los productos
	 * @param model
	 * @return
	 * list.html (vista con todos los productos)
	 */
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Producto> productos = this.service.getAll();
		
		model.addAttribute("PRODUCTOS", productos);
		
		return "producto/list";
	}
	
	/**
	 * Busca el producto con mayor stock en inventario
	 * @param model
	 * @return
	 * list.html(vista con el producto indicado)
	 */
	@GetMapping("/maxstock")
	public String maxstock(Model model) {

		Producto producto = this.service.maxStock();

		model.addAttribute("PRODUCTOS", producto);
		
		return "producto/list";
	}
	
	/**
	 * Busca el producto mas vendido
	 * @param model
	 * @return
	 * list.hmtl(vista con el producto indicado)
	 */
	@GetMapping("/maxsold")
	public String maxsold(Model model) {
	
		Producto producto = this.service.seller();
		
		model.addAttribute("PRODUCTOS", producto);
		
		return "producto/list";
	}
	
	/**
	 * Elimina un registo
	 * @param id
	 * @return
	 * list.html(lista de todos los productos)
	 */
	@RequestMapping("/delete")
	public String delete(
		@RequestParam(value="id", required=true)
		Integer id
		) {
		
		this.service.Delete(id);
		
		return "redirect:/producto/list";
	}
	
	/**
	 * Direcciona a formulario creacion de un producto
	 * @return
	 * create.html
	 */
	@RequestMapping("/formulario")
	public String form() {
		
		return "producto/create";
	}
	

}
