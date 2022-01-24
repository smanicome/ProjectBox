package com.gui.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

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
    @ManyToMany
    private List<User> users = new ArrayList<>();

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


}
