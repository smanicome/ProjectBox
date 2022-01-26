package com.gui.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

import com.gui.entities.Type;
import com.gui.entities.User;

/**
 * <h1>CSV handling</h1>
 * <p>A class that handles the reading of CSV files</p>
 */

public class CSV{

	private BufferedReader buffReader;
	private String separator;

	/**
	 * Constructor that creates a BufferedReader Object from a InputStream Object and takes a separator sep
	 * @param in, type Input Stream
	 * @param sep, type String
	 */

	public CSV(InputStream in, String sep){
		this.buffReader = new BufferedReader(new InputStreamReader(in));
		this.separator = sep;
	}


	/**
	 * Read a line of the bufferedReader
	 * @return Optional of line if everything went well
	 * @throws IOException otherwise
	 */

	private Optional<String> getline() throws IOException {
		String line = buffReader.readLine();
		if (line == null) return Optional.empty();
		return Optional.of( line );
	}

	/**
	 * Splits Strings into parts according to a separator
	 * @param line
	 * @param sep
	 * @return List with all the parts of the line separated according to sep
	 */

	// split: split line into fields
	private ArrayList<String> split(String line, String sep){
		ArrayList<String> list = new ArrayList<>();
		StringTokenizer tokens = new StringTokenizer(line, sep, false);
		while (tokens.hasMoreElements()) {
			String next = (String) tokens.nextElement();
            next = next.trim().replaceAll("\"\"", "\"");
            list.add(next);
		}
		return list;
  	}

	/**
	 * Creates a list of User from a list of Strings
	 * @return list of users if everything went well,
	 * @throws IOException otherwise
	 */

	public ArrayList<User> getUserList() throws IOException {
		boolean firstLine = true;
		ArrayList<User> users = new ArrayList<>();
		ArrayList<String> fields = new ArrayList<>();
		Optional<String> line = getline();
		while ( line.isPresent() ) {
			fields = split(line.get(), separator);
			if ( firstLine ) {
				List<String> columns = User.getColumns();
				if ( !fields.equals(columns) ) break;	// TODO :: throw new exception
				firstLine = false;
			}
			else {
				User user = new User( fields.get(0), fields.get(1), fields.get(2), fields.get(3), new Type( Type.typeEnum.STUDENT ) );
				users.add( user );
			}
			
			
			line = getline();
		}
		
		return users;
	}
}