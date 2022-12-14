package com.example.hfbackend2.opening_hours.config;

import com.example.hfbackend2.opening_hours.model.OpeningHours;
import com.example.hfbackend2.opening_hours.repository.OpeningHoursRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/*@Configuration
public class Opening_hoursConfig {
    @Bean
    CommandLineRunner commandLineRunner_Opening_hours(OpeningHoursRepository repository) {
        return args -> {
            OpeningHours openingHours = new OpeningHours("Mandag, tirsdag og fredag", "9:00 - 18:00", "Lørdag og søndag:", "9:00 - 16:00", "Onsdag og torsdag","lukket");

            repository.saveAll(
                    List.of(openingHours)
            );
        };
    }
}*/
