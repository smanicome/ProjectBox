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

/**
 * <h1>Mail Service</h1>
 * <p>Service that send email to a given mail address</p>
 */
@ApplicationScoped
public class MailService {

	@Resource(lookup = "mail/MailService")
    private Session mailSession;

	/**
	 * Sends an email with an object containing :
	 * @param subject
	 * @param recipient
	 * @param content
	 * @throws MessagingException
	 */
	
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
