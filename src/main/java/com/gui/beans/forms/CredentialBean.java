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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

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
    
    public String logout() {
    	System.out.println( "log out" );
    	session.setAuth( false );
    	session.setUser( new User( new Type( Type.DEFAULT_TYPE) ) );
    	return "login";
    }
}
