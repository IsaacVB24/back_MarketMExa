package com.marketmexa.proyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketmexa.proyecto.model.Usuarios;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long>{
	
Optional<Usuarios> findByEmail(String email);
	
}//interface UsuariosRepository
