package com.asozialesnetzwerk.net.zockerwebapp.core.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Entry {

    public Entry() {}

    public Entry(String content) {
        this.content = content;
    }

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic testTopic;

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

    public Topic getTopic() {
        return testTopic;
    }

    public void setTopic(Topic testTopic) {
        this.testTopic = testTopic;
    }
}