package com.example.hfbackend2.contact.controller;

import com.example.hfbackend2.contact.model.Contact;
import com.example.hfbackend2.contact.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/v1/contact")
public class ContactController {

    private final ContactService service;

    @GetMapping
    public ResponseEntity<List<Contact>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Contact> add(@Valid @RequestBody Contact object) {
        return ResponseEntity.ok().body(service.add(object));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Contact> delete(@PathVariable("id") Long id) {
        Contact result = service.findById(id);
        service.delete(id);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> put (@PathVariable("id") Long id, @Valid @RequestBody Contact request){
        return ResponseEntity.ok().body(service.update(id, request, false));
    }

    @PutMapping("/update-phone")
    public ResponseEntity<Contact> updatePhone (@Valid @RequestBody Contact request){
        Contact contactToUpdate = service.findById(1L);
        contactToUpdate.setPhoneNumber(request.getPhoneNumber());
        return ResponseEntity.ok().body(service.update(1L, contactToUpdate, false));
    }

    @PutMapping("/update-email")
    public ResponseEntity<Contact> updateEmail(@Valid @RequestBody Contact request){
        Contact contactToUpdate = service.findById(1L);
        contactToUpdate.setEmail(request.getEmail());
        return ResponseEntity.ok().body(service.update(1L, contactToUpdate, false));
    }

    @PutMapping("/update-address")
    public ResponseEntity<Contact> updateAddress(@Valid @RequestBody Contact request){
        Contact contactToUpdate = service.findById(1L);
        contactToUpdate.setAddress(request.getAddress());
        return ResponseEntity.ok().body(service.update(1L, contactToUpdate, false));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Contact> patch(@PathVariable("id") Long id, @Valid @RequestBody Contact object){
        return ResponseEntity.ok().body(service.update(id, object, true));
    }


}
