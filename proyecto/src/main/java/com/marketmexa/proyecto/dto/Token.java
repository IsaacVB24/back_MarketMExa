package com.marketmexa.proyecto.dto;
public class Token {
	private final String accessToken;
	
	public Token(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getAccess() {
		return accessToken;
	}
}