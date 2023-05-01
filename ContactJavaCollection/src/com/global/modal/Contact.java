package com.global.modal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contact {
    private String email;
    private String name;
    private String phone;
    private String address;

    public Contact(String email, String name, String phone, String address) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

	@Override
	public String toString() {
		return "Contact [email=" + email + ", name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}

    
    
}