package com.example.hfbackend2.Prices.controller;

import com.example.hfbackend2.Prices.service.PriceService;
import com.example.hfbackend2.Prices.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
// CrossOrigin is important to be able to download from the database, otherwise you can't do it due to the cors policy
@CrossOrigin
@RequestMapping("api/v1/price")
public class PriceController {

    private PriceService priceService;

    @Autowired
    public void PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/")
    public List<Price> getPrices() {return priceService.getPrices();}

    @GetMapping(path = "/{priceId}")
    // pathvariable is used to define a variable in its endpoint
    public Optional<Price> getPriceById(@PathVariable("priceId") Long priceId) {
        return priceService.getPriceById(priceId);
    }

    @PostMapping("/addPrice")
    public void registerNewPrice(@RequestBody Price price) { priceService.addNewPrice(price);
    }

    @PutMapping(path = "/{priceId}")
    public Optional<Price> updatePriceById(@PathVariable("priceId") Long priceId,
                                           @RequestBody Price price) {
        return Optional.ofNullable(priceService.updateCustomer(priceId, price));
    }

}
