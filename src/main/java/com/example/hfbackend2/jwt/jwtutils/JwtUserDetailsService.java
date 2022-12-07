package com.example.hfbackend2.jwt.jwtutils;

import com.example.hfbackend2.login.controller.LoginController;
import com.example.hfbackend2.login.service.LoginService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private LoginService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (service.findById(0L).getUsername().equals(username)) {
            return new User(service.findById(0L).getUsername(),
                    service.findById(0L).getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}