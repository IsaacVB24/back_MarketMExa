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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProductos")
    private Long id;
	@Column(nullable=false, unique = true, name="name")
    private String name;
    @Column(nullable=false, unique = true, name="description")
    private String description;
    @Column(nullable=false, unique = true, name="image")
    private String image;
    @Column(nullable=false, unique = true, name="price")
    private Double price;
    @Column(nullable=false, unique = true, name="stock")
    private Integer stock;
    // Falta columna de category / categoria y modificar la BD para añadir esta columna (también el script de la creación de la BD [GitHub])
    //private static Long cont =Long.valueOf(0);
  
       
       
    
    // Constructor con todos los parámetros excepto el ID
    public Productos(String name, String description, String image, Double price, Integer stock) {
       // this.id= ++cont;      
    	this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.stock = stock;
        
    }
    // Constructor 
    public Productos() {}
    
    // Getters y Setters
    
    public Long getId() {
        return id;
    }
	
	public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
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
        return "Producto [id=" + id + ", name=" + name + ", description=" + description 
                + ", image=" + image + ", price=" + price + ", stock=" + stock + "]";
    }
	
}