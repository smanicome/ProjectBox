package com.gui.beans.forms;

import com.gui.beans.session.UserSession;
import com.gui.database.CourseDaoInterface;
import com.gui.database.DatabaseFactory;
import com.gui.entities.Course;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CreateCourseBean {
    @Inject
    private DatabaseFactory db;
    @Inject
    private UserSession session;

    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void save() {
        Course c = new Course( code, name, session.getUser() );
        CourseDaoInterface dao = db.getCourseDAO();
        dao.create( c );
    }
}
