package ru.digitallegua.fccr.registry;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FccrRegistryApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(FccrRegistryApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
