package com.marketmexa.proyecto.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.marketmexa.proyecto.model.Productos;
import com.marketmexa.proyecto.service.ProductosService;
@RestController
@RequestMapping(path="/api/productos/") // http://localhost:8080/api/productos
public class ProductosController {
    
    private final ProductosService productosService;
    @Autowired
    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }
    //  Obtener todos los productos (GET)
    @GetMapping
    public List<Productos> getProductos() {
        return productosService.getAllProducts();
    }
    // Obtener un solo producto por ID (GET)
    @GetMapping(path= "{proId}")
    public Productos getProducto(@PathVariable("proId") Long id) {
        return productosService.getProduct(id);
    }
    // Eliminar un producto (DELETE)
    @DeleteMapping(path= "{proId}")
    public Productos deleteProducto(@PathVariable("proId") Long id) {
        return productosService.deleteProduct(id);
    }
    // Agregar un nuevo producto (POST)
    @PostMapping
    public Productos addProducto(@RequestBody Productos producto) {
        return productosService.addProduct(producto);
    }
    // Actualizar producto (PUT)
    @PutMapping(path= "{proId}")
    public Productos updateProducto(@PathVariable("proId") Long id,
                                   @RequestParam(required=false) String name,
                                   @RequestParam(required=false) String description,
                                   @RequestParam(required=false) String image,
                                   @RequestParam(required=false) String category, 
                                   @RequestParam(required=false) Double price,
                                   @RequestParam(required=false) Integer stock) {

                                
                                                                    
                                   
        return productosService.updateProduct(id, name, description, image, category, price, stock);
    }
}