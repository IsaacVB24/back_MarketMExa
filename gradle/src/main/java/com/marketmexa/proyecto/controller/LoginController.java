package com.marketmexa.proyecto.controller;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketmexa.proyecto.dto.Token;
import com.marketmexa.proyecto.model.Usuarios;
import com.marketmexa.proyecto.service.UsuariosService;

@RestController
@RequestMapping(path = "/api/login/")
public class LoginController {
	private final UsuariosService usuariosService;
	
	@Autowired
	public LoginController(UsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}
	
	@PostMapping
	public Token login(@RequestBody Usuarios usuario) throws ServletException {
		if(usuariosService.validateUser(usuario)) return new Token(generateToken(usuario.getEmail()));
		
		throw new ServletException("Nombre de usuario o contraseña incorrectos [" + usuario.getEmail() + "]");
	}
	
	private String generateToken(String email) {
		Calendar calendar = Calendar.getInstance();	// Fecha y hora de hoy
		// calendar.add(Calendar.MINUTE, 30); -> Para loguearse cada media hora ya que expiraría el token (más real)
		calendar.add(Calendar.HOUR, 12);	// Para pruebas
		return Jwts.builder()		// Estructura en https://jwt.io/
				.setSubject(email)
				.claim("role", "user")
				.setIssuedAt(new Date())
				.setExpiration(calendar.getTime())
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
				.compact();
	}
}