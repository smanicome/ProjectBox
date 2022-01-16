package com.gui.beans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;

@Named("uploadFileBean")
@RequestScoped
public class UploadFileBean implements Serializable {
	
	private static final long serialVersionUID = -650321725404976421L;

	private static String folder = "";
	
	private Part uploadedFile;

	public Part getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public void saveFile() {
		System.out.println("start save");
		if ( uploadedFile != null ) {
			//check size
			//check extension
			System.out.println("content type :: " + uploadedFile.getContentType());
			System.out.println("filename :: " + uploadedFile.getName() );
			System.out.println("submitted file :: " + uploadedFile.getSubmittedFileName() );
			System.out.println("size:: " + uploadedFile.getSize());
			try {
				BufferedReader fileReader = new BufferedReader(new InputStreamReader(uploadedFile.getInputStream()));
				
				String line = fileReader.readLine();
				while ( line != null ) {
					ArrayList< String > field = split(line, ",");
					
					System.out.println( line );
					line = fileReader.readLine();
				}
			} catch (IOException e) {
				// failure
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("file uploaded"));
		}
		else System.out.println("null");
	}
	
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

}
