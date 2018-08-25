package com.springmail.mail.config;

import com.springmail.mail.service.EmailService;
import com.springmail.mail.service.EmailServiceImpl;
import com.springmail.mail.service.UserService;
import com.springmail.mail.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class ServiceConfig {

    @Bean
    public EmailService emailService(JavaMailSender mailSender) {
        return new EmailServiceImpl(mailSender);
    }

    @Bean
    public UserService userService(EmailService emailService) {
        return new UserServiceImpl(emailService);
    }
}
