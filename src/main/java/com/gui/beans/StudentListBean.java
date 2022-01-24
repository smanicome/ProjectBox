package com.gui.beans;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.Part;

import org.apache.commons.lang3.RandomStringUtils;

import com.gui.database.DatabaseFactory;
import com.gui.database.UserDaoInterface;
import com.gui.entities.User;
import com.gui.services.CSV;
import com.gui.services.MailService;
import com.gui.services.PasswordGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Named
@RequestScoped
public class StudentListBean {
	
	@Inject
    private DatabaseFactory db;
	
	@Inject
	private MailService mail;
	
    private ArrayList<User> students = new ArrayList<>();

	public StudentListBean() {
    }

    public ArrayList<User> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<User> students) {
        this.students = students;
    }
    
    /***************************************************************************
    |  Upload Student File
    ***************************************************************************/
    
    private Part csvFile;
    
    public Part getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(Part csvFile) {
		this.csvFile = csvFile;
	}
	
	public void uploadCSV() {
		System.out.println("start save");

		if ( csvFile != null ) {
			//check size
			//check extension
			
			/*try {
				Mail.test();
			} catch (MessagingException e) {
				System.out.println("cocu");
			}*/
			
			//mail.send();
			
			System.out.println("content type :: " + csvFile.getContentType());
			System.out.println("filename :: " + csvFile.getName() );
			System.out.println("submitted file :: " + csvFile.getSubmittedFileName() );
			System.out.println("size:: " + csvFile.getSize());
			
			try {
				CSV csv = new CSV( csvFile.getInputStream(), "," );
				ArrayList<User> users = csv.getUserList();
				UserDaoInterface dao = db.getUserDAO();
				for( User us : users ) {
			        String pwd = PasswordGenerator.generate( 15 );
			        us.setPassword( pwd );
			        System.out.println(pwd);
			        System.out.println("create row db");
					dao.create( us );
					System.out.println( "send email" );
					try {
						mail.send("Account successfully created", us.getEmail(), "your pwd :: " + pwd);
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				// TODO print message
			}

		}
	}
}
