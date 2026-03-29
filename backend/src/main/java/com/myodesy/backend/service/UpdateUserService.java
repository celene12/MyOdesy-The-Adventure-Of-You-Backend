package com.myodesy.backend.service;

import com.myodesy.backend.dto.UpdateUserRequest;
import com.myodesy.backend.model.SystemUser;
import com.myodesy.backend.model.Person;
import com.myodesy.backend.repository.UserRepository;
import com.myodesy.backend.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateUserService {

    private final UserRepository userRepository;
    private final PersonRepository personRepository;

    public UpdateUserService(UserRepository userRepository, PersonRepository personRepository) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
    }

    @Transactional
    public SystemUser updateUser(Long id, UpdateUserRequest req) {

        SystemUser user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Person person = user.getPerson();

        if (req.getUsername() != null && !req.getUsername().isBlank()) {
            user.setUsername(req.getUsername());
        }

        if (req.getEmail() != null && !req.getEmail().isBlank()) {
           user.setEmail(req.getEmail());
        }

        if (req.getPassword() != null && !req.getPassword().isBlank()) {
            user.setPassword(req.getPassword());
        }

        if (person != null) {

            if (req.getFirstName() != null && !req.getFirstName().isBlank()) {
                person.setFirstName(req.getFirstName()); // nombre
            }

            if (req.getLastName() != null && !req.getLastName().isBlank()) {
               person.setLastName(req.getLastName()); // apellido
            }
            personRepository.save(person);
        }

        return userRepository.save(user);
    }
}