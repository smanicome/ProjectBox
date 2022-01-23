package com.gui.beans.view;


import com.gui.beans.session.UserSession;
import com.gui.entities.Course;
import com.gui.entities.User;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.Collection;

@Named
@ViewScoped
public class TeacherCourseList implements Serializable {

	private static final long serialVersionUID = 5101202772139205460L;
	
	@Inject
	private UserSession session;

    private Collection<Course> courses;

    private Course selectedCourse;

    @PostConstruct
    public void init() {
    	User teacher = session.getUser();
    	courses = teacher.getCourses();
    }
    
    /***************************************************************************
	 |  Getter & Setter
	***************************************************************************/

    public Collection<Course> getCourses() {
        return courses;
    }

    public void setCourses(Collection<Course> courses) {
        this.courses = courses;
    }

    public Course getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(Course selectedCourse) {
        this.selectedCourse = selectedCourse;
    }
    
    /***************************************************************************
	 |  Listener & Action
	***************************************************************************/

    public String moveToCourse() {
        return "?faces-redirect=true";
    }
}
