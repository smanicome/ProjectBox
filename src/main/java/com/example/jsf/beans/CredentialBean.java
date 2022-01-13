package com.example.jsf.beans;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("credentialBean")
@RequestScoped
public class CredentialBean implements Serializable {
    private String email;
    private String password;
    private boolean remember;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

    public void display() {
        System.out.println(email);
        System.out.println(password);
        setEmail("patate");
        setPassword("patate");
    }
}
