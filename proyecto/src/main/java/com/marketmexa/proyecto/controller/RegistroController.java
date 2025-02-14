package com.marketmexa.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.marketmexa.proyecto.model.Usuarios;
import com.marketmexa.proyecto.service.UsuariosService;

@RestController
@RequestMapping(path="api") //http:/localhost:8080/api
public class RegistroController {
    
    private final UsuariosService usuariosService;

    @Autowired
    public RegistroController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @PostMapping("/registro")
    public ResponseEntity<String> registrarUsuario(@RequestBody Usuarios usuarioDTO) {
        Usuarios nuevoUsuario = usuariosService.addUsuario(usuarioDTO);
        
        if (nuevoUsuario == null) {
            return ResponseEntity.badRequest().body("Error: El correo ya está registrado.");
        }

        return ResponseEntity.ok("Usuario registrado exitosamente: " + nuevoUsuario.getEmail());
    }

    }
}