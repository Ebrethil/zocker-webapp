package com.asozialesnetzwerk.net.zockerwebapp.blog.model;

import com.asozialesnetzwerk.net.zockerwebapp.users.model.User;
import org.springframework.data.annotation.Id;

import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Comment<T> {

    @Id
    private Long id;

    private String content;

    private User author;

    /**
     *  Depends if Comment belongs to Post or other Comment
     */
    private T parent;

    @OneToMany
    private LinkedList<Comment> subComments;

    private LocalDateTime created;

    private LocalDateTime modified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LinkedList<Comment> getSubComments() {
        return subComments;
    }

    public void setSubComments(LinkedList<Comment> subComments) {
        this.subComments = subComments;
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
