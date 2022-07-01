package ar.edu.unju.fi.turnosonline.turnosonline.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    //remitente
	 
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail (String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("programacionvisual2021grupo02@gmail.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		mailSender.send(message);
	}
}
