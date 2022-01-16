package com.gui.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table( name="test" )
public class Test {
	@Id @GeneratedValue( strategy = GenerationType.AUTO )
	@Column(  name="id" )
	private int id;
	
	@Column(  name="login", nullable = false )
	private String login;
	@Column(  name="email", nullable = false )
	private String email;
	
	public Test() {
		this( "unknown", "unknown");
	}
	
	public Test( String login, String email ) {
        this.setLogin( login );
        this.setEmail( email );
    }
	
	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", email=" + email + "]";
	}
}