package com.neonlab.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Properties;

@Configuration
public class EmailConfig {

        @Value("${spring.mail.host}")
        private String mailHost;

        @Value("${spring.mail.port}")
        private int mailPort;


        @Value("${spring.mail.username}")
        private String mailUsername;


        @Value("${spring.mail.password}")
        private String mailPassword;

       /* @Bean
        public JavaMailSender javaMailSender() {
            JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
            javaMailSender.setHost(mailHost);
            javaMailSender.setPort(mailPort);
            javaMailSender.setUsername(mailUsername);
            javaMailSender.setPassword(mailPassword);

            Properties properties = javaMailSender.getJavaMailProperties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            return javaMailSender;
        }*/

}
