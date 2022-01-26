package com.gui.beans;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.gui.beans.session.UserSession;

/**
 * <h1>Navigation accessibility</h1>
 * <p>Defines the type of accessibility and redirect client to their landing page</p>
 */
@Named
@ApplicationScoped
public class NavigationAccess {
	@Inject
	private UserSession session;
	
	/***************************************************************************
	 |  Public method
	***************************************************************************/
	
	/**
	 * Method that redirects the user to their landing page if a user is authentified
	 * @throws IOException if view doesn't exist
	 */
	public void notAuthentifiedOnly() throws IOException {
		if ( session.isAuth() ) {
			if ( session.getUser().isTeacher() ) {
				redirectToTeacherLandingPage();
			}
			else {
				redirectToStudentLandingPage();
			}
		}
	}
	
	/**
	 * Method that redirects the user to the login if this one is not authentified
	 * @throws IOException if view doesn't exist
	 */
	public void authentifiedOnly() throws IOException {
		if ( !session.isAuth() ) {
			redirectToLogin();
		}
	}
	
	/**
	 * Method that redirects the user to their landing page if this one is not a teacher
	 * @throws IOException if view doesn't exist
	 */
	public void teacherOnly() throws IOException {
		if ( !session.isAuth() ) {
			redirectToLogin();
		}
		else {
			if ( session.getUser().isStudent() ) {
				redirectToStudentLandingPage();
			}
		}
	}
	
	/**
	 * Method that redirects the user to their landing page if this one is not a student
	 * @throws IOException if view doesn't exist
	 */
	public void studentOnly() throws IOException {
		if ( !session.isAuth() ) {
			redirectToLogin();
		}
		else {
			if ( session.getUser().isTeacher() ) {
				redirectToTeacherLandingPage();
			}
		}
	}
	
	/***************************************************************************
	 |  Private method
	***************************************************************************/
	
	/**
	 * Method that redirects to Login page
	 * @throws IOException if view doesn't exist
	 */
	private void redirectToLogin() throws IOException {
		doRedirect( "login.xhtml" );
	}
	
	/**
	 * Method that redirects to Student landing page
	 * @throws IOException if view doesn't exist
	 */
	private void redirectToStudentLandingPage() throws IOException {
		doRedirect( "course_list.xhtml" );
	}
	
	/**
	 * Method that redirects to Teacher landing page
	 * @throws IOException if view doesn't exist
	 */
	private void redirectToTeacherLandingPage() throws IOException {
		doRedirect( "teacher_landingpage.xhtml" );
	}
	
	/**
	 * Method that redirects to a given url
	 * @param url
	 * @throws IOException if url does not exist
	 */
	private void doRedirect( String url ) throws IOException {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().redirect( url );
	}
}
