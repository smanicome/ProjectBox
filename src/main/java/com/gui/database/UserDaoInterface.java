package com.gui.database;

import java.util.Optional;

import com.gui.entities.User;

public interface UserDaoInterface {
	Optional<User> getUser( String email );
	void create( User user );
}
