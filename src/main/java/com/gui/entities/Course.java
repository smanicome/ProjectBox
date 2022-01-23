package com.gui.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "course")
@NamedQueries({
        @NamedQuery(name = "Course.id", query = "select c from Course c where c.id = :id")
})
public class Course {
	@Id @GeneratedValue( strategy = GenerationType.IDENTITY )
    private String id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "code", nullable = false)
    private String code;
    
    @OneToMany( mappedBy = "course" )
    private List<Project> projects;
    /*@ManyToMany
    private List<Student> students;
    @ManyToMany
    private List<Teacher> teachers;*/

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    /*public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }*/

    public String getId() {
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
