package com.myodesy.backend.dto;

import jakarta.validation.constraints.*;

public class RegisterRequest {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email format is not valid")
    private String email;

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    public String getFirstName()               { return firstName; }
    public void   setFirstName(String n)       { this.firstName = n; }
    public String getLastName()                { return lastName; }
    public void   setLastName(String a)        { this.lastName = a; }
    public String getEmail()                   { return email; }
    public void   setEmail(String c)           { this.email = c; }
    public String getUsername()                { return username; }
    public void   setUsername(String u)        { this.username = u; }
    public String getPassword()                { return password; }
    public void   setPassword(String p)        { this.password = p; }
}