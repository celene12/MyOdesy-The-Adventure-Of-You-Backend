package com.myodesy.backend.service;

import com.myodesy.backend.dto.*;
import com.myodesy.backend.model.*;
import com.myodesy.backend.repository.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    private final SystemUserRepository  userRepo;
    private final MasterPersonRepository  personRepo;
    private final PasswordEncoder           passwordEncoder;
    private final JwtService                jwtService;

    public AuthService(SystemUserRepository userRepo,
                       MasterPersonRepository personRepo,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.userRepo     = userRepo;
        this.personRepo     = personRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtService      = jwtService;
    }

    @Transactional
    public AuthResponse registrar(RegisterRequest req) {
        if (userRepo.existsByEmail(req.getEmail()))
            throw new IllegalArgumentException("El correo ya está registrado");

        if (userRepo.existsByUsername(req.getUsername()))
            throw new IllegalArgumentException("El nombre de usuario ya está en uso");

        Person persona = new Person();
        persona.setFirstName(req.getFirstName());
        persona.setLastName(req.getLastName());

        personRepo.save(persona);

        System.out.println("PERSONA: " + persona.getFirstName() + " " + persona.getLastName());

        SystemUser user = new SystemUser();
        user.setEmail(req.getEmail());
        user.setUsername(req.getUsername());
        user.setPassword(passwordEncoder.encode(req.getPassword())); // encriptar
        user.setPerson(persona);
        userRepo.save(user);

        String token = jwtService.generateToken(user.getEmail());
        return new AuthResponse(token, user.getUsername(),
                                user.getEmail(), persona.getFirstName(), persona.getLastName());
    }

    public AuthResponse login(LoginRequest req) {
        SystemUser user = userRepo.findByEmail(req.getEmail())
            .orElseThrow(() -> new IllegalArgumentException("Correo o contraseña incorrectos"));

        if (!passwordEncoder.matches(req.getPassword(), user.getPassword()))
            throw new IllegalArgumentException("Correo o contraseña incorrectos");

        String token = jwtService.generateToken(user.getEmail());
        Person persona = user.getPerson();
        return new AuthResponse(token, user.getUsername(),
                                user.getEmail(), persona.getFirstName(), persona.getLastName());
    }
}