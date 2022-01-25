package com.gui.database;

import java.util.List;
import java.util.Optional;

import com.gui.entities.User;

/**
 * Interface used for the interactions with User database and used outside packaging com.gui.database
 */

public interface UserDaoInterface {
	/**
	 * Get user with email and password
	 * @param email, String
	 * @param password, String
	 * @return Optional<User> type
	 */
	Optional<User> getUser( String email, String password );

	/**
	 * Get user with user id
	 * @param id, String
	 * @return Optional <User></User>
	 */
	Optional<User> getUserById( int id );

	/**
	 * Get list of all users
	 * @return List<User>
	 */
	List<User> getUsers();

	/**
	 * Create user
	 * @param user, User type
	 */
	void create( User user );

	/**
	 * Update User
	 * @param user, User type
	 */

	void update( User user );
}
