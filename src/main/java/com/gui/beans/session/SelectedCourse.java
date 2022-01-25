package com.gui.beans.session;

import com.gui.entities.Course;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Bean used with createProjectBean to link a project to a selected course
 * takes a course as parameter
 */
@Named
@SessionScoped
public class SelectedCourse implements Serializable {

	private static final long serialVersionUID = -1729744431751916974L;
	private Course course;

    /**
     * Getter of course
     * @return current Course
     */

    public Course getCourse() {
        return course;
    }

    /**
     * Setter of current course
     * @param course, Course
     */

    public void setCourse(Course course) {
        this.course = course;
    }
}
