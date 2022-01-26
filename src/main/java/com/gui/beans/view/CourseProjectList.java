package com.gui.beans.view;

import com.gui.beans.session.SelectedCourse;
import com.gui.database.DatabaseFactory;
import com.gui.entities.Project;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

/**
 * <h1>Project list from one course view</h1>
 * <p>Create the list of project related to a certain course</p>
 */

@Named
@ViewScoped
public class CourseProjectList implements Serializable {
	
	private static final long serialVersionUID = -9044487822404564248L;
	
	@Inject
	private DatabaseFactory db;

    @Inject
    private SelectedCourse selectedCourse;

    private Collection<Project> projects;
    private Project selectedProject;

    /**
     * Load the projects from the chosen course from database into parameter projects
     */

    @PostConstruct
    public void load() {
    	int courseId = selectedCourse.getCourse().getId();
    	projects = db.getProjectDAO().getProjectsByCourse( courseId );
    }

    /**
     * get project collection
     * @return Collection of projects
     */

    public Collection<Project> getProjects() {
        return projects;
    }

    /** set project collection
     *
     * @param projects, collection of projects
     */

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }

    /**
     * Get current project
     * @return selectedProject, selectedProject type
     */

	public Project getSelectedProject() {
		return selectedProject;
	}

    /**
     * Set selected project
     * @param selectedProject, selectedProject type
     */

	public void setSelectedProject(Project selectedProject) {
		this.selectedProject = selectedProject;
	}
	
	/***************************************************************************
	 |  Listener & Action
	***************************************************************************/

    /** Method of redirection
     * @return "project_info" to change page for project description page
     */

    public String moveToProjectInfo() {
       return "project_info";
   }
}
