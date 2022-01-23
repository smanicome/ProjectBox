package com.gui.beans.view;

import com.gui.beans.session.UserSession;
import com.gui.database.DatabaseFactory;
import com.gui.entities.Course;
import com.gui.entities.Project;

import javax.annotation.PostConstruct;
import javax.faces.annotation.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

@Named
@ViewScoped
public class CourseProjectList implements Serializable {
	
	private static final long serialVersionUID = -9044487822404564248L;
	
	@Inject
	private UserSession session;

    @Inject
    @ManagedProperty(value="#{param.course}")
    private String courseCode;
    private Collection<Project> projects;

    @PostConstruct
    public void load() {
        Collection<Course> list = session.getUser().getCourses();
        Optional<Course> opt = list.stream().filter( x -> x.getCode().equals(courseCode) ).findFirst();
        opt.ifPresent(x -> projects = x.getProjects());
    }

    public String getCourseId() {
        return courseCode;
    }

    public void setCourseId(String courseCode) {
        this.courseCode = courseCode;
    }

    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }
}
