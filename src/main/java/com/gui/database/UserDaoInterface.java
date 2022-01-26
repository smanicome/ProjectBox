package com.gui.database;

import java.util.List;
import java.util.Optional;

import com.gui.entities.User;

public interface UserDaoInterface {
	Optional<User> getUser( String email, String password );
	Optional<User> getUserById( int id );
	List<User> getUsers();
	void create( User user );
	void update( User user );
	void remove( User user );
}
