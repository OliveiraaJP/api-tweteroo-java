package com.tweteroo.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model.Person;

public interface AuthRepository extends JpaRepository<Person, Long> {
    
    Optional<Person> findByUsername(String username);
}
