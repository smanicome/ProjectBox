package com.gui.beans.forms;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gui.beans.session.UserSession;
import com.gui.database.DatabaseFactory;
import com.gui.entities.User;

@Named
@RequestScoped
public class AccountSettingsBean implements Serializable{

	private static final long serialVersionUID = 3465390338080492701L;
	@Inject
    private UserSession session;
	@Inject
    private DatabaseFactory db;
	private String firstname;
	private String lastname;
	private String password;
	
	/***************************************************************************
	 |  Getter & Setter
	***************************************************************************/
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/***************************************************************************
	 |  Action & Listener
	***************************************************************************/
	
	public String update() {
		User user = session.getUser();
		if ( user.isTeacher() ) {
			user.setFirstname( firstname );
			user.setLastname( lastname );
			user.setPassword( password );
			db.getUserDAO().update( user );
			//set message ui
			return "teacher_landing_page";
		}
		else {
			return "student_landing_page";
		}
	}
}
