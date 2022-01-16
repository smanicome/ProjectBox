package com.gui.beans.forms;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.gui.database.DatabaseFactory;
import com.gui.database.UserORM;
import com.gui.entities.User;

import java.io.Serializable;
import java.util.Optional;

@Named
@RequestScoped
public class CredentialBean implements Serializable {
	
	private static final long serialVersionUID = -8168265610314578892L;
	
	@Inject
    private DatabaseFactory db;

	@Email @NotNull @NotEmpty(message="email is required")
    private String email = "";
	
	@NotNull @NotEmpty
    private String password = "";
    private boolean remember = false;

    public String getEmail() {
    	System.out.println( "get email" );
        return email;
    }

    public void setEmail(String email) {
    	System.out.println( "set email" );
        this.email = email;
    }

    public String getPassword() {
    	System.out.println( "get password" );
        return password;
    }

    public void setPassword(String password) {
    	System.out.println( "set password" );
        this.password = password;
    }

    public boolean isRemember() {
    	System.out.println( "get remember" );
        return remember;
    }

    public void setRemember(boolean remember) {
    	System.out.println( "set remember" );
        this.remember = remember;
    }

    public String auth() {
    	System.out.println("get dao :: ");
    	UserORM orm = db.getUserORM();
    	
    	Optional<User> opt = orm.getUser("yisa01@hotmail.fr");
    	if ( opt.isPresent() ) {
    		System.out.println("user getted");
    	}
    	else {
    		System.out.println("Patate");
    	}
    	/*DaoFactory factory = DaoFactory.getInstance();
    	UserDaoInterface userDao = factory.getUserDao();
    	System.out.println("step1");
		try {
			Optional<User> optionalUser = userDao.auth( email, password );
			if ( optionalUser.isPresent() ) {
				//session
	    		return "success";
	        }
	        else {
	        	System.out.println("step 11");
	            return "failure";
	        } 
		} catch (DaoException e) {
			System.out.println("step 12");
			return "failure";
		} 	*/
    	return "success";
    }
}
