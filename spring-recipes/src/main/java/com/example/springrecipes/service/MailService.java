package com.example.springrecipes.service;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    void sendMail(String toEmail,String token){
        String baseUrl="http://localhost:8080/verify/"+token;
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setFrom("noreply@gmail.com");
        simpleMailMessage.setSubject("Account Verification");
        simpleMailMessage.setText("Please go to the url to verify your account :\n" +
                baseUrl);

        javaMailSender.send(simpleMailMessage);
    }
}
