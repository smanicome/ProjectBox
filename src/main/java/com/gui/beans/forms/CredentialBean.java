package com.gui.beans.forms;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.commons.codec.digest.DigestUtils;

import com.gui.beans.session.UserSession;
import com.gui.database.DatabaseFactory;
import com.gui.database.UserDaoInterface;
import com.gui.entities.Type;
import com.gui.entities.User;

import java.io.Serializable;
import java.util.Optional;

/**
 * <h1>Login</h1>
 * <p>A bean used to login</p>
 * <p>Retrieves data from login.xhtml and compares it to the database</p>
 */

@Named
@RequestScoped
public class CredentialBean implements Serializable {
	
	private static final long serialVersionUID = -8168265610314578892L;
	
	@Inject
    private DatabaseFactory db;
	
	@Inject
	private UserSession session;

	@Email @NotNull @NotEmpty(message="email is required")
    private String email = "";
	
	@NotNull @NotEmpty
    private String password = "";
    private boolean remember = false;

    /**
     * Getter used to retrieve parameter email
     * @return email of type String
     */

    public String getEmail() {
        return email;
    }

    /**
     * Setter used to set parameter email
     * @param email of type String
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter used to retrieve parameter password
     * @return password of type String
     */

    public String getPassword() {
        return password;
    }

    /**
     * Setter used to set parameter password
     * @param password of type String
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * get status of remember me checkbox
     * @return remember of type boolean
     */

    public boolean isRemember() {
        return remember;
    }

    /**
     * set status of remember me checkbox
     * @param remember of type boolean
     */

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

    /**
     * method used to authentify the user
     * compares the email and the password retrieved from the form to the database tables
     * @return the type of the user if the user was in the database (teacher or student)
     * @return "failure" if the user was not in the database
     */

    public String auth() {
    	UserDaoInterface dao = db.getUserDAO();
    	
    	Optional<User> optionalUser = dao.getUser(email, DigestUtils.sha1Hex(password));
    	if ( optionalUser.isPresent() ) {
    		User user = optionalUser.get();
    		session.setAuth(true);
    		session.setUser( user );
    		return user.getType();
    	}
    	else {
    		return "failure";
    	}
    }

    /**
     * logout from current session, set the user type back to "NONE"
     * @return "login" to go back to the login page
     */
    
    public String logout() {
    	System.out.println( "log out" );
    	session.setAuth( false );
    	session.setUser( new User( new Type( Type.DEFAULT_TYPE) ) );
    	return "login";
    }
}
