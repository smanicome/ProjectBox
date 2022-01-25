package com.gui.database;

import java.util.List;

import com.gui.entities.Project;

public interface ProjectDaoInterface {
	void create( Project project );
	List<Project> getProjectsByCourse( int courseId );
}
