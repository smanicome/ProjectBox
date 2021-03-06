package com.gui.beans.forms;

import com.gui.beans.session.UserSession;
import com.gui.beans.view.SelectedCourse;
import com.gui.database.DatabaseFactory;
import com.gui.entities.Course;
import com.gui.entities.Project;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

@Named
@RequestScoped
public class CreateProjectBean {
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

    public void save() {
        Project p = new Project();
        p.setName(name);
        p.setDescription(description);
        p.setDeadline(deadline);
        p.setCourse(selectedCourse.getCourse());
        db.getProjectDAO().create(p);
    }
}
