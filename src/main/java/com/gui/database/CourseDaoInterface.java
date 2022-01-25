package com.gui.database;

import com.gui.entities.Course;

/**
 * Interface used for the interactions with Course database and used outside packaging com.gui.database
 */
public interface CourseDaoInterface {
	/**
	 * create new course
	 * @param course, type Course
	 */
	void create( Course course );

	/**
	 * Get course given its course code
	 * @param courseCode
	 * @return Course
	 */
	Course getCourseByCode(String courseCode);
}
