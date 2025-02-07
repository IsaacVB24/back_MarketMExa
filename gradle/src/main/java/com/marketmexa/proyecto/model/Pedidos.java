package com.marketmexa.proyecto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Pedidos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order", unique = true, nullable = false)
	private Long id_order;
	@Column(nullable = false)
	private Long users_id_user;
	@Column(nullable = false)
	private Long id_producto;
	@Column(nullable = false)
	private Double amount;
	@Column(nullable = false)
	private String order_date;
	
	public Pedidos(Long users_id_user, Long id_producto, Double amount, String order_date) {
		super();
		this.users_id_user = users_id_user;
		this.id_producto = id_producto;
		this.amount = amount;
		this.order_date = order_date;
		
	}//public pedidos
	
	public Pedidos() {
	};//constructor vacio
	
	
//getter setter
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

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
// to string
	@Override
	public String toString() {
		return "Pedidos [id_order=" + id_order + ", users_id_user=" + users_id_user + ", id_producto=" + id_producto
				+ ", amount=" + amount + ", order_date=" + order_date + "]";
	}

}//class pedidos
