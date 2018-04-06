package com.asozialesnetzwerk.net.zockerwebapp.blog.web.controller;

import com.asozialesnetzwerk.net.zockerwebapp.blog.model.Post;
import com.asozialesnetzwerk.net.zockerwebapp.blog.repository.PostRepository;
import com.asozialesnetzwerk.net.zockerwebapp.blog.web.dto.PostDto;
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

    @PostMapping("/api/posts")
    public HttpEntity createPost(@RequestBody PostDto postDto) {
        postRepository.save(new Post(postDto.getTitle(), postDto.getContent(), postDto.getDashboardId()));

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/api/posts/{id}")
    public HttpEntity updatePost(@PathVariable String id, @RequestBody PostDto postDto) {
        Post post = postRepository.findOne(id);

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

        postRepository.save(post);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/api/posts/{id}")
    public HttpEntity delete(@PathVariable String id) {
        postRepository.delete(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/api/posts/{id}")
    public HttpEntity<Post> getPost(@PathVariable String id) {
        return new ResponseEntity<>(postRepository.findOne(id), HttpStatus.OK);
    }

    @GetMapping("/api/posts")
    public HttpEntity<List<Post>> getPosts(@RequestParam(value = "dashboardId", required = false) String dashboardId) {
        if (dashboardId != null) {
            return new ResponseEntity<>(postRepository.findAllByDashboardId(dashboardId), HttpStatus.OK);
        }

        return new ResponseEntity<>(postRepository.findAll(), HttpStatus.OK);
    }
}
