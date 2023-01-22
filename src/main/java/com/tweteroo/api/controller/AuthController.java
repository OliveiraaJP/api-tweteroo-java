package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.PersonDTO;
import com.tweteroo.api.model.Person;
import com.tweteroo.api.service.AuthService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private AuthService service;

    @PostMapping("/sign-up")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Person signUp(@RequestBody @Valid PersonDTO data){
        return service.create(data);
    }
}
