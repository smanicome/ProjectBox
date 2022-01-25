package com.gui.services;

import java.io.File;
import java.util.Objects;

/**
 * <h1>Creation of a folder</h1>
 * <p>A class that creates a folder taken a given path</p>
 */
public class Folder {
	/*	
	 * /home/loky/Downloads/glassfish5/glassfish/domains/domain1/config/ + path
	 * */

	/**
	 * Method that actually creates the folder
	 * @param path, path to the new folder
	 * @return true if folder existed or has been created, false if a problem occured
	 */

	public static boolean create( String path ) {
		Objects.requireNonNull( path );
       	File dir = new File( path );
       	
       	boolean created = dir.exists();
       	if ( !created ) {
       		created = dir.mkdir();
       	}
		return created;
	}
}
