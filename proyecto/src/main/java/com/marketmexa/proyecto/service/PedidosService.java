package com.marketmexa.proyecto.service;

import com.marketmexa.proyecto.model.Pedidos;
import com.marketmexa.proyecto.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

    // Obtener todos los pedidos
    public List<Pedidos> getAllPedidos() {
        return pedidosRepository.findAll();
    }

    // Obtener un pedido por ID
    public Optional<Pedidos> getPedidoById(Long id) {
        return pedidosRepository.findById(id);
    }

    // Agregar un nuevo pedido
    public Pedidos addPedido(Pedidos pedido) {
        return pedidosRepository.save(pedido);
    }

    // Eliminar un pedido por ID
    public void deletePedido(Long id) {
        pedidosRepository.deleteById(id);
    }

    // Actualizar un pedido existente
    public Pedidos updatePedido(Long id, Pedidos pedidoDetails) {
        return pedidosRepository.findById(id).map(pedido -> {
            pedido.setUsers_id_user(pedidoDetails.getUsers_id_user());
           // pedido.setIdProducto(pedidoDetails.getIdProducto());
            pedido.setAmount(pedidoDetails.getAmount());
            //pedido.setOrderDate(pedidoDetails.getOrderDate());
            return pedidosRepository.save(pedido);
        }).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }
}