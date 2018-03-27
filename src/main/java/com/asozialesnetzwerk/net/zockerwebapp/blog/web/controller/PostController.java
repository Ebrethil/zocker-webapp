package com.asozialesnetzwerk.net.zockerwebapp.blog.web.controller;

import com.asozialesnetzwerk.net.zockerwebapp.blog.model.Post;
import com.asozialesnetzwerk.net.zockerwebapp.blog.repository.CommentRepository;
import com.asozialesnetzwerk.net.zockerwebapp.blog.repository.PostRepository;
import com.asozialesnetzwerk.net.zockerwebapp.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public PostController(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public void createPost(@RequestBody Post post) {
        postRepository.save(post);
    }

    public void delete(@RequestBody Long id) {
        postRepository.delete(id);
    }

    public Post getPost(@RequestBody Long id) {
        return postRepository.findOne(id);
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public List<Post> getPostsByAuthor(@RequestBody Long id) {
        return postRepository.findAllByAuthor_Id(id);
    }
}
