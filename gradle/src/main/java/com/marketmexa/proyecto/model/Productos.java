package com.marketmexa.proyecto.model;

public class Productos {

    private Long id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private Double precio;
    private Integer stock;
    private static Long cont =Long.valueOf(0);
    
    // Constructor con todos los parámetros excepto el ID
    public Productos(String nombre, String descripcion, String imagen, Double precio, Integer stock) {
        this.id= ++cont;      
    	this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.stock = stock;
        
    }

    // Constructor 
    public Productos() {
    	this.id = ++cont;
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
