package com.example.hfbackend2.login.controller;

import com.example.hfbackend2.login.model.Login;
import com.example.hfbackend2.login.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
//
@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/v1/login")
public class LoginController {
    private final LoginService service;

    @GetMapping("/{id}")
    public Login findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @PutMapping("/update-login")
    public Login put(Long id, @Valid @RequestBody Login object){
        return service.update(id,object, false);
    }
}
