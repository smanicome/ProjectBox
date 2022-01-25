package com.gui.beans.forms;

import com.gui.beans.session.SelectedCourse;
import com.gui.database.DatabaseFactory;
import com.gui.entities.Project;

import javax.enterprise.context.RequestScoped;
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
    private SelectedCourse selectedCourse;

    private Date deadline = new Date();
    private String description;
    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String save() {
        Project p = new Project( name, description, deadline, selectedCourse.getCourse() );
        db.getProjectDAO().create(p);
        return "project_list";
    }
}
