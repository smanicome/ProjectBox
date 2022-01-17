package com.gui.database;

import java.util.Optional;

import com.gui.entities.Student;

public interface StudentDaoInterface {
	Optional<Student> getStudent( String email, String password );
	void create( Student student );
	void update( Student student );
}
