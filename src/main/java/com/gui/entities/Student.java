/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gui.entities;

import com.gui.tools.StringListConverter;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author angel
 */
@Entity
@Table(name = "student")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByLogin", query = "SELECT s FROM Student s WHERE s.login = :login"),
    @NamedQuery(name = "Student.findByLastname", query = "SELECT s FROM Student s WHERE s.lastname = :lastname"),
    @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id"),
    @NamedQuery(name = "Student.findByPassword", query = "SELECT s FROM Student s WHERE s.password = :password")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
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

    public Student(String login) {
        this.login = login;
    }

    public Student(String login, String firstname, String lastname, int id, String password) {
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gui.entities.Student[ login=" + login + " ]";
    }
    
}
