package com.gui.database;

import java.util.List;

import com.gui.entities.Project;

/**
* Interface used for the interactions with Project database and used outside packaging com.gui.database
*/
public interface ProjectDaoInterface {
	/**
	 * Create project
	 * @param project, Project type
	 */
	void create( Project project );

	/**
	 * Get project given a certain Course
	 * @param courseId, int type
	 * @return List<Project> type
	 */
	List<Project> getProjectsByCourse( int courseId );
}
