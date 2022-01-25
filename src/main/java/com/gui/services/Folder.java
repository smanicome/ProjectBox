package com.gui.services;

import java.io.File;
import java.util.Objects;

public class Folder {
	/*	
	 * /home/loky/Downloads/glassfish5/glassfish/domains/domain1/config/ + path
	 * */
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
