package com.marketmexa.proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketmexa.proyecto.model.Productos;

@Service
public class ProductosService {
	// Arreglo para simular la BD
	public final List<Productos> productos = new ArrayList<Productos>();
	
	// Se añaden en la lista productos muestra
	@Autowired
	public ProductosService() {
		productos.add(new Productos("nombreProducto", "descripcionProducto", "URL Cloudinary", 0.0, 2));
		productos.add(new Productos("Guitarra", "Guitarra clásica", "https://URLguitarra.png", 13456.5, 10));
		productos.add(new Productos("Balón de futbol", "Balón de la marca Adidas", "https://URLbalon.png", 745d, 50));
		productos.add(new Productos("Aretes", "Aretes de oro muy bonitos", "https://URLaretes.png", 890.43, 1));
	}
	
	// Método para obtener todos los productos existentes
	public List<Productos> getAllProducts() {
		return productos;
	}
	
	// Método para obtener la información de un solo producto
	public Productos getProduct(Long id) {
		for (Productos producto : productos) {
			if(producto.getId().equals(id)) return producto;
		}
		return null;
	}
	
	// Método para eliminar un producto por su ID siempre y cuando este exista
	public Productos deleteProduct(Long id) {
		Productos flagProducto = null;
		for (Productos producto : productos) {
			if(producto.getId().equals(id)) {
				flagProducto = producto;
				productos.remove(producto);
				break;
			}
		}
		return flagProducto;
	}
	
	// Método para modificar la información de un producto por su ID e información
	public Productos updateProduct(Long id, String nombre, String descripcion, String imagen, Double precio, Integer stock) {
		Productos flagProducto = null;
		for (Productos producto : productos) {
			if(producto.getId().equals(id)) {
				if(nombre != null) producto.setNombre(nombre);
				if(descripcion != null) producto.setDescripcion(descripcion);
				if(imagen != null) producto.setImagen(imagen);
				if(precio != null) producto.setPrecio(precio);
				if(stock != null) producto.setStock(stock);
				flagProducto = producto;
			}
		}
		return flagProducto;
	}
	
	// Método para añadir un producto siempre y cuando no tenga el nombre de algún producto existente
	public Productos addProduct(Productos productoNuevo) {
		for (Productos producto : productos) {
			if(producto.getNombre().equals(productoNuevo.getNombre())) return null;
		}
		productos.add(productoNuevo);
		return productoNuevo;
	}
}