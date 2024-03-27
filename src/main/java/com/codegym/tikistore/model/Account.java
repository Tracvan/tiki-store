package com.codegym.tikistore.model;

public class Account {
    private String email;
    private String password;
    private String birth;
    private String address;
    private String role;
    private double wallet;

    private String gender;

    public Account(String email,
                   String password) {
        this.email = email;
        this.password = password;
    }

    public Account(String email,
                   String password,
                   String birth,
                   String address,
                   String role,
                   double wallet,
                   String gender) {
        this.email = email;
        this.password = password;
        this.birth = birth;
        this.address = address;
        this.role = role;
        this.wallet = wallet;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }
}
