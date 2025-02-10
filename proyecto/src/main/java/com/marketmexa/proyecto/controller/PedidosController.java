package com.marketmexa.proyecto.controller;

import com.marketmexa.proyecto.model.Pedidos;
import com.marketmexa.proyecto.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    // Obtener todos los pedidos
    @GetMapping
    public List<Pedidos> getAllPedidos() {
        return pedidosService.getAllPedidos();
    }

    // Obtener un pedido por ID
    @GetMapping("/{id}")
    public Optional<Pedidos> getPedidoById(@PathVariable Long id) {
        return pedidosService.getPedidoById(id);
    }

    // Crear un nuevo pedido
    @PostMapping
    public Pedidos addPedido(@RequestBody Pedidos pedido) {
        return pedidosService.addPedido(pedido);
    }

    // Actualizar un pedido
    @PutMapping("/{id}")
    public Pedidos updatePedido(@PathVariable Long id, @RequestBody Pedidos pedidoDetails) {
        return pedidosService.updatePedido(id, pedidoDetails);
    }

    // Eliminar un pedido
    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable Long id) {
        pedidosService.deletePedido(id);
    }
}