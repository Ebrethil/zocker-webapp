package com.asozialesnetzwerk.net.zockerwebapp.core.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TestTopic {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "topic")
    private List<TestEntry> entries = new ArrayList<>();

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

    public List<TestEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<TestEntry> entries) {
        this.entries = entries;
    }
}
