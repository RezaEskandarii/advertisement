package com.tutorialpro.tutorialpro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    /**
     * send email
     * @param to
     * @param subject
     * @param body
     */
    public void send(String to, String subject, String body) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper
                = new MimeMessageHelper(mimeMessage);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    mimeMessageHelper.addTo(to);
                    mimeMessageHelper.setSubject(subject);
                    mimeMessageHelper.setText(body);
                } catch (MessagingException e) {
                    // TODO: store logs in file
                    System.out.println(e.getMessage());
                } finally {
                    // send mail
                    javaMailSender.send(mimeMessage);
                }
            }
        });
    }
}
