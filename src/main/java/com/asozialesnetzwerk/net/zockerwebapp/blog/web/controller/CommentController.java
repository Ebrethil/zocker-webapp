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

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

   @Autowired
    public CommentController(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }


    @PostMapping("/api/comments")
    public HttpEntity createComment(@RequestBody CommentDto commentDto) {
       Post parentPost = postRepository.findOne(commentDto.getPostId());

       commentRepository.save(new Comment(commentDto.getContent(), parentPost));

       return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/api/comments/{id}")
    public HttpEntity updatePost(@RequestBody CommentDto commentDto) {
        Post parentPost = postRepository.findOne(commentDto.getPostId());

        commentRepository.save(new Comment(commentDto.getId(), commentDto.getContent(), parentPost));

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/api/comments/{id}")
    public HttpEntity delete(@PathVariable String id) {
        commentRepository.delete(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("api/comments")
    public HttpEntity<List<Comment>> getAllCommentsOfTopic(@RequestBody String postId) {
       return new ResponseEntity<>(commentRepository.findAllByPost_Id(postId), HttpStatus.FOUND);
    }
}
