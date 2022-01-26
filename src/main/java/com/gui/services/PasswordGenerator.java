package com.gui.services;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * <h1>Password generator class</h1>
 * <p>Class that randomly generates passwords, taking characters from a given String names characters</p>
 */
public class PasswordGenerator {

	/**
	 * Password generator method
	 * @param numberofCharacters int that defines the length of the password
	 * @return random combination of characters from string characters
	 */
	public static String generate( int numberofCharacters ) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        return RandomStringUtils.random( numberofCharacters, characters );
	}
}
