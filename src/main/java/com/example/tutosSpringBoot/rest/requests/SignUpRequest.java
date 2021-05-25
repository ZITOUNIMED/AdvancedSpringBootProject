package com.example.tutosSpringBoot.rest.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String role;
    private String password;
    private String passwordConfirm;
}
