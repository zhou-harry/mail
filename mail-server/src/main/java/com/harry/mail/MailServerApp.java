package com.harry.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MailServerApp {

    public static void main(String[] args) {
        SpringApplication.run(MailServerApp.class, args);
    }

}
