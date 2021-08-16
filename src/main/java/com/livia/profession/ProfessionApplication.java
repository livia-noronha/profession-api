package com.livia.profession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;


@SpringBootApplication
@EnableSpringDataWebSupport
public class ProfessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfessionApplication.class, args);
    }

}
