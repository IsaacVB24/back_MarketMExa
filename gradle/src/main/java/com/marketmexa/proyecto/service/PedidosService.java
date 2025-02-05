package com.marketmexa.proyecto.service;

import com.marketmexa.proyecto.model.Pedidos;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    private List<Pedidos> pedidosList = new ArrayList<>();  // Simula una base de datos en memoria

    // Obtener todos los pedidos
    public List<Pedidos> getAllPedidos() {
        return pedidosList;
    }//list

    // Obtener un pedido por ID
    public Pedidos getPedidos(Long id_order) {
        Optional<Pedidos> pedido = pedidosList.stream()
                .filter(p -> p.getId_order() == id_order)
                .findFirst();
        return pedido.orElse(null); // Retorna null si no se encuentra el pedido
    }//get

    // Agregar un nuevo pedido
    public Pedidos addPedido(Pedidos pedido) {
        pedidosList.add(pedido);
        return pedido;
    }//add

    // Eliminar un pedido por ID
    public Pedidos deletePedidos(Long id_order) {
        Pedidos pedido = getPedidos(id_order);
        if (pedido != null) {
            pedidosList.remove(pedido);
        }//if
        return pedido;
    }//delete

    // Actualizar un pedido existente
    public Pedidos upDatePedidos(Long id_order, Long users_id_user, Long id_producto, Double amount, String order_date) {
        Pedidos pedido = getPedidos(id_order);
        if (pedido != null) {
            if (users_id_user != null) pedido.setUsers_id_user(users_id_user);
            if (id_producto != null) pedido.setId_producto(id_producto);
            if (amount != null) pedido.setAmount(amount);
            if (order_date != null) pedido.setOrder_date(order_date);
        }//if
        return pedido;
    }//upDate
}//class
