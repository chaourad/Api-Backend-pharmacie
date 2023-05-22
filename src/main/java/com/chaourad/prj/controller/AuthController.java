package com.chaourad.prj.controller;

import com.chaourad.prj.entites.User;
import com.chaourad.prj.entites.UserCredentials;
import com.chaourad.prj.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private AuthService authService;
/*
    @PostMapping("/login")
    public User login(@RequestBody UserCredentials credentials) {
        User user = authService.authenticate(credentials.getEmail(), credentials.getPassword());
    
        return user;
    }*/
   
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserCredentials credentials) {
        User user = authService.authenticate(credentials.getEmail(), credentials.getPassword());

        if (user != null) {
            if (user.getRole().equals("client")) {
             
                return ResponseEntity.ok(user);
            } else if (user.getRole().equals("pharmacien")) {
               
                return ResponseEntity.ok(user);
                
                
            } else if (user.getRole().equals("admin")) {
               
                return ResponseEntity.ok(user);
            } else {
           
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } else {
         
            return ResponseEntity.notFound().build();
        }
    }

}

 
