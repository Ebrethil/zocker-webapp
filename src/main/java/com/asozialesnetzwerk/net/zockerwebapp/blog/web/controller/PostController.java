package com.asozialesnetzwerk.net.zockerwebapp.blog.web.controller;

import com.asozialesnetzwerk.net.zockerwebapp.blog.model.Post;
import com.asozialesnetzwerk.net.zockerwebapp.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private final PostRepository postRepository;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping("/api/dashboard/{dashboardId}/post")
    public HttpEntity createPost(@RequestBody Post post) {
        postRepository.save(post);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/api/dashboard/{dashboardId}/post/")
    public HttpEntity updatePost(@RequestBody Post post) {
        postRepository.save(post); //TODO: Check if repository.save(existingElement) automatically updates element

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/api/dashboard/{dashboardId}/post/{postId}")
    public HttpEntity delete(@PathVariable String postId) {
        postRepository.delete(postId);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/api/dashboard/{dashboardId}/post/{id}")
    public HttpEntity<Post> getPost(@PathVariable String id) {
        return new ResponseEntity<>(postRepository.findOne(id), HttpStatus.FOUND);
    }

    @GetMapping("/api/dashboard/{dashboardId}/post")
    public HttpEntity<List<Post>> getPostsByDashboard(@PathVariable String dashboardId) {
        return new ResponseEntity<>(postRepository.findAllByDashboard_Id(dashboardId), HttpStatus.FOUND);
    }


    @GetMapping("/api/post")
    public HttpEntity<List<Post>> getPosts() {
        return new ResponseEntity<>(postRepository.findAll(), HttpStatus.FOUND);
    }
}
