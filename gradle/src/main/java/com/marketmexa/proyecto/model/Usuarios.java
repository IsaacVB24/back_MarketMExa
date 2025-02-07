package com.marketmexa.proyecto.model; //USERS

import java.time.LocalDate;

public class Usuarios {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String pass;
    private String address;
    private LocalDate user_registred;

    public Usuarios() {
    }

    public Usuarios(String name, String email, String phone, String pass, String address, LocalDate user_registred) {
        super();
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
