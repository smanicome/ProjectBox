package com.gui.beans.view;

import com.gui.beans.session.UserSession;
import com.gui.entities.Course;
import com.gui.entities.Project;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
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
    private SelectedCourse selectedCourse;

    private Collection<Project> projects;

    @PostConstruct
    public void load() {
        Collection<Course> list = session.getUser().getCourses();
        Optional<Course> opt = list.stream().filter( x -> x.getCode().equals(selectedCourse.getCourse().getCode()) ).findFirst();
        opt.ifPresent(x -> projects = x.getProjects());
    }

    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }
}
