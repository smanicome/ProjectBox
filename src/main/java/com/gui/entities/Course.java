package com.gui.entities;

import javax.persistence.*;

import com.gui.adelete.Student;
import com.gui.adelete.Teacher;

import java.util.List;

@Entity
@Table(name = "course")
@NamedQueries({
        @NamedQuery(name = "Course.id", query = "select c from Course c where c.id = :id")
})
public class Course {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "name", nullable = false)
    private String name;
    @OneToMany
    private List<Project> projects;
    @ManyToMany
    private List<Student> students;
    @ManyToMany
    private List<Teacher> teachers;

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
