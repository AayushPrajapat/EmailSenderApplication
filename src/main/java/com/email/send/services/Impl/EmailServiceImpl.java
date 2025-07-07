package com.email.send.services.Impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.email.send.services.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Override
	public void sendEmail(String to, String subject, String message) {

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);
		simpleMailMessage.setFrom("aayushprajapat49@gmail.com");
		mailSender.send(simpleMailMessage);

		log.info("Email has been sent...");

	}

	@Override
	public void sendEmail(String[] to, String subject, String message) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);
		simpleMailMessage.setFrom("aayushprajapat49@gmail.com");
		mailSender.send(simpleMailMessage);
		log.info("Multiple Emails has been sent..!!");

	}

	@Override
	public void sendEmailWithHtml(String to, String subject, String htmlContent) {

		MimeMessage createMimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(createMimeMessage, true, "UTF-8");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setFrom("aayushprajapat49@gmail.com");
			helper.setText(htmlContent, true);

			mailSender.send(createMimeMessage);

			log.info("Email has been sent...");

		} catch (MessagingException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void sendEmailWithFile(String to, String subject, String message, File file) {
		
		MimeMessage createMimeMessage = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(createMimeMessage,true);
			mimeMessageHelper.setTo(to);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(message);
			mimeMessageHelper.setFrom("aayushprajapat49@gmail.com");
			FileSystemResource fileSystemResource = new FileSystemResource(file);
			mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), file);
			mailSender.send(createMimeMessage);
			log.info("Send Email With File Attachment..!!");
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void sendEmailWithFile(String to, String subject, String message, InputStream inputStream) {
	    try {
	        MimeMessage mimeMessage = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(message, false);
	        helper.setFrom("aayushprajapat49@gmail.com");

	        // Use InputStream as attachment
	        try {
	        	File file = new File("src/main/resources/email/test.png");
				Files.copy(inputStream,file.toPath(),StandardCopyOption.REPLACE_EXISTING);
				FileSystemResource fileSystemResource = new FileSystemResource(file);
				helper.addAttachment(fileSystemResource.getFilename(),file);
				
				
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        mailSender.send(mimeMessage);
	        log.info("Email sent successfully with InputStream attachment.");

	    } catch (MessagingException e) {
	        e.printStackTrace();
	        log.error("Error sending email with InputStream attachment: {}", e.getMessage());
	    }
	}

	
	
	

}
