package com.tweteroo.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Person;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.repository.AuthRepository;
import com.tweteroo.api.repository.TweetRepository;

@Service
public class TweetService {

    @Autowired
    private TweetRepository repository;

    @Autowired
    private AuthRepository userRepository;

    public Tweet postTweet(TweetDTO data) {
        Optional<Person> user = userRepository.findByUsername(data.username());
        Tweet userTweet = new Tweet(data, user.get().getAvatar());
        return repository.save(userTweet);
    }

    public List<Tweet> getUserTweets(String username) {
        return repository.findByUsername(username);
    }

    public Page<Tweet> getTweets(int page, int size) {
        Sort sort = Sort.by("id").descending();
        PageRequest pageRequest = PageRequest.of(page, size, sort);

        return repository.findAll(pageRequest);
    }
}
