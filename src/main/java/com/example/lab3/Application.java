package com.example.lab3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

//Ajfoster

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repo, AddressBookRepository aRepo) {
        return (args) -> {
            // save a few customers
            ArrayList<BuddyInfo> list = new ArrayList<BuddyInfo>();
            BuddyInfo b = new BuddyInfo("Andrew", 18);
            repo.save(b);
            list.add(b);

            AddressBook book = new AddressBook();
            book.setBuddy(list);
            aRepo.save(book);


            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo x : repo.findAll()) {
                log.info("Buddy: " + x.getId() + " | " + x.getName() + " | " + x.getAge() + "");
            }
            log.info("");

            for (AddressBook x : aRepo.findAll()) {
                log.info("AddressBook: " + x.getId());
            }
            log.info("");

        };
    }

}