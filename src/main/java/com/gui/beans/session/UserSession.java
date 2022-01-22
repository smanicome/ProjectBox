package com.gui.beans.session;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.gui.entities.User;

@Named
@SessionScoped
public class UserSession implements Serializable{
	private static final long serialVersionUID = 1034130298933139208L;
	
	private boolean isAuth = false;
	private User user = new User();
	
	/***************************************************************************
	 |  Getter & Setter
	***************************************************************************/
	
	public boolean isAuth() {
		return isAuth;
	}
	public void setAuth(boolean isAuth) {
		this.isAuth = isAuth;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	/***************************************************************************
	 |  Business Logic
	***************************************************************************/
	
	public void checkAuthentification() {
		System.out.println("check");
		if ( !this.isAuth ) {
			System.out.println("redirect");
			doRedirect( "student_list.xhtml" );
		}
	}
	
	private void doRedirect( String url ) {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			fc.getExternalContext().redirect( url );
		} catch (IOException e) {
			System.out.println( e.getMessage() );
		}
	}
}
