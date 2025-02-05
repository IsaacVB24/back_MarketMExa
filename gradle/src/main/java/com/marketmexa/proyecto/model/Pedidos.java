package com.marketmexa.proyecto.model;

public class Pedidos {
//wrapper
	private Long id_order;
	private Long users_id_user;
	private Long id_producto;
	private Double amount;
	private String order_date;
	private static Long cont = Long.valueOf(0);
	
	public Pedidos(Long users_id_user, Long id_producto, Double amount, String order_date) {
		super();
		this.id_order = ++cont;
		this.users_id_user = users_id_user;
		this.id_producto = id_producto;
		this.amount = amount;
		this.order_date = order_date;
		
	}//public pedidos
	
	public Pedidos() {
		this.id_order = ++cont;
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
