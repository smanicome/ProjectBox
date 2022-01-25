package com.gui.beans.session;

import com.gui.entities.Course;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class SelectedCourse implements Serializable {

	private static final long serialVersionUID = -1729744431751916974L;
	private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
