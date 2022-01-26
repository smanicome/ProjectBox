package com.gui.beans.view;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.annotation.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gui.entities.Project;

/**
 * Project description view
 */

@Named
@ViewScoped
public class ProjectDescription implements Serializable{

	private static final long serialVersionUID = 5319027510997773108L;

	 @Inject
	 @ManagedProperty(value="#{param.project}")
	 private int projectCode;
	 private Project project;

	/**
	 * Load code project and displays it on the console
	 */
	@PostConstruct
	 public void load() {
		 System.out.println( "project code post const ::: " + projectCode );
	 }

	/**
	 * Get the project
	 * @return project, Project type
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * Set the project
	 * @param project, Project type
	 */
	public void setProject(Project project) {
		this.project = project;
	}
}
