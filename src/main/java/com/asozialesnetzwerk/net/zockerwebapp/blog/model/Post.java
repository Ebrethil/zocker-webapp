package com.asozialesnetzwerk.net.zockerwebapp.blog.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//@JsonIdentityInfo(
//        generator=ObjectIdGenerators.PropertyGenerator.class,
//        property="id",
//        resolver = EntityIdResolver.class,
//        scope = Post.class
//)
@Entity
public class Post {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String title;

    private String content;

    private String author;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "dashboard_id")
    private Dashboard dashboard;

    private LocalDateTime created;

    private LocalDateTime modified;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
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

    public Dashboard getDashboard() {
        return dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }
}
