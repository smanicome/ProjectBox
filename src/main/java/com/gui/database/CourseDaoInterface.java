package com.gui.database;

import com.gui.entities.Course;

public interface CourseDaoInterface {
	void create( Course course );
	Course getCourseByCode(String courseCode);
}
