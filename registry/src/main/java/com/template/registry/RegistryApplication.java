package com.template.registry;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegistryApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(RegistryApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
