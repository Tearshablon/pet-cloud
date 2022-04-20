package com.template.eureka;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EurekaServerApplication {
    public static void main(String[] args) {
            SpringApplication app = new SpringApplication(EurekaServerApplication.class);
            app.setBannerMode(Banner.Mode.OFF);
            app.run(args);
    }
}