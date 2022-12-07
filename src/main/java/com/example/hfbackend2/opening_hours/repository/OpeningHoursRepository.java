package com.example.hfbackend2.opening_hours.repository;

import com.example.hfbackend2.opening_hours.model.OpeningHours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpeningHoursRepository extends JpaRepository<OpeningHours, Long> {
}
