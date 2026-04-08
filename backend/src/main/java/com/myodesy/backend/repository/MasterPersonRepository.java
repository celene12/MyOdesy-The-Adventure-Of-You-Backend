package com.myodesy.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.myodesy.backend.model.Person;

@Repository
public interface MasterPersonRepository extends JpaRepository<Person, Integer> {}