package com.template.eureka;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DatabaseApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
