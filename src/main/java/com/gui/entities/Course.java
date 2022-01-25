package com.gui.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

/**
 * <h1>Course Entity</h1>
 * <p>Define course objects<p>
 * <p>Class linked to the course database table</p>
 * <p>Object course has an id, a code, a name, a list of related projects, a list of related users.</p>
 */

@Entity
@Table(name = "course")
@NamedQueries({
        @NamedQuery(name = "Course.findByCode", query = "select c from Course c where c.code = :code")
})
public class Course {
	@Id @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "code", nullable = false)
    private String code;

    @OneToMany( mappedBy = "course" )
    private List<Project> projects;
    @JoinTable(name = "courses_users", joinColumns = {
    	@JoinColumn(name = "course_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id")})
    @ManyToMany
    private List<User> users = new ArrayList<>();
    
    /***************************************************************************
	 |  Constructor
	***************************************************************************/
    
    public Course() {
    }
    
    public Course( String code, String name, User user ) {
    	Objects.requireNonNull( code );
    	Objects.requireNonNull( name );
    	Objects.requireNonNull( user );
    	
    	this.code = code;
    	this.name = name;
    	this.users.add( user );
    }
    
    /***************************************************************************
	 |  Getter & Setter
	***************************************************************************/

    /**
     * Getter of projects
     * @return list of projects related to the course
     */

    public List<Project> getProjects() {
        return projects;
    }

    /**
     * Setter of projects
     * @param projects of type list
     */

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    /**
     * Method that adds a user to the List of Users of the course
     * @param user, type User
     */

    public void addUser(User user) {
        users.add(user);
    }

    /**
     *  Setter of users related to the course
     * @param users of type List
     */

    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * Getter of users related to the course
     * @return users of type list
     */

    public List<User> getUsers() {
        return users;
    }

    /**
     * Getter of course id
     * @return id of type String
     */

    public int getId() {
        return id;
    }

    /**
     * Getter of course Name
     * @return Name of type String
     */

    public String getName() {
        return name;
    }

    /**
     * Setter of course Name
     * @param name of type String
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter of course code
     * @return code of type String
     */

	public String getCode() {
		return code;
	}

    /**
     * Setter of course code
     * @param code of type String
     */

	public void setCode(String code) {
		this.code = code;
	}


}
