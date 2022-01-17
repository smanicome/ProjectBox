/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gui.entities;

import com.gui.tools.StringListConverter;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.*;

/**
 *
 * @author angel
 */
@Entity
@Table(name = "student")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByLastname", query = "SELECT s FROM Student s WHERE s.lastname = :lastname"),
    @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id"),
    @NamedQuery(name = "Student.auth", query = "SELECT s FROM Student s WHERE s.password = :password AND s.email = :email")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "passwd")
    private String password;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @JoinTable(name = "students_courses", joinColumns = {
            @JoinColumn(name = "student_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "course_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Course> courses;
    @JoinTable(name = "students_teams", joinColumns = {
            @JoinColumn(name = "student_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "team_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Team> teams;
    @Convert(converter = StringListConverter.class)
    private Collection<String> ips;

    public Student() {
    }

    public Student(String firstname, String lastname, String password, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Collection<Course> getCourses() {
        return courses;
    }

    public void setCourses(Collection<Course> courses) {
        this.courses = courses;
    }

    public Collection<String> getIps() {
        return ips;
    }

    public void setIps(Collection<String> ips) {
        this.ips = ips;
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

    public Collection<Team> getTeams() {
        return teams;
    }

    public void setTeams(Collection<Team> teams) {
        this.teams = teams;
    }

	@Override
	public int hashCode() {
		return Objects.hash(courses, email, firstname, id, ips, lastname, password, teams);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(courses, other.courses) && Objects.equals(email, other.email)
				&& Objects.equals(firstname, other.firstname) && id == other.id && Objects.equals(ips, other.ips)
				&& Objects.equals(lastname, other.lastname) && Objects.equals(password, other.password)
				&& Objects.equals(teams, other.teams);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", password=" + password
				+ ", email=" + email + ", courses=" + courses + ", teams=" + teams + ", ips=" + ips + "]";
	}
    
    
}
