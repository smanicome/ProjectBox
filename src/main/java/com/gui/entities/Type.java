package com.gui.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <h1>Entity Type</h1>
 * <p>Define type objects based on the related table in the database</p>
 * <p>A type object has an id and a name</p>
 */

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
	
	/***************************************************************************
	 |  Constructor
	***************************************************************************/

	/**
	 * Empty constructor
	 */

	public Type() {
		
	}

	/**
	 * Constructor that sets Type's name
	 * @param name of type param
	 */

	public Type( String name ) {
		Objects.requireNonNull( name );
		this.name = name;
	}

	/**
	 * Constructor that sets type with an enumeration (TEACHER_TYPE, STUDENT_TYPE allowed)
	 * @param type, typeEnum
	 * @throws IllegalArgumentException if type has non valid value
	 */
	
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

	/**
	 * Getter of Type's id
	 * @return id of type int
	 */

	public int getId() {
		return id;
	}

	/**
	 * Getter of Type's name
	 * @return name of type String
	 */

	public String getName() {
		return name;
	}

	/**
	 * Setter of Type's name
	 * @param name of type String
	 */

	public void setName(String name) {
		this.name = name;
	}
	
	/***************************************************************************
	 |  Inherited
	***************************************************************************/

	/**
	 * toString method
	 * @return String containing name and id of the current Type
	 */

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder().append("Type [id=").append(id)
				.append(", name=").append(name).append( "]" );
		return sb.toString();
	}

	/**
	 * A method used to hash id and name of the Type
	 * @return int
	 */

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	/**
	 * equals method
	 * @param obj
	 * @return true if two objects are equal, false otherwise
	 */

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
