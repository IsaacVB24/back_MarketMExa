package com.marketmexa.proyecto.model;

public class Pedidos {

	private int id_order;
	private int users_id_user;
	private int id_producto;
	private int amount;
	private String order_date;
	
	public Pedidos(int id_order, int users_id_user, int id_producto, int amount, String order_date) {
		super();
		this.id_order = id_order;
		this.users_id_user = users_id_user;
		this.id_producto = id_producto;
		this.amount = amount;
		this.order_date = order_date;
	}//public pedidos
	
	public Pedidos() {};//constructor vacio

	public int getId_order() {
		return id_order;
	}

	public void setId_order(int id_order) {
		this.id_order = id_order;
	}

	public int getUsers_id_user() {
		return users_id_user;
	}

	public void setUsers_id_user(int users_id_user) {
		this.users_id_user = users_id_user;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
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
