package com.geeksterTest.post.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geeksterTest.post.dao.PostRepo;
import com.geeksterTest.post.model.Post;

@Service
public class PostService {

    @Autowired
    private PostRepo repo;

    public List<Post> getPost() {
        return repo.findAll();
    }

    public int addPost(Post post){
        repo.save(post);
        return post.getId();
    }
    
}
