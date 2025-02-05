package com.marketmexa.proyecto.controller;

import com.marketmexa.proyecto.model.Pedidos;
import com.marketmexa.proyecto.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/pedidos/")
public class PedidosController {

    private final PedidosService pedidosService;

    @Autowired
    public PedidosController(PedidosService pedidosService) {
        this.pedidosService = pedidosService;
    }//public

    @GetMapping
    public List<Pedidos> getPedidos() {
        return pedidosService.getAllPedidos();
    }//list

    @GetMapping(path = "{id_order}")
    public Pedidos getPedidos(@PathVariable("id_order") int id_order) {
        return pedidosService.getPedidos(id_order);
    }

    @PostMapping
    public Pedidos addPedidos(@RequestBody Pedidos pedidos) {
        return pedidosService.addPedido(pedidos);
    }

    @DeleteMapping(path = "{id_order}")
    public Pedidos deletePedidos(@PathVariable("id_order") int id_order) {
        return pedidosService.deletePedidos(id_order);
    }

    @PutMapping(path = "{id_order}")
    public Pedidos updatePedidos(
            @PathVariable("id_order") int id_order,
            @RequestParam(required = false) Integer users_id_user,
            @RequestParam(required = false) Integer id_producto,
            @RequestParam(required = false) Integer amount,
            @RequestParam(required = false) String order_date) {

        return pedidosService.upDatePedidos(id_order, users_id_user, id_producto, amount, order_date);
    }
}

