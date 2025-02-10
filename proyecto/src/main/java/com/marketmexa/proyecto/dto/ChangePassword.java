package com.marketmexa.proyecto.dto;
//data transfer object

public class ChangePassword {
	
	private String password;
	private String npassword;
	public ChangePassword(String password, String npassword) {
		this.password = password;
		this.npassword = npassword;
	}//constructor
	public ChangePassword() {
	}//constructor 
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNpassword() {
		return npassword;
	}
	public void setNpassword(String npassword) {
		this.npassword = npassword;
	}
	@Override
	public String toString() {
		return "ChangePassword [password=" + password + ", npassword=" + npassword + "]";
	}//to String
	
	

}//class ChangePassword
