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
    static PriceRepository priceRepository = new PriceRepository() {
        @Override
        public List<Price> findAll() {
            return null;
        }

        @Override
        public List<Price> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<Price> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends Price> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Price> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Price> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<Price> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Price getOne(Long aLong) {
            return null;
        }

        @Override
        public Price getById(Long aLong) {
            return null;
        }

        @Override
        public Price getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends Price> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Price> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<Price> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Price> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Price> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(Price entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends Price> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Price> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Price> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Price> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Price> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Price, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };

    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public static List<Price> getPrices() {
        return priceRepository.findAll();
    }

    public static void addNewPrice(Price price) {priceRepository.save(price);}

    public Optional<Price> getPriceById(Long priceId) {
        boolean exists = priceRepository.existsById(priceId);
        if (!exists) {
            throw new IllegalStateException(
                    "student with id " + priceId + " does not exist");
        }
        return priceRepository.findById(priceId);
    }

    public Price updateCustomer(Long priceId, Price price) {
        boolean exists = priceRepository.existsById(priceId);
        if (!exists) {
            throw new IllegalStateException(
                    "student with id " + priceId + " does not exist");
        }
        return priceRepository.save(price);
    }
}
