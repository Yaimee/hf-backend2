package com.example.hfbackend2.Prices.config;

import com.example.hfbackend2.Prices.model.Price;
import com.example.hfbackend2.Prices.repository.PriceRepository;
import com.example.hfbackend2.opening_hours.model.OpeningHours;
import com.example.hfbackend2.opening_hours.repository.OpeningHoursRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PricesConfig {
    @Bean
    CommandLineRunner commandLineRunnerPrices(PriceRepository repository) {
        return args -> {
            Price price1 = new Price("klip-1",700);
            Price price2 = new Price("klip-2",800);
            Price price3 = new Price("klip-3",950);
            Price price4 = new Price("klip-4",200);
            Price price5 = new Price("trimming-1",850);
            Price price6 = new Price("Touch-up-1",550);
            Price price7 = new Price("Touch-up-2",650);
            Price price8 = new Price("Tillæg-1",250);

            repository.saveAll(
                    List.of(price1,price2,price3,price4,price5,price6,price7,price8)
            );
        };
    }
}
