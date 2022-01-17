package com.gui.services;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.mail.Session;

import org.apache.commons.mail.*;

@ApplicationScoped
public class GmailEmailWorking {
	
	@Resource(lookup = "mail/MySession")
    private Session mailSession;

    public void send() {
        String senderId = "yisa00@hotmail.fr";
        
        System.out.println( "coucou :: " + mailSession.getProperties() );
        try {
            MultiPartEmail email = new MultiPartEmail();
            email.setSmtpPort(587);
            email.setAuthentication(mailSession.getProperty("mail.from"), mailSession.getProperty("mail.smtp.password"));
            email.setDebug(true);
            email.setHostName("smtp.gmail.com");
            email.setFrom(mailSession.getProperty("mail.from"));
            email.setSubject("Hi");
            email.setMsg("This is a test mail ... :-)\n\nPlease check attachements that I have sent.\n\nThanks,\nFahim");
            email.addTo(senderId);
            
            email.setSSL(true);

            email.send();
            System.out.println("Mail sent!");
        } catch (Exception e) {
            System.out.println("Exception :: " + e);
        }
    }
}