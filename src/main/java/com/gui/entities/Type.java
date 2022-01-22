package com.gui.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "type")
public class Type {
	@Id @GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	private String name;
	
	/***************************************************************************
	 |  Setter Gettter
	***************************************************************************/
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/***************************************************************************
	 |  Inherited
	***************************************************************************/

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder().append("Type [id=").append(id)
				.append(", name=").append(name).append( "]" );
		return sb.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Type other = (Type) obj;
		return id == other.id && Objects.equals(name, other.name);
	}
}
