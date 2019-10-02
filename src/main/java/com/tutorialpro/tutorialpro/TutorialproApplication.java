package com.tutorialpro.tutorialpro;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class
})

public class TutorialproApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(TutorialproApplication.class, args);
    }



    @Override
    public void run(String... args) throws Exception {
    }


}
