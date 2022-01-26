package com.gui.entities;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * <h1>User entity</h1>
 * <p>Defines User objects based on the related table in the database</p>
 * <p>A User has an id, a login, a firstname, a lastname, an email, a password and a type</p>
 */

@Entity
@Table(name = "user")
@NamedQueries({
	@NamedQuery(name = "User.login", query = "select us from User us where us.email = :email AND us.password = :password"),
	@NamedQuery(name = "User.findByid", query = "select us from User us where us.id = :id"),
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
	
	@OneToMany( mappedBy = "user", cascade = CascadeType.REMOVE )
    private List<Ip> ips;
	
	@JoinTable(name = "teams_users", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "team_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Team> teams;
	
	/***************************************************************************
	 |  Constructor
	***************************************************************************/

	/**
	 * Empty constructor
	 */

	public User() {
	}

	/**
	 * Constructor of user setting only the type of it
	 * @param type
	 */

	public User( Type type ) {
		Objects.requireNonNull( type );
		this.type = type;
	}

	/**
	 * Constructor setting the login, the firstname, the lastname and the email of the user
	 * @param login
	 * @param firstname
	 * @param lastname
	 * @param email
	 */

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

	/**
	 * Getter of columns of the table
	 * @return List of strings
	 */
	public static List<String> getColumns() {
		return columns;
	}

	/**
	 * Getter of the Id of the user
	 * @return id of type int
	 */

	public int getId() {
		return id;
	}

	/**
	 * Getter of user's login
	 * @return String login
	 */

	public String getLogin() {
		return login;
	}

	/**
	 * Setter of user's login
	 * @param login, type String
	 */

	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Getter of user's first name
	 * @return firstname, type String
	 */

	public String getFirstname() {
		return firstname;
	}

	/**
	 * Setter of user's first name
	 * @param firstname, type String
	 */

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Getter of user's last name
	 * @return lastname, type String
	 */

	public String getLastname() {
		return lastname;
	}

	/**
	 * Setter of user's last name
	 * @param lastname, type String
	 */

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Getter of user's email
	 * @return email, type String
	 */

	public String getEmail() {
		return email;
	}

	/**
	 * Setter of user's email
	 * @param email, type String
	 */

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter of user's password
	 * @return password, type String
	 */

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

	/**
	 * Getter of user's type
	 * @return Type's name, String
	 */

	public String getType() {
		return type.getName();
	}

	/**
	 * Set Type of user
	 * @param type, Type
	 */
	
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * Getter of the user's courses
	 * @return collection of Courses
	 */

	public Collection<Course> getCourses() {
        return courses;
    }

	/**
	 * Setter of the user's courses
	 * @param courses, collection of courses
	 */

    public void setCourses(Collection<Course> courses) {
        this.courses = courses;
    }


	/**
	 * Method to check if the user is a Student
	 * @return true is user is a student, false otherwise
	 */

	public boolean isStudent() {
		return type.getName().equals("Student");
	}

	/**
	 * Method to check if the user is a teacher
	 * @return true if the user is a teacher, false otherwise
	 */

	public boolean isTeacher() {
		return type.getName().equals("Teacher");
	}

	/**
	 * Returns a list of IPs
	 * @return IP list
	 */
	
	public List<Ip> getIps() {
		return ips;
	}

	/**
	 * Set Ip list
	 * @param ips, list of Ips objects
	 */

	public void setIps(List<Ip> ips) {
		this.ips = ips;
	}

	/***************************************************************************
	 |  Inherited
	***************************************************************************/

	/**
	 * Method to hash parameters of User object
	 * @return int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(email, firstname, id, type, lastname, login, password);
	}

	/**
	 * Equal method
	 * @param obj
	 * @return true if obj and current object are equal, false otherwise
	 */

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

	/**
	 * toString method
	 * @return a string with the values of the parameters of User object
	 */

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
