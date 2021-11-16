package com.example.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;






@Service
public class NotificacionService {

	@Autowired
	private JavaMailSender mailSender;
	
	
	
	
	
	@Value("${spring.mail.username}")
    private String mailFrom;

    @Value("${spring.mail.password}")
    private String mailPassword;
	
    

	
	
	@Async
	public void enviar(String cuerpo, String titulo, String email) {
		
		SimpleMailMessage mensaje = new SimpleMailMessage();
		mensaje.setTo(email);
		mensaje.setFrom("pfinaleggedu@gmail.com");
	    mensaje.setSubject(titulo);
		mensaje.setText(cuerpo);
		
		mailSender.send(mensaje);
		
	}
	
	
	
}
