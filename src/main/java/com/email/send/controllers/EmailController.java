package com.email.send.controllers;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.email.send.services.EmailService;

@CrossOrigin(origins = "*") // Allow all origins for testing
@RestController
@RequestMapping("/api/v1/email")
public class EmailController {

	@Autowired
	private EmailService emailService;
	//http://localhost:8080/api/v1/email/send
	@PostMapping("/send")
	public ResponseEntity<CustomResponse> sendEmail(@RequestBody EmailRequest emailRequest) {

		emailService.sendEmailWithHtml(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getMessage());

		CustomResponse customResponse = CustomResponse.builder().message("Email Send SuccessFully!!")
				.status(HttpStatus.OK).success(true).build();

		return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.OK);

	}
	
//http://localhost:8080/api/v1/email/send-with-file
	@PostMapping("/send-with-file")
	public ResponseEntity<CustomResponse> sendWithFile(@RequestPart("emailRequest") EmailRequest emailRequest,
            @RequestPart("file") MultipartFile file) {

		try {
			emailService.sendEmailWithFile(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getMessage(),
					file.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		CustomResponse customResponse = CustomResponse.builder().message("Email Send with Attachment SuccessFully!!")
				.status(HttpStatus.OK).success(true).build();

		return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.OK);

	}

}
