package com.asozialesnetzwerk.net.zockerwebapp.core.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class TestEntry {

    public TestEntry() {}

    public TestEntry(String content) {
        this.content = content;
    }

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private TestTopic testTopic;

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

    public TestTopic getTestTopic() {
        return testTopic;
    }

    public void setTestTopic(TestTopic testTopic) {
        this.testTopic = testTopic;
    }
}
