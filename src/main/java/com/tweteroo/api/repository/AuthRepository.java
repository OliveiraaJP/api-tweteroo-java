package com.tweteroo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model.Person;

public interface AuthRepository extends JpaRepository<Person, Long> {
    
}
