package com.gui.database;

import java.util.List;
import java.util.Optional;

import com.gui.entities.User;

public interface UserDaoInterface {
	Optional<User> getUser( String email, String password );
	List<User> getUsers();
	void create( User user );
}
