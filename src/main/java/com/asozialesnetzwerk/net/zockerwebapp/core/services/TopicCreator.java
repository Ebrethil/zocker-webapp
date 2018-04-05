package com.asozialesnetzwerk.net.zockerwebapp.core.services;

import com.asozialesnetzwerk.net.zockerwebapp.core.model.Entry;
import com.asozialesnetzwerk.net.zockerwebapp.core.model.Topic;
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

    public void create(Topic testTopic) {
        for (Entry entry : testTopic.getEntries()) {
            entry.setTopic(testTopic);
        }

        topicRepository.save(testTopic);
    }
}
