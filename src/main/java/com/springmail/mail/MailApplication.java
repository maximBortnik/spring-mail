package com.springmail.mail;

import com.springmail.mail.config.FreemarkerConfig;
import com.springmail.mail.config.MailConfig;
import com.springmail.mail.config.ServiceConfig;
import com.springmail.mail.model.UserEntity;
import com.springmail.mail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
		FreemarkerConfig.class,
		ServiceConfig.class,
		MailConfig.class
})
public class MailApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(MailApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserEntity userEntity = UserEntity.builder()
				.name("Ivan")
				.surname("Ivanov")
				.mail("bortnikmax@gmail.com")
				.build();
		userService.registration(userEntity);
	}
}
