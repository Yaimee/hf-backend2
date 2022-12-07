package com.example.hfbackend2.login.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "LOGIN")
public class Login {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public Login(String username, String password){
        this.username = username;
        this.password = password;
    }

    public Login updateFrom(Login object, boolean partial){
        if(!partial || object.username!=null) {this.username = object.username;}
        if(!partial || object.password!=null) {this.password = object.password;}
        return this;
    }
}
