package com.gui.services;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageListener;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
//import javax.jms.Message;
import org.apache.commons.mail.*;

public class Mail{

    //uncomment and change email address if you want to try
    /*public static void main(String[] args) throws MailException {
        MailService.sendMail("yisa00@hotmail.fr", "prog test", "coucou");
    }*/
	
	public Mail() {
		
	}
	
	public void sendEmail(String to, String subject, String body) {
        MimeMessage message = new MimeMessage(session);
        try {
        	System.out.println("from ::: " + session.getProperty("mail.from"));
            message.setFrom(new InternetAddress(session.getProperty("mail.from")));
            InternetAddress[] address = {new InternetAddress(to)};
            message.setRecipients(Message.RecipientType.TO, address);
            message.setSubject(subject);
            message.setSentDate(new Date());
            message.setText(body);

            Transport.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
	
	/*@Override
	public void onMessage(Message message) {
		try {
			if ( message instanceof MapMessage ) {
				MapMessage map = ( MapMessage ) message;
				
				String from = map.getStringProperty("from");
				String to = map.getStringProperty("to");
				String subject = map.getStringProperty("subject");
				String content = map.getStringProperty("content");
				
				javax.mail.Message msg = new MimeMessage( session );
				msg.setFrom( new InternetAddress( from ));
				msg.setRecipient( javax.mail.Message.RecipientType.TO, new InternetAddress(to) );
				msg.setSubject( subject );
				msg.setContent(content, "text/html; charset=utf-8");
				msg.setSentDate(new Date());
				
				Transport.send( msg );
			}
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	
	@Resource( name="mail/MySession" )
	private Session session;
	
public static void test() throws MessagingException {
	String myEmailId = "jprj.gui@gmail.com";
    String myPassword = "response11";
    String senderId = "s.manicome@gmail.com";
    try {
        MultiPartEmail email = new MultiPartEmail();
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator(myEmailId, myPassword));
        email.setDebug(true);
        email.setHostName("smtp.gmail.com");
        email.setFrom(myEmailId);
        email.setSubject("Hi");
        email.setMsg("This is a test mail ... :-)\n\nPlease check attachements that I have sent.\n\nThanks,\nFahim");
        email.addTo(senderId);
        System.out.println( email.getSmtpPort() );

        email.send();
        System.out.println("Mail sent!");
    } catch (Exception e) {
        System.out.println("Exception :: " + e);
    }
}

    private static final String authAdress    = "jprj.gui@gmail.com";
    private static final String authPassword  = "response11";

    /*public static void sendMail( String recipient, String subject, String msg) throws MailException {
        Objects.requireNonNull( recipient );
        Objects.requireNonNull( subject );
        Objects.requireNonNull( msg );
        
        System.out.println("ta maere");

        Properties properties = prepareProperties();

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication( authAdress, authPassword );
            }
        });

        Optional<Message> message = prepareMessage( session, recipient, subject, msg );
        System.out.println( "message ::: " + message.isPresent() );
        if ( message.isPresent() ) {
            try {
                Transport.send( message.get() );
            } catch (MessagingException e) {
            	System.out.println("error messaging :::: " + e.getMessage());
                throw new MailException(e.getMessage());
            }
        }
        else throw new MailException("error during preparation of the message");
    }

    private static Properties prepareProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        return properties;
    }

    /*private static Optional<Message> prepareMessage( Session session, String recipient, String subject, String msg ) {
        try {
            Message message = new MimeMessage( session );
            message.setFrom( new InternetAddress( authAdress ));
            message.setRecipient( Message.RecipientType.TO, new InternetAddress(recipient) );
            message.setSubject( subject );
            message.setText( msg );
            return Optional.of( message );
        } catch (MessagingException e) {
            return Optional.empty();
        }
    }*/

	
}
