package com.example.hfbackend2.jwt.jwtutils;

import com.example.hfbackend2.login.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
//ny
@AllArgsConstructor
@Service
public class JwtUserDetailsService implements UserDetailsService {
    private LoginService service;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    //private String username = "admin";//service.findById(1L).getUsername();
    //private String password = bCryptPasswordEncoder.encode(service.findById(1L).getPassword());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            return new User("admin",
                    bCryptPasswordEncoder.encode(service.findById(1L).getPassword()),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}