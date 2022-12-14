package com.example.hfbackend2.Prices.controller;

import com.example.hfbackend2.Prices.model.Price;
import com.example.hfbackend2.Prices.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
// husk cross origin er vigtig for at kunne hente fra databasen eller kan man ikke gøre det pga cors
@CrossOrigin
@RequestMapping("api/v1/price")
public class PriceController {

    private PriceService priceService;

    @Autowired
    public void PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public ResponseEntity<List<Price>> getPrices() {return ResponseEntity.ok().body(priceService.getPrices());}

    @GetMapping("/{priceId}")
    // pathvariable bruges til at definere en variabel i sit endpoint
    public ResponseEntity<Optional<Price>> getPriceById(@PathVariable("priceId") Long priceId) {
        return ResponseEntity.ok().body(priceService.getPriceById(priceId));
    }

    @PostMapping("/addPrice")
    public void registerNewPrice(@RequestBody Price price) { priceService.addNewPrice(price);
    }

    @DeleteMapping("/{priceId}")
    public ResponseEntity<Optional<Price>> deletePrice(@PathVariable("priceId") Long priceId) {
        Optional<Price> result = priceService.getPriceById(priceId);
        priceService.deleteById(priceId);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping(path = "/{priceId}")
    public Optional<Price> updatePriceById(@PathVariable("priceId") Long priceId,
                                           @RequestBody Price price) {
        return Optional.ofNullable(priceService.updateCustomer(priceId, price));
    }

}
