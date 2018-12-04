package library;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;

public class SendMail {

	@Test
	public void sendMail() throws EmailException {
		
		
		System.out.println("Started");
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("soniya.vijaywargi64@gmail.com", "Juni-012341234"));
		email.setSSLOnConnect(true);
		email.setFrom("soniya.vijaywargi64@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail");
		email.addTo("soniya.vijaywargi64@gmail.com");
		email.send();
		System.out.println("Email Sent");
		}
}
