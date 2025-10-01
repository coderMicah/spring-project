package com.mika.demo;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticateUser(String name, String password) {

        boolean isValidUsername = name.equalsIgnoreCase("john doe");
        boolean isValidPassword = password.equalsIgnoreCase("password");

        return isValidPassword && isValidUsername;
    }
}
