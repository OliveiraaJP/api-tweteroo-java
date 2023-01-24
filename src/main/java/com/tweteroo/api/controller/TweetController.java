package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.service.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {

    @Autowired
    private TweetService service;

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public Tweet postTweet(@RequestBody @Valid TweetDTO data) {
        return service.postTweet(data);
    }

    @GetMapping("/{username}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public List<Tweet> getUserTweets(@PathVariable String username) {
        return service.getUserTweets(username);
    }

    @GetMapping()
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Page<Tweet> list(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "5") int size) {
        return service.getTweets(page, size);
    }
}
