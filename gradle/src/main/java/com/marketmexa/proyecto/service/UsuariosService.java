package com.marketmexa.proyecto.service;  //SERVICES

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.marketmexa.proyecto.model.Usuarios;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {
    // Lista para almacenar los usuarios
    private final List<Usuarios> usuarios = new ArrayList<>();

    // Constructor donde se añaden algunos usuarios de ejemplo
    public UsuariosService() {
        usuarios.add(new Usuarios("Roge Acosta", "roge.acosta@example.com", "5551234567", "password123", "Calle 123, CDMX", LocalDate.now()));
        usuarios.add(new Usuarios("Carmen Garcia", "carmen.garcia@example.com", "5557654321", "securePass", "Av. Reforma 456, CDMX", LocalDate.now()));
        usuarios.add(new Usuarios("Isaac Vic", "isaac.vic@example.com", "5559876543", "1234abcd", "Blvd. Insurgentes 789, CDMX",LocalDate.now()));
    }

    // Bbtener todos los usuarios
    public List<Usuarios> getAllUsuarios() {
        return usuarios;
    }

    //  Bbtener un usuario por su id
    public Usuarios getUsuario(Long id) {
        for (Usuarios usuario : usuarios) {
            if (usuario.getId().equals(id)) return usuario;
        }
        return null;  // Si no se encuentra el usuario, retorna null
    }

    // Borrar un usuario por su id
    public Usuarios deleteUsuario(Long id) {
        Usuarios usuario = null;
        for (Usuarios u : usuarios) {
            if (u.getId().equals(id)) {
                usuario = u;
                usuarios.remove(u);  // Remueve el usuario de la lista
                break;
            }
        }
        return usuario;  // Devuelve el usuario eliminado
    }

    // Agregar un nuevo usuario
    public Usuarios addUsuario(Usuarios usuario) {
        // Verifica si ya existe un usuario con el mismo correo
        for (Usuarios u : usuarios) {
            if (u.getEmail().equals(usuario.getEmail())) {
                return null;  // Si el correo ya existe, no se añade el usuario (excluido :c)
            }
        }
        
        // Aquí creo no es necesario setear user_registred, ya que viene en el objeto 'usuario'.
        usuarios.add(usuario);  // Añade el usuario a la lista
        return usuario;  // Usuario agregado
    }

    // Actualiza un usuario existente
    public Usuarios updateUsuario(Long id, String name, String email, String phone, String pass, String address, LocalDate user_registred) {
        Usuarios usuario = null;
        for (Usuarios u : usuarios) {
            if (u.getId().equals(id)) {
                // Se actualizan solo los campos que no sean null
                if (name != null) u.setName(name);
                if (email != null) u.setEmail(email);
                if (phone != null) u.setPhone(phone);
                if (pass != null) u.setPass(pass);
                if (address != null) u.setAddress(address);
                if (user_registred != null) u.setUser_registred(user_registred);  // Si se pasa una fecha de registro, se actualiza
                usuario = u;  // Se guarda el usuario actualizado
                break;
            }
        }
        return usuario;  // Vientos
    }
}
