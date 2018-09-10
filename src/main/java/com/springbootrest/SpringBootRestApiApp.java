package com.springbootrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.springbootrest"})
public class SpringBootRestApiApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApiApp.class, args);
    }
}
