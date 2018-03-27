package com.asozialesnetzwerk.net.zockerwebapp.blog.web.controller;

import com.asozialesnetzwerk.net.zockerwebapp.blog.model.Comment;
import com.asozialesnetzwerk.net.zockerwebapp.blog.repository.CommentRepository;
import com.asozialesnetzwerk.net.zockerwebapp.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

   @Autowired
    public CommentController(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public void createComment(@RequestBody Comment comment) {
       commentRepository.save(comment);
    }
}
