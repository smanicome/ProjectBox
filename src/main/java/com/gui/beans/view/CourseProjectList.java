package com.gui.beans.view;

import com.gui.database.DatabaseFactory;
import com.gui.entities.Project;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@RequestScoped
public class CourseProjectList implements Serializable {
    @Inject
    private DatabaseFactory db;

    @Inject
    @ManagedProperty(value="#{param.course}")
    private String courseId;
    private Collection<Project> projects;

    @PostConstruct
    public void load() {
        System.out.println(courseId);
        projects = db.getProjectDAO().getProjectsByCourse(courseId);
        System.out.println(projects.size());
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }
}
