package com.gui.services;

import org.apache.commons.lang3.RandomStringUtils;

public class PasswordGenerator {
	public static String generate( int numberofCharacters ) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        return RandomStringUtils.random( numberofCharacters, characters );
	}
}
