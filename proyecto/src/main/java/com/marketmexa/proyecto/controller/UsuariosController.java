package com.marketmexa.proyecto.controller; //CONTROLLER 

import java.util.List;

import com.marketmexa.proyecto.dto.ChangePassword;
import com.marketmexa.proyecto.model.Usuarios;
import com.marketmexa.proyecto.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/usuarios/")
public class UsuariosController {
    private final UsuariosService usuariosService;

    @Autowired
    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    // Obtener todos los usuarios existentes ..
    @GetMapping
    public List<Usuarios> obtenerUsuarios() {
        return usuariosService.getAllUsuarios();
    }

    // Obtener un usuario por su ID ..
    @GetMapping(path = "{usuarioId}")
    public Usuarios obtenerUsuario(@PathVariable("usuarioId") Long id) {
        return usuariosService.getUsuario(id);
    }

    // Borrar un usuario por ID ..
    @DeleteMapping(path = "{usuarioId}")
    public Usuarios borrarUsuario(@PathVariable("usuarioId") Long id) {
        return usuariosService.deleteUsuario(id);
    }

    // Agrega un nuevo ente :d
    @PostMapping
    public Usuarios agregarUsuario(@RequestBody Usuarios usuario) {
        return usuariosService.addUsuario(usuario);  // La fecha de registro ya se pasa desde el cliente
    }
    
    // Actualiza usuarios
    
    @PutMapping(path = "{usuarioId}")
    public Usuarios actualizarUsuario(@RequestBody ChangePassword changePassword, @PathVariable ("usuarioId") Long id) {
    	
    	return usuariosService.updateUsuario(id, changePassword);
    
    }
        
}