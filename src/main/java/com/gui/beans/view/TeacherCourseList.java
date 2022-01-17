package com.gui.beans.view;


import com.gui.database.DatabaseFactory;
import com.gui.entities.Course;

import javax.annotation.PostConstruct;
import javax.el.MethodExpression;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;

@Named
@RequestScoped
public class TeacherCourseList {
    @Inject
    private DatabaseFactory db;

    private Collection<Course> courses;

    private Course selectedCourse;

    @PostConstruct
    public void init() {
        db.getTeacherDAO().getTeacherById(1).ifPresent(t -> courses = t.getCourses());
    }

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

    public String moveToCourse() {
        return "success?faces-redirect=true";
    }
}
