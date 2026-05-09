package com.myodesy.backend.service;

import com.myodesy.backend.model.SystemUser;
import com.myodesy.backend.model.Person;
import com.myodesy.backend.repository.UserRepository;
import com.myodesy.backend.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteUserService {

    private final UserRepository userRepository;
    private final PersonRepository personRepository;

    public DeleteUserService(UserRepository userRepository, PersonRepository personRepository) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
    }

    @Transactional
    public void deleteUser(Long id) {
        SystemUser user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Person person = user.getPerson();

        user.setPerson(null);
        userRepository.delete(user);

        if (person != null) {
            personRepository.delete(person);
        }
    }
}