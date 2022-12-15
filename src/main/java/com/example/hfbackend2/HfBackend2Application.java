package com.example.hfbackend2;

import com.example.hfbackend2.Prices.model.Price;
import com.example.hfbackend2.Prices.repository.PriceRepository;
import com.example.hfbackend2.contact.model.Contact;
import com.example.hfbackend2.contact.repository.ContactRepository;
import com.example.hfbackend2.login.repository.LoginRepository;
import com.example.hfbackend2.news.model.News;
import com.example.hfbackend2.news.repository.NewsRepository;
import com.example.hfbackend2.obs.model.OBS;
import com.example.hfbackend2.obs.repository.OBSRepository;
import com.example.hfbackend2.opening_hours.model.OpeningHours;
import com.example.hfbackend2.opening_hours.repository.OpeningHoursRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
public class HfBackend2Application {

    public static void main(String[] args) {
        SpringApplication.run(HfBackend2Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ContactRepository contactRepository,
                                        NewsRepository newsRepository,
                                        OBSRepository obsRepository,
                                        OpeningHoursRepository openingHoursRepository,
                                        PriceRepository priceRepository,
                                        LoginRepository loginRepository) {
        return (args) -> {
            /*
            Contact : phoneNumber, email, address
            News : title, text, date
            OBS : text, date
            OpeningHours : field1, time1, field2, time2, field3, time3
            Price : price_id, item, price
            Login : username, password
             */

            log.info("Command Line Runner Starting");
            final List<Contact> contacts = new ArrayList<>();
            log.info("Creating Contacts");
            contacts.add(new Contact("11111111", "email1@email.com", "address 1"));
            log.info("Contacts created");
            contactRepository.saveAll(contacts);
            log.info("Contacts saved");

            final List<News> newsList = new ArrayList<>();
            log.info("Creating News");
            newsList.add(new News("News Number 1", "The news today on day 1", "01-01-2022"));
            newsList.add(new News("News Number 2", "The news today on day 2", "02-01-2022"));
            newsList.add(new News("News Number 3", "The news today on day 3", "03-01-2022"));
            newsList.add(new News("News Number 4", "The news today on day 4", "04-01-2022"));
            newsList.add(new News("News Number 5", "The news today on day 5", "05-01-2022"));
            newsList.add(new News("News Number 6", "The news today on day 6", "06-01-2022"));
            log.info("News created");
            newsRepository.saveAll(newsList);
            log.info("News saved");

            final List<OBS> obsList = new ArrayList<>();
            log.info("Creating OBS");
            obsList.add(new OBS("OBS Number 1", "01-01-2022"));
            obsList.add(new OBS("OBS Number 2", "02-01-2022"));
            obsList.add(new OBS("OBS Number 3", "03-01-2022"));
            obsList.add(new OBS("OBS Number 4", "04-01-2022"));
            obsList.add(new OBS("OBS Number 5", "05-01-2022"));
            obsList.add(new OBS("OBS Number 6", "06-01-2022"));
            log.info("OBS created");
            obsRepository.saveAll(obsList);
            log.info("OBS saved");

            final List<OpeningHours> openingHoursList = new ArrayList<>();
            log.info("Creating Opening Hours");
            openingHoursList.add(new OpeningHours("Mandag, tirsdag og fredag", "9:00 - 18:00", "Lørdag og søndag:", "9:00 - 16:00", "Onsdag og torsdag","lukket"));
            log.info("Opening Hours created");
            openingHoursRepository.saveAll(openingHoursList);
            log.info("Opening Hours Saved");

            final List<Price> prices = new ArrayList<>();
            log.info("Creating Prices");
            prices.add(new Price("klip-1",700));
            prices.add(new Price("klip-2",800));
            prices.add(new Price("klip-3",950));
            prices.add(new Price("klip-4",200));
            prices.add(new Price("trimming-1",850));
            prices.add(new Price("Touch-up-1",550));
            prices.add(new Price("Touch-up-2",650));
            prices.add(new Price("Tillæg-1",250));
            log.info("Prices created");
            priceRepository.saveAll(prices);
            log.info("Prices saved");

            // final List<Login> logins = new ArrayList<>();

        };
    }

}
