package com.marketmexa.proyecto.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", unique = true, nullable = false)
    private Long id_order;

    @Column(name = "users_id_user", nullable = false)
    private Long users_id_user;

    @Column(name = "id_producto", nullable = false)
    private Long id_producto;

    @Column(nullable = false)
    private Double amount;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime order_date;

    // Constructor sin ID (auto-generado)
    public Pedidos(Long users_id_user, Long id_producto, Double amount, LocalDateTime order_date) {
        this.users_id_user = users_id_user;
        this.id_producto = id_producto;
        this.amount = amount;
        this.order_date = order_date;
    }
   
    // Constructor vacío (necesario para JPA)
    public Pedidos() {
    }

    // Getters y Setters
    public Long getId_order() {
        return id_order;
    }

    public Long getUsers_id_user() {
        return users_id_user;
    }

    public void setUsers_id_user(Long users_id_user) {
        this.users_id_user = users_id_user;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrderDate(LocalDateTime order_date) {
        this.order_date = order_date;
    }

    @Override
    public String toString() {
        return "Pedidos [id_order=" + id_order + ", users_id_user=" + users_id_user + ", id_producto=" + id_producto
                + ", amount=" + amount + ", order_date=" + order_date + "]";
    }
}
