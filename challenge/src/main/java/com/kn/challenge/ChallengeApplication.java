package com.kn.challenge;

import com.kn.challenge.configuration.input.ContactListDatabaseSeeder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(ContactListDatabaseSeeder contactListComponent) {
        return args -> {
           contactListComponent.initContactListDatabase();
        };
    }

}
