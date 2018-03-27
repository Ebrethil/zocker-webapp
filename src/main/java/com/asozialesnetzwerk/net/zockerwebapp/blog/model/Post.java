package com.asozialesnetzwerk.net.zockerwebapp.blog.model;

import com.asozialesnetzwerk.net.zockerwebapp.users.model.User;
import org.springframework.data.annotation.Id;

import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Post {

    @Id
    private Long id;

    private String title;

    private String content;

    private User author;

    @OneToMany
    private LinkedList<Comment> comments;

    private LocalDateTime created;

    private LocalDateTime modified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public LinkedList<Comment> getComments() {
        return comments;
    }

    public void setComments(LinkedList<Comment> comments) {
        this.comments = comments;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
