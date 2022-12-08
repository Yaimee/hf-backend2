package com.example.hfbackend2.jwt.jwtutils;

import com.example.hfbackend2.login.service.LoginService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
//ny
@Service
public class JwtUserDetailsService implements UserDetailsService {
    LoginService service;
    private String username = "admin";//service.findById(1L).getUsername();
    private String password = "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6";//service.findById(1L).getPassword();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (this.username.equals(username)) {
            return new User(this.username,
                    this.password,
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}