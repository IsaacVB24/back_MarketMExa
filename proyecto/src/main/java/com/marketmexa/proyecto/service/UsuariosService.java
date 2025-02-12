package com.marketmexa.proyecto.service;  //SERVICES

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.marketmexa.proyecto.dto.ChangePassword;
import com.marketmexa.proyecto.model.Usuarios;
import com.marketmexa.proyecto.repository.UsuariosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {
	
	@Autowired
	private PasswordEncoder encoder;
	
    // Lista para almacenar los usuarios
	private final UsuariosRepository usuariosRepository;
	
    // Constructor donde se añaden algunos usuarios de ejemplo
	@Autowired
	public UsuariosService(UsuariosRepository usuariosRepository) {
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



    public boolean validateUser(Usuarios usuario) {
		Optional<Usuarios> user = usuariosRepository.findByEmail(usuario.getEmail());
		if(user.isPresent()) {
			Usuarios tmpUser = user.get();
			//			if(tmpUser.getPass().equals(usuario.getPass())) 
             if(encoder.matches(usuario.getPass(), tmpUser.getPass())){
            	 return true;
}		
}
		return false;
	}

 // Agregar un nuevo usuario
     public Usuarios addUsuario(Usuarios usuario) {
         Optional<Usuarios> user = usuariosRepository.findByEmail(usuario.getEmail());

         if (user.isPresent()) {
             throw new IllegalArgumentException("El correo ya está registrado.");
         }
         usuario.setPass(encoder.encode(usuario.getPass()));
         usuario.setUser_registred(LocalDate.now()); // Asigna la fecha de registro actual
         return usuariosRepository.save(usuario);
     }//addusuario

     
     
  // Actualiza un usuario existente
     public Usuarios updateUsuario(Long id, ChangePassword changePassword) {
    	 Usuarios user= null;
         if (usuariosRepository.existsById(id)) {
             Usuarios usuario = usuariosRepository.findById(id).get();
             if(encoder.matches(changePassword.getPassword(), usuario.getPass())) {
                 usuario.setPass(encoder.encode(changePassword.getNpassword()));
                 
                 user=usuario;// Devuelve el usuario actualizado
                 usuariosRepository.save(usuario);
             } 
         } 
         return user;
     }



     }//UsuarioService