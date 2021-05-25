package com.example.tutosSpringBoot.rest;

import com.example.tutosSpringBoot.rest.requests.SignUpRequest;
import com.example.tutosSpringBoot.rest.responses.AuthResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    
    @PostMapping("/signUp")
    public ResponseEntity<AuthResponse> signUp(@RequestBody SignUpRequest request){
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(){
        return null;
    }

    public void logout(){}
}
