package com.myodesy.backend.repository;

import com.myodesy.backend.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SystemUser, Long> {
}