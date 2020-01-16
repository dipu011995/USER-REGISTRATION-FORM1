package com.registration.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * This Class implements JavaMailSender. This Class is to perform mail Operaion
 * 
 * @author Pankaj Kumar
 *
 */
@Component
public class UtilMails {

	@Autowired
	private JavaMailSender jms;

	/**
	 * This Method is to send mail to user email with hyperlink .
	 * 
	 * @param to
	 * @param subject
	 * @param body
	 * @throws MessagingException
	 */
	public void sendMail(String to, String subject, String body) throws MessagingException {

		MimeMessage message = jms.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body, true);

		jms.send(message);

	}

}
