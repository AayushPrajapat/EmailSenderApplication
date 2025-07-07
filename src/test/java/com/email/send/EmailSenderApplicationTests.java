package com.email.send;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.email.send.services.EmailService;

@SpringBootTest
class EmailSenderApplicationTests {
	
	@Autowired
	private EmailService emailService;

	/*
	@Test
	void contextLoads() {
		emailService.sendEmailWithHtml("officialaayush8901@gmail.com","sending Email With Html Content","<!DOCTYPE html>\n"
				+ "<html lang=\"en\">\n"
				+ "<head>\n"
				+ "  <meta charset=\"UTF-8\">\n"
				+ "  <title>Email Sender</title>\n"
				+ "  <style>\n"
				+ "    body {\n"
				+ "      font-family: Arial, sans-serif;\n"
				+ "      background: #f2f2f2;\n"
				+ "      padding: 40px;\n"
				+ "    }\n"
				+ "    .container {\n"
				+ "      max-width: 500px;\n"
				+ "      background: white;\n"
				+ "      padding: 20px;\n"	
				+ "      border-radius: 10px;\n"
				+ "      margin: auto;\n"
				+ "      box-shadow: 0 0 15px rgba(0,0,0,0.1);\n"
				+ "    }\n"
				+ "    input, textarea {\n"
				+ "      width: 100%;\n"
				+ "      margin-bottom: 15px;\n"
				+ "      padding: 10px;\n"
				+ "      border: 1px solid #ccc;\n"
				+ "      border-radius: 5px;\n"
				+ "    }\n"
				+ "    button {\n"
				+ "      background: #28a745;\n"
				+ "      color: white;\n"
				+ "      padding: 10px 20px;\n"
				+ "      border: none;\n"
				+ "      border-radius: 5px;\n"
				+ "      cursor: pointer;\n"
				+ "    }\n"
				+ "    button:hover {\n"
				+ "      background: #218838;\n"
				+ "    }\n"
				+ "    .message {\n"
				+ "      margin-top: 10px;\n"
				+ "      font-weight: bold;\n"
				+ "    }\n"
				+ "  </style>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "\n"
				+ "  <div class=\"container\">\n"
				+ "    <h2>Send Email</h2>\n"
				+ "    <form id=\"emailForm\">\n"
				+ "      <input type=\"text\" id=\"to\" placeholder=\"Recipient Email\" required />\n"
				+ "      <input type=\"text\" id=\"subject\" placeholder=\"Subject\" required />\n"
				+ "      <textarea id=\"body\" rows=\"6\" placeholder=\"Message\" required></textarea>\n"
				+ "      <button type=\"submit\">Send</button>\n"
				+ "      <div class=\"message\" id=\"message\"></div>\n"
				+ "    </form>\n"
				+ "  </div>\n"
				+ "\n"
				+ "  <script>\n"
				+ "    document.getElementById(\"emailForm\").addEventListener(\"submit\", function (e) {\n"
				+ "      e.preventDefault();\n"
				+ "\n"
				+ "      const to = document.getElementById(\"to\").value;\n"
				+ "      const subject = document.getElementById(\"subject\").value;\n"
				+ "      const body = document.getElementById(\"body\").value;\n"
				+ "\n"
				+ "      fetch(\"http://localhost:8080/send-email\", {\n"
				+ "        method: \"POST\",\n"
				+ "        headers: {\n"
				+ "          \"Content-Type\": \"application/json\"\n"
				+ "        },\n"
				+ "        body: JSON.stringify({ to, subject, body })\n"
				+ "      })\n"
				+ "      .then(response => response.text())\n"
				+ "      .then(result => {\n"
				+ "        document.getElementById(\"message\").textContent = \"Email sent successfully!\";\n"
				+ "        document.getElementById(\"message\").style.color = \"green\";\n"
				+ "      })\n"
				+ "      .catch(error => {\n"
				+ "        document.getElementById(\"message\").textContent = \"Failed to send email!\";\n"
				+ "        document.getElementById(\"message\").style.color = \"red\";\n"
				+ "        console.error(\"Error:\", error);\n"
				+ "      });\n"
				+ "    });\n"
				+ "  </script>\n"
				+ "\n"
				+ "</body>\n"
				+ "</html>");
	//	emailService.sendEmail("officialaayush8901@gmail.com","sending Email","learing Spring boot with Email Sender application");
		System.out.println("Sending Email..!!");
			
	}
	
	@Test
	void sendEmailWithFileTesting() {
		
		emailService.sendEmailWithFile("officialaayush8901@gmail.com",
				"Sending Email with File Name",
				"This Email Contains File",
				new File("C:\\Users\\aayus\\OneDrive\\Desktop\\Images\\link.jpeg")
				);
		
		
	}
	*/
	
	
	@Test
	void sendEmailWithFileTesting() {

		try {
			File file = new File("C:\\Users\\aayus\\OneDrive\\Desktop\\Images\\link.jpeg");
			InputStream is = new FileInputStream(file);

			emailService.sendEmailWithFile("officialaayush8901@gmail.com", "Sending Email with File Name",
					"This Email Contains File", is);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
