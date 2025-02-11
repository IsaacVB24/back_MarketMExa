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
    }

    // Método para obtener todos los productos existentes
    public List<Productos> getAllProducts() {
        return productosRepository.findAll();
    }

    // Método para obtener la información de un solo producto
    public Productos getProduct(Long id) {
        return productosRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El producto con el ID [" + id + "] no existe"));
    }

    // Método para eliminar un producto por su ID siempre y cuando este exista
    public Productos deleteProduct(Long id) {
        Productos prod = null;
        if (productosRepository.existsById(id)) {
            prod = productosRepository.findById(id).get();
            productosRepository.deleteById(id);
        }
        return prod;
    }

    // Método para añadir un producto siempre y cuando no tenga el nombre de algún producto existente
    public Productos addProduct(Productos producto) {
	    Optional<Productos> prod = productosRepository.findByName(producto.getName());
	    if(prod.isEmpty()) {
	        return productosRepository.save(producto);
	    }else {
	        return null;
	    }
	}


	
	// Método para modificar la información de un producto por su ID e información
	public Productos updateProduct(Long id, String name, String description, String image, Double price, Integer stock) {
		Productos prod = null;
		if (productosRepository.existsById(id)) {
			Productos producto = productosRepository.findById(id).get();
				if(name != null) producto.setName(name);
				if(description != null) producto.setDescription(description);
				if(image != null) producto.setImage(image);
				if(price != null) producto.setPrice(price);
				if(stock != null) producto.setStock(stock);
				productosRepository.save(producto);
				prod = producto;
			}
		return prod;
	}
	}