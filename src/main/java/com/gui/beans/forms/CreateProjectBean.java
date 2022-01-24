package com.gui.beans.forms;

import com.gui.database.DatabaseFactory;
import com.gui.entities.Course;
import com.gui.entities.Project;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.Date;

@Named
@RequestScoped
public class CreateProjectBean implements Serializable {

	private static final long serialVersionUID = -7182583977620221226L;

	@Inject
    private DatabaseFactory db;

    @Inject
    @ManagedProperty(value="#{param.course}")
    private String courseCode;

    private Date deadline;
    private String description;
    private String name;
    
    @PostConstruct
	 public void load() {
		 System.out.println( "the course code post const :: " + courseCode );
	 }

    public String getDescription() {
    	System.out.println( "get description" );
        return description;
    }

    public void setDescription(String description) {
    	System.out.println( "set description" );
        this.description = description;
    }

    public String getName() {
    	System.out.println( "get name" );
        return name;
    }

    public void setName(String name) {
    	System.out.println( "set name" );
        this.name = name;
    }

    public Date getDeadline() {
    	System.out.println( "get deadline" );
        return deadline;
    }

    public void setDeadline(Date deadline) {
    	System.out.println( "set deadline" );
        this.deadline = deadline;
    }

    public String getCourseCode() {
    	System.out.println( "get code" );
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
    	System.out.println( "set code" );
		this.courseCode = courseCode;
	}

	public String save() {
		// TODO :: optional de course, date in db, remove hidden input to something else
    	System.out.println( "toto == "+ courseCode );
        Course course = db.getCourseDAO().getCourseByCode(courseCode);
        System.out.println( "set project" );

        Project p = new Project(name, description, deadline, course);
        System.out.println( "create project" );
        db.getProjectDAO().create(p);
        return "failure";
    }
}
