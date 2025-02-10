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

public class JwtFilter extends GenericFilterBean{

	public static String secret = "ElEquipo5#EsElMejor$ElEquipo5EsElMejor7";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//rquest
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		//HeaderAthorization
		String authHeader = httpServletRequest.getHeader("Authorization");
		
		if( ("POST".equals(httpServletRequest.getMethod()) &&
		(! httpServletRequest.getRequestURI().contains("/api/usuarios/")) )
		||
		("GET".equals(httpServletRequest.getMethod()) &&
		( httpServletRequest.getRequestURI().contains("/api/produtos/")) )
		
		||("PUT".equals(httpServletRequest.getMethod()) )
		||("DELETE".equals(httpServletRequest.getMethod()) )

				) {
		//URL /api/usuarios/get/put/delete
		//api/productos/delete, put, post
		//Bearer
		if(authHeader==null || !authHeader.startsWith("Bearer: ")) {
			System.out.println("1.Invalid Token");
			throw new ServletException("1.Invalid Token");
			
		}//if
		//Validad Token
		String token = authHeader.substring(7);
		try {
		Claims claims = Jwts.parser().setSigningKey(secret)
				.parseClaimsJws(token).getBody();
		claims.forEach(
				(key, value)-> System.out.println("Key: " + key + "value: " + value));
		}catch(SignatureException | MalformedJwtException | ExpiredJwtException e) {
			System.out.println("2. Invalid Token");
			throw new ServletException("2. Invalid Token");
		}//catch
		}//if method
		chain.doFilter(request, response);
		
	}//doFilter

}//class JwttFilter