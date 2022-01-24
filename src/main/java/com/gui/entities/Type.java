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
	public final static String DEFAULT_TYPE 	= "NONE";
	private final static String TEACHER_TYPE 	= "Teacher";
	private final static String STUDENT_TYPE 	= "Student";
	public enum typeEnum{
		TEACHER, STUDENT
	}
	
	@Id @GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	private String name;
	
	public Type() {
		
	}
	
	public Type( String name ) {
		Objects.requireNonNull( name );
		this.name = name;
	}
	
	public Type( typeEnum type ) {
		Objects.requireNonNull( type );
		switch (type) {
		case TEACHER:
			this.id = 1;
			this.name = TEACHER_TYPE;
			break;
		case STUDENT:
			this.id = 2;
			this.name = STUDENT_TYPE;
			break;
		default:
			new IllegalArgumentException();
			break;
		}
	}

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
