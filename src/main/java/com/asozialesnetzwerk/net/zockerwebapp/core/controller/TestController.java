package com.asozialesnetzwerk.net.zockerwebapp.core.controller;

import com.asozialesnetzwerk.net.zockerwebapp.core.model.Entry;
import com.asozialesnetzwerk.net.zockerwebapp.core.model.Topic;
import com.asozialesnetzwerk.net.zockerwebapp.core.repository.EntryRepository;
import com.asozialesnetzwerk.net.zockerwebapp.core.repository.TopicRepository;
import com.asozialesnetzwerk.net.zockerwebapp.core.services.TopicCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    private final EntryRepository entryRepository;
    private final TopicRepository topicRepository;
    private final TopicCreator topicCreator;

    @Autowired
    public TestController(EntryRepository entryRepository, TopicRepository topicRepository, TopicCreator topicCreator) {
        this.entryRepository = entryRepository;
        this.topicRepository = topicRepository;
        this.topicCreator = topicCreator;
    }

    @GetMapping("/api/entry")
    public HttpEntity<Iterable<Entry>> getEntries()  {
        Iterable<Entry> entries = entryRepository.findAll();

        return new ResponseEntity<>(entries, HttpStatus.OK);
    }

    @PostMapping(value = "/api/entry")
    public HttpEntity<Entry> createEntry(@RequestBody Entry entry) {
        entryRepository.save(entry);

        return new ResponseEntity<>(entry, HttpStatus.CREATED);
    }

    @GetMapping("/api/topic")
    public HttpEntity<Iterable<Topic>> getTopics()  {
        Iterable<Topic> topics = topicRepository.findAll();

        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    @PostMapping(value = "/api/topic")
    public HttpEntity<Topic> createTopic(@RequestBody Topic testTopic) {
        topicRepository.save(testTopic);

        return new ResponseEntity<>(testTopic, HttpStatus.CREATED);
    }

    @GetMapping("/api/generate-topic")
    public HttpEntity<Topic> generateTopic()  {

        Topic testTopic = new Topic();
        testTopic.setTitle("FIRST TITLE");
        testTopic.setEntries(generateEntires());

        topicCreator.create(testTopic);

        return new ResponseEntity<>(testTopic, HttpStatus.OK);
    }

    private List<Entry> generateEntires() {
        List<Entry> entries = new ArrayList<>();

        entries.add(new Entry("Jubbelduuu"));
        entries.add(new Entry("JUHAYYYY"));
        entries.add(new Entry("Lorem Ipsum trallalaaa"));
        entries.add(new Entry("Pfahsel Hase"));

        return entries;
    }


}
