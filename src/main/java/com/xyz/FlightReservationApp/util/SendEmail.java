package com.xyz.FlightReservationApp.util;

import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class SendEmail {
	private static final Logger LOGGER=LoggerFactory.getLogger(SendEmail.class);
	@Autowired
	private JavaMailSender emailSender;
	
	public void sendTicketEmail(String to,String subject, String text, String pathToAttachment) {
		LOGGER.info("inside SendTicketEmail()");
		MimeMessage message = emailSender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper=new MimeMessageHelper(message,true);
			messageHelper.setFrom("noreply@baeldung.com");
			messageHelper.setTo(to);
			messageHelper.setSubject(subject);
			messageHelper.setText(text);
			FileSystemResource file=new FileSystemResource(new File(pathToAttachment));
			
			messageHelper.addAttachment("tikt",file);
			emailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
//	public void sendTicketEmail(String toAddress, String filePath) {
//		LOGGER.info("inside SendTicketEmail()");
//		MimeMessage message = emailSender.createMimeMessage();
//    	
//		try {
//			MimeMessageHelper messageHelper=new MimeMessageHelper(message);
//			messageHelper.setTo(toAddress);
//			messageHelper.setSubject("Itinerary of Flight");
//			messageHelper.setText("Please Find the attachment");
//			
//			messageHelper.addAttachment("Itinerary", new File(filePath));
//			emailSender.send(message);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//	}
}
