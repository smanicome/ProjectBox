package com.gui.entities;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.codec.digest.DigestUtils;

@Entity
@Table(name = "user")
@NamedQueries({
	@NamedQuery(name = "User.login", query = "select us from User us where us.email = :email AND us.password = :password"),
	@NamedQuery(name = "User.list", query = "select us from User us")
})
public class User {
	
	private static List<String> columns = Stream.of("login", "firstname", "lastname", "email").collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
	
	@Id @GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	private String login;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	@JoinColumn(name = "id_type", referencedColumnName = "id")
    @ManyToOne(optional = false)
	private Type type;
	
	@JoinTable(name = "courses_users", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "course_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Course> courses;
	
	/***************************************************************************
	 |  Constructor
	***************************************************************************/

	public User() {
	}
	
	public User( Type type ) {
		Objects.requireNonNull( type );
		this.type = type;
	}

	public User( String login, String firstname, String lastname, String email, Type type ) {
		this.setLogin( login );
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setEmail( email );
		this.setType(type);
	}
	
	/***************************************************************************
	 |  Getter & Setter
	***************************************************************************/
	
	public static List<String> getColumns() {
		return columns;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	/**
	 * Store the user password using SHA1 encode
	 * @param password
	 */
	public void setPassword(String password) {
		Objects.requireNonNull( password );
		this.password = DigestUtils.sha1Hex(password);
	}
	
	public String getType() {
		return type.getName();
	}
	
	public void setType(Type type) {
		this.type = type;
	}

	public Collection<Course> getCourses() {
        return courses;
    }

    public void setCourses(Collection<Course> courses) {
        this.courses = courses;
    }

	public boolean isStudent() {
		return type.getName().equals("Student");
	}
	
	public boolean isTeacher() {
		return type.getName().equals("Teacher");
	}
	
	/***************************************************************************
	 |  Inherited
	***************************************************************************/

	@Override
	public int hashCode() {
		return Objects.hash(email, firstname, id, type, lastname, login, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstname, other.firstname) && id == other.id
				&& Objects.equals(type, other.type) && Objects.equals(lastname, other.lastname)
				&& Objects.equals(login, other.login) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder().append("User [id=").append(id)
				.append(", login=").append(login)
				.append(", firstname=").append(firstname)
				.append(", lastname=" ).append(lastname)
				.append(", email=").append(email)
				.append(", type=").append( type.getName() );
		return sb.toString();
	}
	
	
}
