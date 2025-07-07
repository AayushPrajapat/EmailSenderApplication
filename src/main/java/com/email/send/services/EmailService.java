package com.email.send.services;

import java.io.File;
import java.io.InputStream;

public interface EmailService {
	
//	Send Email to Single Person
	void sendEmail(String to,String subject,String message);
//	Send Email to Multiple Person
	void sendEmail(String[] to,String subject,String message);
//	Send Email With Html
	void sendEmailWithHtml(String to,String subject,String htmlContent);
//	Send Email With file
	void sendEmailWithFile(String to,String subject,String message,File file);
	void sendEmailWithFile(String to,String subject,String message,InputStream inputStream);
	
	

}
