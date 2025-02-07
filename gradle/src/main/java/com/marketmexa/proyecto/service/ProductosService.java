package com.marketmexa.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketmexa.proyecto.model.Productos;
import com.marketmexa.proyecto.repository.ProductosRepository;

@Service
public class ProductosService {
	public final ProductosRepository productosRepository;
	
	@Autowired
	public ProductosService(ProductosRepository productosRepository) {
		this.productosRepository = productosRepository;
			 }//constuctor
	
	// Método para obtener todos los productos existentes
	public List<Productos> getAllProductos() {
		return productosRepository.findAll();
	}//getAllProductos
	
	// Método para obtener la información de un solo producto
	public Productos getProducto(Long id) {
		
		return productosRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException ("El producto con el id ["
						+ id + "] no existe.")
				);
		}//getProductos
	
	// Método para eliminar un producto por su ID siempre y cuando este exista
	public Productos deleteProducto(Long id) {
		Productos prod = null;
		if(productosRepository.existsById(id)) {
			prod = productosRepository.findById(id).get();
			productosRepository.deleteById(id);
		}//ifexist
	return prod;
	}//deleteProducos
	
	// Método para añadir un producto siempre y cuando no tenga el nombre de algún producto existente
	public Productos addProducto(Productos producto) {
		Optional<Productos> prod = productosRepository.findByNombre(producto.getNombre());
		if(prod.isEmpty()) {
			productosRepository.save(producto);
			return producto;

		}else {
			return null;
		}//else
	}//addProducto
		
	// Método para modificar la información de un producto por su ID e información
	public Productos updateProducto(Long id, String nombre, String descripcion, String imagen, Double precio) {
		Productos prod = null;
		if(productosRepository.existsById(id)) {
			Productos producto = productosRepository.findById(id).get();
				if (nombre!=null) producto.setNombre(nombre);
				if (descripcion!=null) producto.setDescripcion(descripcion);
				if (imagen!=null) producto.setImagen(imagen);
				if (precio!=null) producto.setPrecio(precio);	
				productosRepository.save(producto);
				prod=producto;
			}//if
		return prod;
	
	}//updateProducto
}//class productosServices