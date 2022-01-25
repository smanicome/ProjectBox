package com.gui.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ip")
public class Ip {
	@Id @GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	private String address;
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private User user;
	
	/***************************************************************************
	 |  Constructor
	***************************************************************************/
	
	/***************************************************************************
	 |  Getter & Setter
	***************************************************************************/
	
	public int getId() {
		return id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	/***************************************************************************
	 |  Inherited
	***************************************************************************/
	
	@Override
	public String toString() {
		return "Ip [id=" + id + ", address=" + address + ", user=" + user + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, id, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ip other = (Ip) obj;
		return Objects.equals(address, other.address) && id == other.id && Objects.equals(user, other.user);
	}
}
