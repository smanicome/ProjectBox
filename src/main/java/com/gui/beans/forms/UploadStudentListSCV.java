package com.gui.beans.forms;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.*;
import javax.servlet.http.Part;

import org.primefaces.shaded.commons.io.FilenameUtils;

import com.gui.beans.view.StudentList;
import com.gui.database.DatabaseFactory;
import com.gui.database.UserDaoInterface;
import com.gui.entities.User;
import com.gui.services.CSV;
import com.gui.services.MailService;
import com.gui.services.PasswordGenerator;

import java.io.IOException;
import java.util.ArrayList;

@Named
@RequestScoped
public class UploadStudentListSCV {
	
	@Inject
    private DatabaseFactory db;
	
	@Inject
	private MailService mail;
	
	@Inject
	private StudentList studentList;

	public UploadStudentListSCV() {
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
		if ( csvFile != null ) {
			if ( csvFile.getSize() > 0 ) {
				String extension = FilenameUtils.getExtension(csvFile.getSubmittedFileName());
				if ( extension.equals("csv") ) {
					try {
						CSV csv = new CSV( csvFile.getInputStream(), "," );
						ArrayList<User> users = csv.getUserList();
						UserDaoInterface dao = db.getUserDAO();
						for( User us : users ) {
					        String pwd = PasswordGenerator.generate( 15 );
					        us.setPassword( pwd );
							dao.create( us );
							try {
								studentList.addStudent(us);
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
				else {
					//set error
				}
			}
			else {
				//set error
			}
		}
	}
}
