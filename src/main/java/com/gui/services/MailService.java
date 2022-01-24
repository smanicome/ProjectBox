package com.gui.services;

import java.util.Date;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@ApplicationScoped
public class MailService {

	@Resource(lookup = "mail/MailService")
    private Session mailSession;
	
	public void send( String subject, String recipient, String content ) throws MessagingException {
		Message msg = new MimeMessage(mailSession);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		msg.setFrom();
		msg.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(recipient, false));
		msg.setText(content);
		Transport.send(msg);
	}

}
