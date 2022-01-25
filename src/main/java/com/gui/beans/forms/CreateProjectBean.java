package com.gui.beans.forms;

import com.gui.beans.session.SelectedCourse;
import com.gui.database.DatabaseFactory;
import com.gui.entities.Course;
import com.gui.entities.Project;
import com.gui.services.Folder;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.Date;

/**
 * <h1>Create Project Bean</h1>
 * <p>Bean that allows user to create a new project</p>
 * <p>Initializes the project's related course, its deadline, description and name.</p>
 */
@Named
@RequestScoped
public class CreateProjectBean implements Serializable {

	private static final long serialVersionUID = -7182583977620221226L;

	@Inject
    private DatabaseFactory db;

    @Inject
    private SelectedCourse selectedCourse;

    private Date deadline = new Date();
    private String description;
    private String name;

    /**
     * Getter of project's description
     * @return description, String
     */

    public String getDescription() {
        return description;
    }

    /**
     * Setter of project's description
     * @param description, String
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter of project's name
     * @return name, String
     */

    public String getName() {
        return name;
    }

    /**
     * Setter of project's name
     * @param name, string
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter of project's deadline
     * @return deadline, type Date
     */

    public Date getDeadline() {
        return deadline;
    }

    /**
     * Setter of project's deadline
     * @param deadline, type Date
     */

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    /**
     * Save project into the data base
     * @return "project_list" to redirect to the project list page
     */

    public String save() {
    	Course course = selectedCourse.getCourse();
        Project p = new Project( name, description, deadline, course );
        db.getProjectDAO().create(p);
        Folder.create( course.getCode() + "/" + name );
        return "project_list";
    }
}
