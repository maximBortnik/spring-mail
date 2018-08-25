package com.springmail.mail.service;

import com.springmail.mail.model.Mail;

public interface EmailService {

    void sendSimpleMessage(Mail mail);

    void sendMessageWithAttachment(Mail mail);

    void sendMessageWithFreemarkerTemplates(Mail mail);
}
