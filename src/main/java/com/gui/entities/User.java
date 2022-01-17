package com.gui.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@NamedQueries({
	@NamedQuery(name = "User.login", query = "select us from User us where us.email = :email")
})
public class User {
	
	@Id @GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	private String login;
	private String firstname;
	private String lastname;
	private String email;

	public User() {
		this( "unknown", "unknown");
	}

	public User( String login, String firstname, String lastname, String email ) {
		this.setLogin( login );
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setEmail( email );
	}

	public User( String login, String email ) {
        this(login, null, null, email);
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


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
