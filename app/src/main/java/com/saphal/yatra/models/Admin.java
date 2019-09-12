package com.saphal.yatra.models;

public class Admin {
    private String email;
    private String a;

    public Admin() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public Admin(String email, String a) {
        this.email = email;
        this.a = a;
    }
}
