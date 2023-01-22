package com.tweteroo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.PersonDTO;
import com.tweteroo.api.model.Person;
import com.tweteroo.api.repository.AuthRepository;

@Service
public class AuthService {
    
    @Autowired
    private AuthRepository repository;

    public Person create (PersonDTO data){
        Person user = new Person(data);
        return repository.save(user);
    }
}
