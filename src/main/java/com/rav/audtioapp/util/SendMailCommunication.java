package com.rav.audtioapp.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @author Rav
 */
public class SendMailCommunication implements Runnable {

	private String emailAddress;
	private String mailBody;
	private String subject;

	public SendMailCommunication(String emailAddress, String mailBody, String subject) {
		this.emailAddress = emailAddress;
		this.subject = subject;
		this.mailBody = mailBody;
	}

	public void run() {
		final String username = "ravjot28@gmail.com";
		final String password = "gxkeqghsfmuelrgy";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ravjot28@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAddress));
			message.setSubject(subject);
			message.setText(mailBody);

			Transport.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
}