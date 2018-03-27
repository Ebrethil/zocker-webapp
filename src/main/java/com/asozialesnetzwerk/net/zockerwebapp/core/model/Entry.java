package com.asozialesnetzwerk.net.zockerwebapp.core.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Entry {

    //default constructor
    public Entry() {}

    public Entry(String content) {
        this.content = content;
    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

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
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
