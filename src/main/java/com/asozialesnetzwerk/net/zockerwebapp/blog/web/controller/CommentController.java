package com.asozialesnetzwerk.net.zockerwebapp.blog.web.controller;

import com.asozialesnetzwerk.net.zockerwebapp.blog.model.Comment;
import com.asozialesnetzwerk.net.zockerwebapp.blog.model.Dashboard;
import com.asozialesnetzwerk.net.zockerwebapp.blog.model.Post;
import com.asozialesnetzwerk.net.zockerwebapp.blog.repository.CommentRepository;
import com.asozialesnetzwerk.net.zockerwebapp.blog.repository.PostRepository;
import com.asozialesnetzwerk.net.zockerwebapp.blog.web.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    private final CommentRepository commentRepository;

   @Autowired
    public CommentController(CommentRepository commentRepository) {
       this.commentRepository = commentRepository;
    }


    @PostMapping("/api/comments")
    public HttpEntity createComment(@RequestBody CommentDto commentDto) {
       commentRepository.save(new Comment(commentDto.getContent(), commentDto.getPostId()));

       return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/api/comments/{id}")
    public HttpEntity updatePost(@RequestBody CommentDto commentDto) {
        commentRepository.save(new Comment(commentDto.getId(), commentDto.getContent(), commentDto.getPostId()));

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/api/comments/{id}")
    public HttpEntity delete(@PathVariable String id) {
        commentRepository.delete(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("api/comments")
    public HttpEntity<List<Comment>> getComments(@RequestParam(value = "postId", required = false) String postId) {
       if (!postId.isEmpty()) {
           return new ResponseEntity<>(commentRepository.findAllByPostId(postId), HttpStatus.FOUND);
       }

       return new ResponseEntity<>(commentRepository.findAll(), HttpStatus.FOUND);
    }
}
