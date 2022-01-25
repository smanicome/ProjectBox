package com.gui.beans.forms;

import com.gui.beans.session.UserSession;
import com.gui.database.CourseDaoInterface;
import com.gui.database.DatabaseFactory;
import com.gui.entities.Course;
import com.gui.services.Folder;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * <h1>Create Course Bean</h1>
 * <p>Allows user to create a course in the database</p>
 * <p>Initializes the course's name, the course's code</p>
 */

@Named
@RequestScoped
public class CreateCourseBean {
    @Inject
    private DatabaseFactory db;
    @Inject
    private UserSession session;

    private String code;
    private String name;

    /**
     * Get course's code
     * @return code, String
     */

    public String getCode() {
        return code;
    }

    /**
     * Set course's code
     * @param code, String
     */

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Get course's name
     * @return name, String
     */

    public String getName() {
        return name;
    }

    /**
     * Setter of course's name
     * @param name, String
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to save the new course into the database
     * @return "course_list" to then display the course list page
     */

    public String save() {
    	System.out.println( "save & move to course list" );
        Course c = new Course( code, name, session.getUser() );
        CourseDaoInterface dao = db.getCourseDAO();
        dao.create( c );
        Folder.create( code );
        return "course_list";
    }
}
