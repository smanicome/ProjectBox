package com.gui.beans.forms;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gui.beans.session.UserSession;
import com.gui.database.DatabaseFactory;
import com.gui.entities.User;

/**
 * <h1>Update account settings Bean</h1>
 * <p>Bean that allows Users of teacher type to change their name, last name and password values in the database</p>
 */
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

	/**
	 * Getter of firstname
	 * @return forstname, String
	 */

	public String getFirstname() {
		return firstname;
	}

	/**
	 * setter of Firstname
	 * @param firstname, String
	 */

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Getter of lastname
	 * @return lastname, String
	 */

	public String getLastname() {
		return lastname;
	}

	/**
	 * Setter of lastname
	 * @param lastname, String
	 */

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Getter of password
	 * @return password, String
	 */

	public String getPassword() {
		return password;
	}

	/**
	 * Setter of password
	 * @param password, String
	 */

	public void setPassword(String password) {
		this.password = password;
	}
	
	/***************************************************************************
	 |  Action & Listener
	***************************************************************************/

	/**
	 * Update User from current session
	 * if user is of teacher Type, allows user to set firstname, Lastname and change password
	 * @return "teacher_landing_page" if teacher type,  to go back on teacher landing page after operations
	 * returns "student_landing_page" to go on student landing page if student type
	 */
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
