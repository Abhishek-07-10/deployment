package com.geeksterTest.post.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geeksterTest.post.model.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
    
}
