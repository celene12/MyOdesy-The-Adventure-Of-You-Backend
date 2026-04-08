package com.myodesy.backend.repository;

import com.myodesy.backend.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, Integer> {
    Optional<SystemUser> findByEmail(String email);
    Optional<SystemUser> findByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}