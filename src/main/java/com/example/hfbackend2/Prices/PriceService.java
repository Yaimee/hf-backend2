package com.example.hfbackend2.Prices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class PriceService {
    private final PriceRepository priceRepository;

    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public List<Price> getPrices() {
        return priceRepository.findAll();
    }

    public void addNewPrice(Price price) {priceRepository.save(price);}

    public Optional<Price> getPriceById(Long priceId) {
        boolean exists = priceRepository.existsById(priceId);
        if (!exists) {
            throw new IllegalStateException(
                    "price with id " + priceId + " does not exist");
        }
        return priceRepository.findById(priceId);
    }

    public Price updateCustomer(Long priceId, Price price) {
        boolean exists = priceRepository.existsById(priceId);
        if (!exists) {
            throw new IllegalStateException(
                    "price with id " + priceId + " does not exist");
        }
        return priceRepository.save(price);
    }
}
