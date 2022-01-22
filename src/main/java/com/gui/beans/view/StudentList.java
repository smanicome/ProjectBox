package com.gui.beans.view;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gui.database.DatabaseFactory;
import com.gui.database.UserDaoInterface;
import com.gui.entities.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class StudentList implements Serializable {

	private static final long serialVersionUID = 6246932190759698681L;
	@Inject
	private DatabaseFactory db;
	private ArrayList<User> students = new ArrayList<>();
	
	@PostConstruct
	public void initialize() {
    	UserDaoInterface userDao = db.getUserDAO();
    	List<User> list = userDao.getUsers().stream().filter( x -> x.isStudent() ).collect( Collectors.toList() );
    	students = new ArrayList<User>(list);
	}

    public ArrayList<User> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<User> students) {
        this.students = students;
    }
}
