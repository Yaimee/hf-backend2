package com.example.hfbackend2.login.repository;

import com.example.hfbackend2.login.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
//
public interface LoginRepository extends JpaRepository<Login, Long> {
}
