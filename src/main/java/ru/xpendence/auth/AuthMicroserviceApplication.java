package ru.xpendence.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@PropertySources(
        value = {
                @PropertySource(value = "classpath:auth.properties")
        }
)
public class AuthMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthMicroserviceApplication.class, args);
    }
}
