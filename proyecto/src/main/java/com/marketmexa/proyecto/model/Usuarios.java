package com.marketmexa.proyecto.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Usuarios {
   // private static Long cont = Long.valueOf(0);
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id_user")
    private Long id;
    @Column(nullable = false, length = 50, name="name")
    private String name;
    @Column(nullable = false, unique = true, length = 50, name="email")
    private String email;
    @Column(nullable = false, unique = true, length = 50, name="phone")
    private String phone;
    @Column(nullable = false, length = 60, name="pass")
    private String pass;
    @Column(name = "user_registred", nullable = false, columnDefinition = "date default CURRENT_DATE")
    private LocalDate user_registred;
    @Column(nullable = false, length = 100, name="address")
    private String address;

    public Usuarios() {
       // this.id = ++cont;
    }

    public Usuarios(String name, String email, String phone, String pass, String address, LocalDate user_registred) {
        super();
       // this.id = ++cont;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.pass = pass;
        this.user_registred = user_registred;
        this.address = address;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public LocalDate getUser_registred() {
		return user_registred;
	}

	public void setUser_registred(LocalDate localDate) {
		this.user_registred = localDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
    public String toString() {
        return "Usuarios [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", pass=" + pass 
                + ", user_registred=" + user_registred + ", address=" + address + "]";
    }

}