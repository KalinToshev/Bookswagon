package com.softuni.bookswagon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BookswagonApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookswagonApplication.class, args);
    }

}
