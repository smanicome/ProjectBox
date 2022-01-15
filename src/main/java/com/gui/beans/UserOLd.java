package com.gui.beans;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table( name="user" )
public class UserOLd {
	@Id @GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	private String login;
    private String password;
    private String email;
    //private String start_date;
    //private String end_date;
    
    //default for persistance 
    public UserOLd() {
    	
    }
    
    // login - login field can be empty
    public UserOLd( String email, String password ) {
    	Objects.requireNonNull( email );
        Objects.requireNonNull( password );

        this.password = password;
        this.email = email;
    }

    public UserOLd( String login, String password, String email ) {
        Objects.requireNonNull( login );
        Objects.requireNonNull( password );
        Objects.requireNonNull( email );

        this.login = login;
        this.password = password;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        Objects.requireNonNull( login );
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Objects.requireNonNull( password );
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Objects.requireNonNull( email );
        this.email = email;
    }
}
