package com.harry.mail;

import com.harry.api.feign.MailApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(clients = MailApi.class)
public class MailClientApp {
    public static void main(String[] args) {
        SpringApplication.run(MailClientApp.class, args);
    }
}
