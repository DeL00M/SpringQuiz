package ru.del00m.SpringQuiz.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationMailSender {
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String emailFrom;

    public ConfirmationMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send(String emailTo, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(emailFrom);
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
}
