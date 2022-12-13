package com.example.hfbackend2.opening_hours.controller;

import com.example.hfbackend2.opening_hours.model.OpeningHours;
import com.example.hfbackend2.opening_hours.service.OpeningHoursService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/v1/openinghours")
public class OpeningHoursController {

    private final OpeningHoursService service;

    @GetMapping
    public ResponseEntity<List<OpeningHours>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OpeningHours> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<OpeningHours> add(@Valid @RequestBody OpeningHours object) {
        return ResponseEntity.ok().body(service.add(object));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<OpeningHours> delete(@PathVariable("id") Long id) {
        OpeningHours result = service.findById(id);
        service.delete(id);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OpeningHours> put (@PathVariable("id") Long id, @Valid @RequestBody OpeningHours request){
        return ResponseEntity.ok().body(service.update(id, request, false));
    }


    @PatchMapping("/{id}")
    public ResponseEntity<OpeningHours> patch(@PathVariable("id") Long id, @Valid @RequestBody OpeningHours object){
        return ResponseEntity.ok().body(service.update(id, object, true));
    }
}
