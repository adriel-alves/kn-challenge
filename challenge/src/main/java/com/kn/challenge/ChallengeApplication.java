package com.kn.challenge;

import com.kn.challenge.configuration.input.ContactListDatabaseSeeder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChallengeApplication {
    @Value("${populate.database}")
    private Boolean initDabase;

    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(ContactListDatabaseSeeder contactListComponent) {
        return args -> {
            if(initDabase){
                contactListComponent.initContactListDatabase();
            }
        };
    }

}
