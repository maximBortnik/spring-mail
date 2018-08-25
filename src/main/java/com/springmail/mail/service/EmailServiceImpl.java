package com.springmail.mail.service;

import com.springmail.mail.model.Mail;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Slf4j
public class EmailServiceImpl implements EmailService {

    private JavaMailSender mailSender;

    @Autowired
    private Configuration freemarkerConfig;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendSimpleMessage(Mail mail) {
        log.info("Sending simple message to {}", mail.getMailTo());
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            prepareMail(mail, helper);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("Cannot send email", e);
            throw new RuntimeException("Cannot send email!");
        }
    }

    @Override
    public void sendMessageWithAttachment(Mail mail) {
        log.info("Sending message with attachment to {}", mail.getMailTo());
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            prepareMail(mail, helper);
            helper.addAttachment("photo", new ClassPathResource("java.jpeg"));

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("Cannot send email", e);
            throw new RuntimeException("Cannot send email!");
        }
    }

    @Override
    public void sendMessageWithFreemarkerTemplates(Mail mail) {
        log.info("Sending message with freemarker template to {}", mail.getMailTo());
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            helper.addAttachment("logo.png", new ClassPathResource("java.jpeg"));

            Template t = freemarkerConfig.getTemplate("welcome.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, mail.getModel());

            helper.setTo(mail.getMailTo());
            helper.setText(html, true);
            helper.setSubject(mail.getMailSubject());
            helper.setFrom(mail.getMailFrom());

            mailSender.send(message);
        } catch (Exception e) {
            log.error("Cannot send email", e);
        }
    }

    private void prepareMail(Mail mail, MimeMessageHelper helper) throws MessagingException {
        helper.setTo(mail.getMailTo());
        if (mail.getMailCc() != null) {
            helper.setCc(mail.getMailCc());
        }
        if (mail.getMailBcc() != null) {
            helper.setBcc(mail.getMailBcc());
        }
        helper.setFrom(mail.getMailFrom());
        helper.setSubject(mail.getMailSubject());
        helper.setSentDate(new Date());
        helper.setText(mail.getMailContent());
    }
}
