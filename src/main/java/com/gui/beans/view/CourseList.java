package com.gui.beans.view;


import com.gui.beans.session.UserSession;
import com.gui.database.DatabaseFactory;
import com.gui.database.UserDaoInterface;
import com.gui.entities.Course;
import com.gui.entities.User;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

@Named
@ViewScoped
public class CourseList implements Serializable {

	private static final long serialVersionUID = 5101202772139205460L;
	
	@Inject
	private UserSession session;
	
	@Inject
	private DatabaseFactory db;

    private Collection<Course> courses;

    @PostConstruct
    public void init() {
    	User user = session.getUser();
    	UserDaoInterface dao = db.getUserDAO();
    	Optional<User> opt = dao.getUserById( user.getId() );
    	opt.ifPresent( userX -> courses = userX.getCourses() );
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
    
    /***************************************************************************
	 |  Listener & Action
	***************************************************************************/

    public String moveToProject() {
        return "project_list";
    }
}
