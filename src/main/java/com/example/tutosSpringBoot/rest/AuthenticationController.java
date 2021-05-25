package com.example.tutosSpringBoot.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    
    @PostMapping("/signUp")
    public void signUp(){

    }

    @PostMapping("/login")
    public void login(){

    }

    public void logout(){}
}
