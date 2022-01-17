package com.gui.beans;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Part;

import com.gui.database.DatabaseFactory;
import com.gui.entities.User;
import com.gui.services.GmailEmailWorking;
import com.gui.services.Mail;
import java.util.ArrayList;
import java.util.Date;

@Named
@RequestScoped
public class StudentListBean {
	
	@Inject
    private DatabaseFactory db;
	
	@Inject
	private GmailEmailWorking mail;
	
    private ArrayList<User> students = new ArrayList<>();

	public StudentListBean() {
        students.add(new User("0", "a", "a", "a@a.com"));
        students.add(new User("1", "b", "b", "b@b.com"));
        students.add(new User("2", "c", "c", "c@c.com"));
        students.add(new User("3", "d", "d", "d@d.com"));
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
			
			mail.send();
			
			System.out.println("content type :: " + csvFile.getContentType());
			System.out.println("filename :: " + csvFile.getName() );
			System.out.println("submitted file :: " + csvFile.getSubmittedFileName() );
			System.out.println("size:: " + csvFile.getSize());
			
			/*try {
				CSV csv = new CSV( csvFile.getInputStream(), "," );
				ArrayList<User> users = csv.getUserList();
				for( User us : users ) {
					UserORM orm = db.getUserORM();
					orm.create( us );
					System.out.println( "send email" );
					Mail.sendMail( us.getEmail(), "You account has been created", "Welcome " + us.getFirstname() + " " + us.getLastname() + ",\nYou account has been successfully created.\nYour password is: "+ "test" );
				}
			} catch (IOException e) {
				// TODO print message
			} catch (MailException e) {
				System.out.println( e.getMessage() );
				// TODO print message
			}*/
		}
	}
}
