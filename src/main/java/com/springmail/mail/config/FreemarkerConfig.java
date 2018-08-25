package com.springmail.mail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;

@Configuration
public class FreemarkerConfig {

    @Bean
    public FreeMarkerConfigurationFactory mailTemplateConfigurationFactory() {
        final FreeMarkerConfigurationFactory freeMarkerConfigurationFactory = new FreeMarkerConfigurationFactory();
        freeMarkerConfigurationFactory.setTemplateLoaderPath("/templates/");
        freeMarkerConfigurationFactory.setPreferFileSystemAccess(false);
        freeMarkerConfigurationFactory.setDefaultEncoding("UTF-8");
        return freeMarkerConfigurationFactory;
    }
}
