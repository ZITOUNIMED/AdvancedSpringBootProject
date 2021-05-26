package com.example.tutosSpringBoot.reactiveProgramming.webClient;

import com.example.tutosSpringBoot.rest.responses.AuthResponse;

public class ConnectedUser {
    private static String email;
    private static String token;

    public static void setAuthData(AuthResponse authResponse) {
        email = authResponse.getEmail();
        token = authResponse.getToken();
    }

    public static String getToken(){return token;}
}
