package com.geeksterTest.post.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geeksterTest.post.model.Post;
import com.geeksterTest.post.service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {
    
    @Autowired
    private PostService service;

    @GetMapping("/get-all-posts")
    public List<Post> getAllPosts(){
        return service.getPost();
    }

    @PostMapping("/add-posts")
    public ResponseEntity<String> addPost(@RequestBody Post post){
        int id = service.addPost(post);
        return new ResponseEntity<>(""+id, HttpStatus.OK);
    }
}
