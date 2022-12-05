package com.example.hfbackend2.contact.repository;

import com.example.hfbackend2.contact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
