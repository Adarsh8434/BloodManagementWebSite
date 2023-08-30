package com.example.blooddonor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailNotificationService {
    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailNotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(String recipientEmail, String subject, String message) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        try {
            helper.setTo(recipientEmail);
            helper.setSubject(subject);
            helper.setText(message, true); // true indicates the message contains HTML

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            // Handle any exceptions that might occur during email sending
            e.printStackTrace();
        }
    }
}
