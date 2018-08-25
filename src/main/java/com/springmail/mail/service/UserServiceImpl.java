package com.springmail.mail.service;

import com.springmail.mail.model.Mail;
import com.springmail.mail.model.UserEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class UserServiceImpl implements UserService {

    private EmailService emailService;

    public UserServiceImpl(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void registration(UserEntity userEntity) {
        log.info("Registration user with email {}", userEntity.getMail());
        emailService.sendSimpleMessage(
                Mail.builder()
                        .mailTo(userEntity.getMail())
                        .mailFrom("application@gmail.com")
                        .mailSubject("Welcome to application")
                        .mailContent(" Hello " + userEntity.getName() + "! \n Simple message.")
                        .build());

        emailService.sendMessageWithAttachment(
                Mail.builder()
                        .mailTo(userEntity.getMail())
                        .mailFrom("application@gmail.com")
                        .mailSubject("Welcome to application")
                        .mailContent(" Hello " + userEntity.getName() + "! \n Message with attachments.")
                        .build());

        emailService.sendMessageWithFreemarkerTemplates(
                Mail.builder()
                .mailTo(userEntity.getMail())
                .mailFrom("application@gmail.com")
                .mailSubject("Welcome to application")
                .model(prepareModel(userEntity))
                .build());
    }


    private Map<String, Object> prepareModel(UserEntity userEntity) {
        Map<String, Object> model = new HashMap<>();
        model.put(Constant.NAME, userEntity.getName());
        model.put(Constant.SURNAME, userEntity.getSurname());
        model.put(Constant.LOCATION, "Belarus");
        model.put(Constant.SIGNATURE, "www.example.com");
        return model;
    }
}
