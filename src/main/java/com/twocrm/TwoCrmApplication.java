package com.twocrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@MapperScan("com.twocrm.model")
public class TwoCrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwoCrmApplication.class, args);
    }

}
