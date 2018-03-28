package com.asozialesnetzwerk.net.zockerwebapp.core.services;

import com.asozialesnetzwerk.net.zockerwebapp.core.model.TestEntry;
import com.asozialesnetzwerk.net.zockerwebapp.core.model.TestTopic;
import com.asozialesnetzwerk.net.zockerwebapp.core.repository.EntryRepository;
import com.asozialesnetzwerk.net.zockerwebapp.core.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicCreator {

    private final TopicRepository topicRepository;
    private final EntryRepository entryRepository;

    @Autowired
    public TopicCreator(TopicRepository topicRepository, EntryRepository entryRepository) {
        this.topicRepository = topicRepository;
        this.entryRepository = entryRepository;
    }

    public void create(TestTopic testTopic) {
        for (TestEntry entry : testTopic.getEntries()) {
            entry.setTestTopic(testTopic);
        }

        topicRepository.save(testTopic);
    }
}
