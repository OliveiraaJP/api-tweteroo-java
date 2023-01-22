package com.tweteroo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long>{
    
}
