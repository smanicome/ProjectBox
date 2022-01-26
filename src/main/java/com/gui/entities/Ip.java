package com.gui.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * <h1>IP entities</h1>
 * <p>Define IP objects</p>
 * <p>Class linked to the course database table</p>
 * <p>An IP objects takes as parameters the ID of the user, an address and a user</p>
 */

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

	/**
	 *
	 * @return
	 */
	
	public int getId() {
		return id;
	}

	/**
	 *
	 * @return
	 */

	public String getAddress() {
		return address;
	}

	/**
	 *
	 * @param address
	 */

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 *
	 * @return
	 */

	public User getUser() {
		return user;
	}

	/**
	 *
	 *
	 * @param user
	 */

	public void setUser(User user) {
		this.user = user;
	}
	
	/***************************************************************************
	 |  Inherited
	***************************************************************************/

	/**
	 * ToString method
	 * @return String with id, address and user of IP object
	 */

	@Override
	public String toString() {
		return "Ip [id=" + id + ", address=" + address + ", user=" + user + "]";
	}

	/**
	 * HashCode method
	 * @return hashed values of the Object parameters
	 */

	@Override
	public int hashCode() {
		return Objects.hash(address, id, user);
	}

	/**
	 * Method that compares two objects to see if they are equal
	 * @param obj
	 * @return true if the two objects are equal, false otherwise
	 */

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
