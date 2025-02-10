package com.marketmexa.proyecto.repository;
import com.marketmexa.proyecto.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long> {
    Optional<Productos> findByName(String name); // Para buscar un producto por nombre
}