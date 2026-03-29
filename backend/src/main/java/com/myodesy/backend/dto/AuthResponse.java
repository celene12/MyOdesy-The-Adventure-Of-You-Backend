package com.myodesy.backend.dto;

public class AuthResponse {

    private String token;
    private String username;
    private String email;
    private String firstName;
    private String lastName;

    public AuthResponse(String token, String username,
                        String email, String firstName, String lastName) {
        this.token     = token;
        this.username  = username;
        this.email     = email;
        this.firstName = firstName;
        this.lastName  = lastName;
    }

    public String getToken()     { return token; }
    public String getUsername()  { return username; }
    public String getEmail()     { return email; }
    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName; }
}