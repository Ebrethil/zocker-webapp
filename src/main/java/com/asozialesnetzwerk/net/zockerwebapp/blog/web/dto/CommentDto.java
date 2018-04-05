package com.asozialesnetzwerk.net.zockerwebapp.blog.web.dto;

import java.time.LocalDateTime;

public class CommentDto {

    private String id;

    private String content;

    private String postId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
