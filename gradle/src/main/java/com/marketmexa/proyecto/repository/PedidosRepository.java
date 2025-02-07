package com.marketmexa.proyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketmexa.proyecto.model.Pedidos;

// Esta interfaz va a permitir conectarnos a la BD
@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
	Optional<Pedidos> findByNombre(String nombre);
}