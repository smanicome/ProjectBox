package com.gui.adelete;

import java.util.Optional;

public interface StudentDaoInterface {
	Optional<Student> getStudent( String email, String password );
	void create( Student student );
	void update( Student student );
}
