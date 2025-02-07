package com.marketmexa.proyecto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Productos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false, unique = true, name="id_products")
    private Long id;
    @Column(nullable=false, unique = true, name="product_name")
    private String nombre;
    @Column(nullable=false, unique = true, name="product_description")
    private String descripcion;
    @Column(nullable=false, unique = true, name="product_image")
    private String imagen;
    @Column(nullable=false, unique = true, name="product_price")
    private Double precio;
    @Column(nullable=false, unique = true, name="product_stock")
    private Integer stock;
   
    // Constructor con todos los parámetros excepto el ID
    public Productos(String nombre, String descripcion, String imagen, Double precio, Integer stock) {
    	this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.stock = stock;
        
    }

    // Constructor 
    public Productos() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    // Método toString 
    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion 
                + ", imagen=" + imagen + ", precio=" + precio + ", stock=" + stock + "]";
    }
}
