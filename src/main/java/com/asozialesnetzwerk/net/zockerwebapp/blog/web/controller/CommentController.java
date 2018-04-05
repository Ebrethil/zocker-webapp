package com.asozialesnetzwerk.net.zockerwebapp.blog.web.controller;

import com.asozialesnetzwerk.net.zockerwebapp.blog.model.Comment;
import com.asozialesnetzwerk.net.zockerwebapp.blog.model.Post;
import com.asozialesnetzwerk.net.zockerwebapp.blog.repository.CommentRepository;
import com.asozialesnetzwerk.net.zockerwebapp.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

   @Autowired
    public CommentController(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }


    @PostMapping("/api/post/{postId}/comment")
    public HttpEntity createComment(@PathVariable String postId, @RequestBody Comment comment) {
       comment.setPost(postRepository.findOne(postId));

       commentRepository.save(comment);

       return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("api/post/{postId}/comment")
    public HttpEntity<List<Comment>> getAllCommentsOfTopic(@PathVariable String postId) {
       return new ResponseEntity<>(commentRepository.findAllByPost_Id(postId), HttpStatus.FOUND);
    }
}
