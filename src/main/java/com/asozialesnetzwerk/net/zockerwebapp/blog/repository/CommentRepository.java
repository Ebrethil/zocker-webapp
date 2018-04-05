package com.asozialesnetzwerk.net.zockerwebapp.blog.repository;

import com.asozialesnetzwerk.net.zockerwebapp.blog.model.Comment;
import com.asozialesnetzwerk.net.zockerwebapp.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {
    List<Comment> findAllByPost_Id(String id);
}