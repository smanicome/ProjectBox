package com.gui.beans.session;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.gui.entities.Type;
import com.gui.entities.User;

/**
 * <h1>Handling User Session Bean</h1>
 * <p>A bean that handles the user's current session</p>
 * <p>Check its authentication and retrieve its data</p>
 */
@Named
@SessionScoped
public class UserSession implements Serializable{
	private static final long serialVersionUID = 1034130298933139208L;
	
	private boolean isAuth = false;
	private User user = new User( new Type( Type.DEFAULT_TYPE) );
	
	/***************************************************************************
	 |  Getter & Setter
	***************************************************************************/

	/**
	 * Getter of authentication state
	 * @return True if user is authentified, false otherwis
	 */

	public boolean isAuth() {
		return isAuth;
	}

	/**
	 * Setter of authentication state
	 * @param isAuth = True if user is authentified, false otherwis
	 */

	public void setAuth(boolean isAuth) {
		this.isAuth = isAuth;
	}

	/**
	 * Getter of the current user
	 * @return user, User
	 */

	public User getUser() {
		return user;
	}

	/**
	 * Setter of the current user
	 * @param user, User
	 */

	public void setUser(User user) {
		this.user = user;
	}
}
