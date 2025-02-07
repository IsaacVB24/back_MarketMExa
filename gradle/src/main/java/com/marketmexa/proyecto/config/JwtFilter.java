package com.marketmexa.proyecto.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends GenericFilterBean {
	public static String secret = "#VasAIntentarAdivinar_:)CH49-GenerationMX";	// No incluir ¿, ?, acentos

	// Este filtro se coloca en toda la aplicación (EcommerceApplication.java)
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*
		 * >>> Validaciones <<<
		 * 1. request - solicitud
		 * 2. Authorization
		 * 3. URL, p.e, /api/usuarios/ GET, PUT, DELETE. POST no porque este método crea a un usuario, no se necesita filtro como en los otros métodos
		 * 4. /api/productos/ POST, DELETE, PUT
		 * 5. Bearer
		 * 6. Validar token
		 */
		
		// ---------------------------------------------------------- 1
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		// ---------------------------------------------------------- 1
		
		// ---------------------------------------------------------- 2
		String authHeader = httpServletRequest.getHeader("Authorization");
		// ---------------------------------------------------------- 2
		
		// ---------------------------------------------------------- 3 y 4
if( ("POST".equals(httpServletRequest.getMethod()) && !httpServletRequest.getRequestURI().contains("/api/usuarios/"))
 || ("GET".equals(httpServletRequest.getMethod()) && !httpServletRequest.getRequestURI().contains("/api/productos/"))
 || "PUT".equals(httpServletRequest.getMethod())
 || "DELETE".equals(httpServletRequest.getMethod()) ) {
		// ---------------------------------------------------------- 3 y 4
			
			// ---------------------------------------------------------- 5
			if(authHeader == null || !authHeader.startsWith("Bearer: ")) {
				System.out.println("-------------- 1. Invalid token ---------------");
				throw new ServletException("-------------- 1. Invalid token ---------------");
			}
			// ---------------------------------------------------------- 5
			
			// ---------------------------------------------------------- 6
			String token = authHeader.substring(7);
			try {
				Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();	// Claims es un conjunto de Keys, Values
				claims.forEach((key, value) -> System.out.println("Key: " + key + "\t|\tValue: " + value));
			} catch (SignatureException | MalformedJwtException | ExpiredJwtException e) {
				System.out.println("-------------- 2. Invalid token ---------------");
				throw new ServletException("-------------- 2. Invalid token ---------------");
			}	// Multicatch disponible en java 17
			
			/* Estas excepciones no eran necesarias (no errores en el código), sin embargo, al colocar el mouse sobre .parseClaimsJws dice que puede arrojar excepciones, de las cuales se tratan en el multicatch */
			// ---------------------------------------------------------- 6
		}	// If largo
		
		chain.doFilter(request, response);
	}
}