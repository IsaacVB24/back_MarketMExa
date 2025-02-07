package com.marketmexa.proyecto.service;  //SERVICES

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.marketmexa.proyecto.model.Usuarios;
import com.marketmexa.proyecto.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {
    // Lista para almacenar los usuarios
	private final UsuarioRepository usuariosRepository;
	
    // Constructor donde se añaden algunos usuarios de ejemplo
	@Autowired
	public UsuariosService(UsuarioRepository usuariosRepository) {
		this.usuariosRepository = usuariosRepository;
	}//constructor
	
    // Obtener todos los usuarios
	public List<Usuarios> getAllUsuarios() {
		return usuariosRepository.findAll();
	}//getAllUsuarios
	
    //  Bbtener un usuario por su id
public Usuarios getUsuario(Long id) {
		
		return usuariosRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El usuario con el id ["	
		        + id + "] no existe.")
				);
	}//getUsuario

// Borrar un usuario por su id
public Usuarios deleteUsuario(Long id) {
	Usuarios user = null;
	if(usuariosRepository.existsById(id)) {
		user = usuariosRepository.findById(id).get();
		usuariosRepository.deleteById(id);
	}//ifexist
	
	return user;
	}//deleteUsuario


// Agregar un nuevo usuario
public Usuarios addUsuario(Usuarios usuario) {
	Optional<Usuarios> user = usuariosRepository.findByEmail(usuario.getEmail());
	if(user.isEmpty()) {
		return usuariosRepository.save(usuario);
	}else {
	return null;
	}//else
}//addusuario

// Actualiza un usuario existente
public Usuarios updateUsuario(Long id, ChangePassword changePassword) {
	Usuarios user = null;
	if (usuariosRepository.existsById(id)) {
		Usuarios usuario = usuariosRepository.findById(id).get();
		if(usuario.getPass().equals(changePassword.getPassword())) {
			usuario.setPassword(changePassword.getNpassword());
			user=usuario;
			usuariosRepository.save(usuario);
		}//equals
				
	}//exists
			
	return user;
}//update
}//UsuarioService

    

   

 

  

   

   
}
