package com.myodesy.backend.service;

import com.myodesy.backend.model.SystemUser;
import com.myodesy.backend.repository.SystemUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final SystemUserRepository repository;

    public UserService(SystemUserRepository repository) {
        this.repository = repository;
    }

    public List<SystemUser> getAllUsers() {
        return repository.findAll();
    }

    public SystemUser getUserById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}