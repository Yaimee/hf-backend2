package com.example.hfbackend2;

import com.example.hfbackend2.Prices.PriceRepository;
import com.example.hfbackend2.contact.repository.ContactRepository;
import com.example.hfbackend2.login.repository.LoginRepository;
import com.example.hfbackend2.news.repository.NewsRepository;
import com.example.hfbackend2.obs.repository.OBSRepository;
import com.example.hfbackend2.opening_hours.repository.OpeningHoursRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

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
        };
    }

}
